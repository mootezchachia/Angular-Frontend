<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Certificate_model extends CI_Model
{

	function __construct()
	{
		parent::__construct();
	}

	/*
	* CERTIFICATE OPERATIONS
	*/
	// If the course progress is 100%, create certificate
	function check_certificate_eligibility($checker_type = "", $checker_id = "", $user_id = ""){
		$course_id = 0;
		if ($checker_type == 'lesson') {
			$lesson_details = $this->db->get_where('lesson', array('id' => $checker_id))->row_array();
			$course_id = $lesson_details['course_id'];
		}else{
			$course_id = $checker_id;
		}
		$course_progress = course_progress($course_id, $user_id);
		if ($course_progress == 100) {
			$checker = array(
				'course_id' => $course_id,
				'student_id' => $user_id
			);
			$previous_data = $this->db->get_where('certificates', $checker)->num_rows();
			if($previous_data == 0){

				$certificate_identifier = substr(sha1($user_id.'-'.$course_id.'-'.date('d-M-Y')), 0, 10);
				$certificate_link = base_url('uploads/certificates/'.$certificate_identifier.'.jpg');
				$insert_data = array(
					'course_id' => $course_id,
					'student_id' => $user_id,
					'shareable_url' => $certificate_identifier.'.jpg'
				);
				$this->db->insert('certificates', $insert_data);
				$this->create_certificate($user_id, $course_id, $certificate_identifier);
				$this->email_model->notify_on_certificate_generate($user_id, $course_id);
			}
		}
	}

	//CERTIFICATE CREATION CODE
	public function create_certificate($user_id = "", $course_id = "", $certificate_identifier = "") {

		// USER DETAILS
		$user_details = $this->user_model->get_all_user($user_id)->row_array();
		$user_name = $user_details['first_name'].' '.$user_details['last_name'];
		// COURSE DETAILS
		$course_details = $this->crud_model->get_course_by_id($course_id)->row_array();
		$course_name = $course_details['title'];
		// INSTRUCTOR DETAILS
		$instructor_details = $this->user_model->get_all_user($course_details['user_id'])->row_array();
		$instructor_name = $instructor_details['first_name'].' '.$instructor_details['last_name'];
		//CERTIFICATE DETAILS
		$certificate_details = $this->db->get_where('certificates', array('shareable_url' => $certificate_identifier.'.jpg'))->row_array();
		$certificate_no = sprintf('%08d', $certificate_details['id']);
		$certificate_url = site_url('certificate/'.$certificate_identifier);

		$certificate_template = get_settings('certificate_template');

		if (strpos($certificate_template, '{student}') != false) {
			$certificate_template = str_replace('{student}', $user_name, $certificate_template);
		}

		if (strpos($certificate_template, '{course}') != false) {
			$certificate_template = str_replace('{course}', $course_name, $certificate_template);
		}

		// MAKE A COPY OF CERTIFICATE TEMPLATE
		$certificate_src = './uploads/certificates/'.$certificate_identifier.'.jpg';
		copy('./uploads/certificates/template.jpg', $certificate_src);

		$splited_certificate_template = explode( "\n", wordwrap( $certificate_template, 70));
		$splited_certificate_template_part = count($splited_certificate_template);

		for ($i=0; $i < $splited_certificate_template_part; $i++) {
			$vrt_offset = 340;
			$line_number = $i + 1;

			// CONFIG CERTIFICATE TEMPLATE
			$this->load->library('image_lib');
			$config_certificate['image_library'] = 'gd2';
			$config_certificate['source_image'] = $certificate_src;
			$config_certificate['wm_text'] = $splited_certificate_template[$i];
			$config_certificate['wm_type'] = 'text';
			$config_certificate['wm_font_path'] = './system/fonts/Palatino.ttf';
			$config_certificate['wm_font_size'] = '18';
			$config_certificate['wm_font_color'] = '2C5C8F';
			$config_certificate['wm_vrt_alignment'] = 'top';
			$config_certificate['wm_hor_alignment'] = 'center';
			$config_certificate['wm_padding'] = '0';
			$config_certificate['wm_hor_offset'] = '0';
			$config_certificate['wm_vrt_offset'] = $vrt_offset + (40 * $i);
			$config_certificate['quality'] = '100%';

			$this->image_lib->initialize($config_certificate);

			if ( ! $this->image_lib->watermark())
			{
				echo $this->image_lib->display_errors();
			}
		}

		//INSTRUCTOR PLEBEYA CONFIG
		$config_instructor_name_plebeya['image_library'] = 'gd2';
		$config_instructor_name_plebeya['source_image'] = $certificate_src;
		$config_instructor_name_plebeya['wm_text'] = $instructor_name;
		$config_instructor_name_plebeya['wm_type'] = 'text';
		$config_instructor_name_plebeya['wm_font_path'] = './system/fonts/Plebeya.otf';
		$config_instructor_name_plebeya['wm_font_size'] = '22';
		$config_instructor_name_plebeya['wm_font_color'] = '2C5C8F';
		$config_instructor_name_plebeya['wm_vrt_alignment'] = 'top';
		$config_instructor_name_plebeya['wm_hor_alignment'] = 'left';
		$config_instructor_name_plebeya['wm_padding'] = '0';
		$config_instructor_name_plebeya['wm_hor_offset'] = '95';
		$config_instructor_name_plebeya['wm_vrt_offset'] = '585';
		$config_instructor_name_plebeya['quality'] = '100%';

		$this->image_lib->initialize($config_instructor_name_plebeya);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}

		//INSTRUCTOR PALATINO CONFIG
		$config_instructor_name_palatino['image_library'] = 'gd2';
		$config_instructor_name_palatino['source_image'] = $certificate_src;
		$config_instructor_name_palatino['wm_text'] = $instructor_name;
		$config_instructor_name_palatino['wm_type'] = 'text';
		$config_instructor_name_palatino['wm_font_path'] = './system/fonts/Palatino.ttf';
		$config_instructor_name_palatino['wm_font_size'] = '13';
		$config_instructor_name_palatino['wm_font_color'] = '2C5C8F';
		$config_instructor_name_palatino['wm_vrt_alignment'] = 'top';
		$config_instructor_name_palatino['wm_hor_alignment'] = 'left';
		$config_instructor_name_palatino['wm_padding'] = '0';
		$config_instructor_name_palatino['wm_hor_offset'] = '95';
		$config_instructor_name_palatino['wm_vrt_offset'] = '625';
		$config_instructor_name_palatino['quality'] = '100%';

		$this->image_lib->initialize($config_instructor_name_palatino);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}

		//DATE CONFIG PLEBEYA
		$config_date_plebeya['image_library'] = 'gd2';
		$config_date_plebeya['source_image'] = $certificate_src;
		$config_date_plebeya['wm_text'] = date('d F Y');
		$config_date_plebeya['wm_type'] = 'text';
		$config_date_plebeya['wm_font_path'] = './system/fonts/Plebeya.otf';
		$config_date_plebeya['wm_font_size'] = '22';
		$config_date_plebeya['wm_font_color'] = '2C5C8F';
		$config_date_plebeya['wm_vrt_alignment'] = 'top';
		$config_date_plebeya['wm_hor_alignment'] = 'right';
		$config_date_plebeya['wm_padding'] = '0';
		$config_date_plebeya['wm_hor_offset'] = '-105';
		$config_date_plebeya['wm_vrt_offset'] = '585';
		$config_date_plebeya['quality'] = '100%';

		$this->image_lib->initialize($config_date_plebeya);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}

		//DATE CONFIG PALATINO
		$config_date_palatino['image_library'] = 'gd2';
		$config_date_palatino['source_image'] = $certificate_src;
		$config_date_palatino['wm_text'] = "Date";
		$config_date_palatino['wm_type'] = 'text';
		$config_date_palatino['wm_font_path'] = './system/fonts/Palatino.ttf';
		$config_date_palatino['wm_font_size'] = '13';
		$config_date_palatino['wm_font_color'] = '2C5C8F';
		$config_date_palatino['wm_vrt_alignment'] = 'top';
		$config_date_palatino['wm_hor_alignment'] = 'right';
		$config_date_palatino['wm_padding'] = '0';
		$config_date_palatino['wm_hor_offset'] = '-105';
		$config_date_palatino['wm_vrt_offset'] = '625';
		$config_date_palatino['quality'] = '100%';

		$this->image_lib->initialize($config_date_palatino);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}

		// CERTIFICATE NUMBER CONFIG PALATINO
		$config_certificate_number_palatino['image_library'] = 'gd2';
		$config_certificate_number_palatino['source_image'] = $certificate_src;
		$config_certificate_number_palatino['wm_text'] = "Certificate ID: #".$certificate_no;
		$config_certificate_number_palatino['wm_type'] = 'text';
		$config_certificate_number_palatino['wm_font_path'] = './system/fonts/Palatino.ttf';
		$config_certificate_number_palatino['wm_font_size'] = '7';
		$config_certificate_number_palatino['wm_font_color'] = '757575';
		$config_certificate_number_palatino['wm_vrt_alignment'] = 'top';
		$config_certificate_number_palatino['wm_hor_alignment'] = 'left';
		$config_certificate_number_palatino['wm_padding'] = '0';
		$config_certificate_number_palatino['wm_hor_offset'] = '200';
		$config_certificate_number_palatino['wm_vrt_offset'] = '702';
		$config_certificate_number_palatino['quality'] = '100%';

		$this->image_lib->initialize($config_certificate_number_palatino);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}

		// CERTIFICATE URL CONFIG PALATINO
		$config_certificate_url_palatino['image_library'] = 'gd2';
		$config_certificate_url_palatino['source_image'] = $certificate_src;
		$config_certificate_url_palatino['wm_text'] = "Certificate URL: ".$certificate_url;
		$config_certificate_url_palatino['wm_type'] = 'text';
		$config_certificate_url_palatino['wm_font_path'] = './system/fonts/Palatino.ttf';
		$config_certificate_url_palatino['wm_font_size'] = '7';
		$config_certificate_url_palatino['wm_font_color'] = '757575';
		$config_certificate_url_palatino['wm_vrt_alignment'] = 'top';
		$config_certificate_url_palatino['wm_hor_alignment'] = 'right';
		$config_certificate_url_palatino['wm_padding'] = '0';
		$config_certificate_url_palatino['wm_hor_offset'] = '-105';
		$config_certificate_url_palatino['wm_vrt_offset'] = '702';
		$config_certificate_url_palatino['quality'] = '100%';

		$this->image_lib->initialize($config_certificate_url_palatino);

		if ( ! $this->image_lib->watermark())
		{
			echo $this->image_lib->display_errors();
		}
	}

	//CERTIFICATE TEMPLATE TEXT UPDATE
	public function update_certificate_template_text() {
		$data['value'] = $this->input->post('certificate_template');
		if (strlen($this->input->post('certificate_template')) > 120 || strlen($this->input->post('certificate_template')) == 0) {
			$this->session->set_flashdata('error_message', get_phrase('certificate_template_has_a_limit_of_120_charecters_and_it_can_not_be_empty_either'));
			redirect(site_url('addons/certificate/settings'), 'refresh');
		}

		$this->db->where('key', 'certificate_template');
		$this->db->update('settings', $data);
		$this->session->set_flashdata('flash_message', get_phrase('certificate_template_has_been_updated'));
		redirect(site_url('addons/certificate/settings'), 'refresh');
	}
	//CERTIFICATE TEMPLATE UPDATE
	public function update_certificate_template() {

		$max_size = 1048576; //1MB in bytes

		if ($_FILES['certificate_template']['error'] === UPLOAD_ERR_OK) {

			if (isset($_FILES['certificate_template']) && $_FILES['certificate_template']['name'] != "") {
				if ($_FILES['certificate_template']['size'] > $max_size) {
					$this->session->set_flashdata('error_message', get_phrase('file_size_has_to_be_less_than_1MB'));
					redirect(site_url('addons/certificate/settings'), 'refresh');
				}
				move_uploaded_file($_FILES['certificate_template']['tmp_name'], 'uploads/certificates/template.jpg');
				$this->session->set_flashdata('flash_message', get_phrase('template_updated_successfully'));
				redirect(site_url('addons/certificate/settings'), 'refresh');
			}

		} else {
			$this->session->set_flashdata('error_message', get_phrase('invalid_file'));
			redirect(site_url('addons/certificate/settings'), 'refresh');
			//die("Upload failed with error code " . $_FILES['file']['error']);
		}
	}

	// FOR GETTING CERTIFICATE SHAREABLE URL
	public function get_certificate_url($user_id = "", $course_id = "") {
		$checker = array(
			'course_id' => $course_id,
			'student_id' => $user_id
		);
		$result = $this->db->get_where('certificates', $checker);
		if ($result->num_rows() > 0) {
			$result = $result->row_array();
			$exploded_result = explode('.',$result['shareable_url']);
			return site_url('certificate/'.$exploded_result[0]) ;
		}else{
			return "#";
		}
	}
}
