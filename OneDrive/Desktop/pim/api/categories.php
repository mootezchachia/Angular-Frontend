<?php

add_action('rest_api_init', function ($server) {
    register_rest_route(STM_LMS_API, '/categories', array(
        'methods' => 'GET',
        'callback' => function () {

            $data = array(
                'categories' => array()
            );

            $terms = array();
            $terms_all = stm_lms_api_get_terms_with_meta( '', 'stm_lms_course_taxonomy', ['orderby' => 'count', 'order' => 'DESC', 'number' => 10] );

            if( ! empty( $terms_all ) ){
                foreach ($terms_all as $term) {
                    $meta_value = get_term_meta( $term->term_id, 'course_app_image', true );
                    $color = get_term_meta( $term->term_id, 'course_color', true );
                    if(empty($color)) $color = null;

                    $term_data = array(
                        'id' => $term->term_id,
                        'name' => $term->name,
                        'count' => $term->count,
                        'color' => $color,
                    );

                    $term_data['image'] = !empty($meta_value) ? stm_lms_api_image($meta_value, 100, 100) : null;

                    $terms[] = $term_data;
                }
            }

            wp_send_json($terms);
        },
    ));
});

function stm_lms_api_get_terms_with_meta($meta_key, $taxonomy = null, $args = array())
{

    if (empty($taxonomy)) $taxonomy = 'stm_lms_course_taxonomy';

    $term_args = array(
        'taxonomy' => $taxonomy,
        'hide_empty' => false,
        'fields' => 'all',
    );

    if (!empty($meta_key)) {
        $term_args['meta_key'] = $meta_key;
        $term_args['meta_value'] = '';
        $term_args['meta_compare'] = '!=';
    }

    $term_args = wp_parse_args($args, $term_args);

    $term_query = new WP_Term_Query($term_args);

    if (empty($term_query->terms)) {
        return false;
    }

    return $term_query->terms;
}