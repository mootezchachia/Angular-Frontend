<?php
$CI = get_instance();
$CI->load->database();
$CI->load->dbforge();


// CREATING CERTIFICATE TABLE
$fields = array(
	'id' => array(
		'type' => 'INT',
		'constraint' => 11,
		'unsigned' => TRUE,
		'auto_increment' => TRUE,
		'collation' => 'utf8_unicode_ci'
	),
	'student_id' => array(
		'type' => 'INT',
		'constraint' => '11',
		'default' => null,
		'null' => TRUE,
		'collation' => 'utf8_unicode_ci'
	),
	'course_id' => array(
		'type' => 'INT',
		'constraint' => '11',
		'default' => null,
		'null' => TRUE,
		'collation' => 'utf8_unicode_ci'
	),
	'shareable_url' => array(
		'type' => 'VARCHAR',
		'constraint' => '255',
		'default' => null,
		'null' => TRUE,
		'collation' => 'utf8_unicode_ci'
	)
);
$CI->dbforge->add_field($fields);
$CI->dbforge->add_key('id', TRUE);
$attributes = array('collation' => "utf8_unicode_ci");
$CI->dbforge->create_table('certificates', TRUE);


// INSERT DATA IN SETTINGS TABLE
$settings_data = array( 'key' => 'certificate_template', 'value' => 'This is to certify that Mr. / Ms. {student} successfully completed the course with on certificate for {course}.' );
$CI->db->insert('settings', $settings_data);
?>
