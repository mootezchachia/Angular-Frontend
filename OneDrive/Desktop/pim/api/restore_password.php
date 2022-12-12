<?php

add_action('rest_api_init', function ($server) {

    register_rest_route(STM_LMS_API, '/account/restore_password', array(
        'args' => array(
            'email' => array(
                'required' => true,
            ),
        ),
        array(
            'methods' => 'POST',
            'callback' => function ($request) {

                $user_login = $request->get_param('email');

                $errors = new WP_Error();

                if (empty($user_login) || !is_string($user_login)) {
                    $errors->add('empty_username', __('<strong>ERROR</strong>: Enter a username or email address.'));
                } elseif (strpos($user_login, '@')) {
                    $user_data = get_user_by('email', trim(wp_unslash($user_login)));
                    if (empty($user_data)) {
                        $errors->add('invalid_email', __('<strong>ERROR</strong>: There is no account with that username or email address.'));
                    }
                } else {
                    $login = trim($user_login);
                    $user_data = get_user_by('login', $login);
                }

                if ($errors->has_errors()) {
                    return (array(
                        'status' => 'error',
                        'message' => $errors->get_error_message()
                    ));
                }

                if (!$user_data) {
                    return (array(
                        'status' => 'error',
                        'message' => __('ERROR: There is no account with that username or email address.')
                    ));
                }

                // Redefining user_login ensures we return the right case in the email.
                $user_login = $user_data->user_login;
                $user_email = $user_data->user_email;
                $key = get_password_reset_key($user_data);

                if (is_wp_error($key)) {
                    return array(
                        'status' => 'error',
                        'message' => __('ERROR: There is no account with that username or email address.')
                    );
                }

                if (is_multisite()) {
                    $site_name = get_network()->site_name;
                } else {
                    $site_name = wp_specialchars_decode(get_option('blogname'), ENT_QUOTES);
                }

                $token = $user_data->ID . '*' . bin2hex(openssl_random_pseudo_bytes(16));
                update_user_meta($user_data->ID, 'restore_password_token', $token);
                $reset_url = add_query_arg('restore_password', $token, STM_LMS_User::login_page_url());

                $message = __('Someone has requested a password reset for the following account:') . "\r\n\r\n";
                /* translators: %s: site name */
                $message .= sprintf(__('Site Name: %s'), $site_name) . "\r\n\r\n";
                /* translators: %s: user login */
                $message .= sprintf(__('Username: %s'), $user_login) . "\r\n\r\n";
                $message .= __('If this was a mistake, just ignore this email and nothing will happen.') . "\r\n\r\n";
                $message .= __('To reset your password, visit the following address:') . "\r\n\r\n";
                $message .= '<' . $reset_url . ">\r\n";

                /* translators: Password reset notification email subject. %s: Site title */
                $title = sprintf(__('[%s] Password Reset'), $site_name);

                $title = apply_filters('retrieve_password_title', $title, $user_login, $user_data);
                $message = apply_filters('retrieve_password_message', stripslashes($message), $key, $user_login, $user_data);

                if ($message && !wp_mail($user_email, wp_specialchars_decode($title), $message)) {
                    return array(
                        'status' => 'error',
                        'message' => esc_html__('Cant send E-mail.', 'masterstudy-lms-learning-management-system')
                    );
                }

                $r = array(
                    'status' => 'success',
                    'message' => esc_html__('Further Instructions sent on E-mail.', 'masterstudy-lms-learning-management-system')
                );

                return $r;
            },
        )
    ));
});