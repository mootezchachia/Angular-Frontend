<?php
add_action('rest_api_init', function ($server) {
    register_rest_route(STM_LMS_API, '/verify_purchase', array(
        'args' => array(
            'receipt' => array(
                'required' => true,
            ),
        ),
        array(
            'methods' => 'POST',
            'callback' => function ($request) {

                $token = $request->get_header('token');
                $user_token = stm_lms_api_token($token);
                if (is_wp_error($user_token)) return $user_token;
                $user_id = (empty($user_id)) ? $user_token : $user_id;

                $json['receipt-data'] = $request->get_param('receipt');

                $post = json_encode($json);

                $mode = 'buy';
                $app_options = get_option('ms_lms_api_options', array());
                if(!empty($app_options['in_app_purchase_mode']) && $app_options['in_app_purchase_mode']) $mode = 'sandbox';

                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, "https://{$mode}.itunes.apple.com/verifyReceipt");
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                curl_setopt($ch, CURLOPT_POST, 1);
                curl_setopt($ch, CURLOPT_POSTFIELDS, $post);
                $result = curl_exec($ch);

                curl_close($ch);

                $result = json_decode($result, true);

                $added = stm_lms_api_add_courses($result, $user_id);

                if (!$added) return new WP_Error(
                    'invalid_status',
                    esc_html__('Invalid status', 'masterstudy-lms-learning-management-system'),
                    array('status' => 400)
                );

                return $added;
            }
        ),
    ));
});

function stm_lms_api_add_courses($result, $user_id)
{

    $status = (isset($result['status']) && !$result['status']) ? true : false;

    if (!$status) return false;

    $courses = (!empty($result['receipt']['in_app'])) ? $result['receipt']['in_app'] : false;

    if (!$courses) return false;

    $items = array();

    foreach ($courses as $course) {

        $course_id = $course['product_id'];

        if (get_post_type($course_id) !== 'stm-courses') continue;

        $price = (!empty($course['price'])) ? $course['price'] : STM_LMS_Course::get_course_price($course_id);

        $items[] = array(
            'item_id' => $course_id,
            'price' => $price,
            'enterprise' => '0',
            'bundle' => '0',
        );
    }

    $payment_code = 'in_app';
    $symbol = STM_LMS_Options::get_option('currency_symbol', 'none');
    $cart_total = STM_LMS_Cart::get_cart_totals($items);

    /*Create ORDER*/
    $invoice = STM_LMS_Order::create_order([
        "user_id" => $user_id,
        "cart_items" => $items,
        "payment_code" => $payment_code,
        "_order_total" => $cart_total['total'],
        "_order_currency" => $symbol
    ], true);

    do_action('order_created', $user_id, $items, $payment_code, $invoice);

    update_post_meta($invoice, 'status', 'completed');

    update_post_meta($invoice, 'in_app_receipt', $result);

    STM_LMS_Order::accept_order($user_id, $invoice);

    return $invoice;

}