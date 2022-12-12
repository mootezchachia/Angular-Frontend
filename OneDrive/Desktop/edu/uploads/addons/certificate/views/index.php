
<!DOCTYPE html>
<html>
<head>
    <title><?php echo get_phrase('certification'); ?></title>
    <link rel="shortcut icon" href="<?php echo base_url();?>uploads/system/favicon.png">
    <link href="<?php echo base_url('assets/backend/css/app.min.css') ?>" rel="stylesheet" type="text/css" />
</head>
<body>
    <div style="text-align: center">
        <?php if ($validity): ?>
            <div class="row">
                <div class="col">
                    <img src="<?php echo base_url('uploads/certificates/'.$src.'.jpg'); ?>" alt="" width="70%">
                </div>
            </div>
            <br>
            <a href="<?php echo site_url('addons/certificate/download/'.$src); ?>" type="button" class="btn btn-primary" name="button">Download</a>
        <?php else: ?>
            <h2><?php echo get_phrase('please_complete_your_course_to_get_certificate'); ?></h2>
        <?php endif; ?>

    </div>
</body>
</html>
