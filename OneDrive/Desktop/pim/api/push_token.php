<?php
add_action('rest_api_init', function ($server) {
    register_rest_route(STM_LMS_API, '/registration', array(
        'methods' => 'POST',
        'args' => array(
            'login' => array(
                'required' => true,
                'sanitize_callback' => 'sanitize_text_field'
            ),
        ),
        'callback' => function ($request) {


        },
    ));
});