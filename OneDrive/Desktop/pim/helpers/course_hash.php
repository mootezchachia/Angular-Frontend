<?php

new STM_LMS_API_Course_Hash();

class STM_LMS_API_Course_Hash {

    static $hash_name = 'stm_lms_course_hash';

    public function __construct()
    {
        add_action( 'save_post', array($this, 'lms_item_updated'));
    }

    static function get_course_hash($course_id) {

        $hash = get_post_meta($course_id, self::$hash_name, true);

        if(!empty($hash)) return $hash;

        return self::generate_course_hash($course_id);

    }

    static function generate_course_hash($course_id) {

        $time = time();
        $hash = md5("hash{$course_id}{$time}");

        update_post_meta($course_id, self::$hash_name, $hash);

        return $hash;

    }

    function lms_item_updated($post_id) {
        $post_type = get_post_type($post_id);

        /*Only regenerate course hash*/
        if($post_type === 'stm-courses') self::generate_course_hash($post_id);

        if($post_type === 'stm-lessons') {
            $args = array(
                'post_type' => 'stm-courses',
                'posts_per_page' => '-1',
                'post_status' => array('publish'),
                'meta_query' => array(
                    array(
                        'key' => 'curriculum',
                        'value' => $post_id,
                        'compare' => 'LIKE'
                    )
                )
            );

            $q = new WP_Query($args);

            if ($q->have_posts()) {
                while ($q->have_posts()) {
                    $q->the_post();
                    self::generate_course_hash(get_the_ID());
                }
            }
        }
    }

}