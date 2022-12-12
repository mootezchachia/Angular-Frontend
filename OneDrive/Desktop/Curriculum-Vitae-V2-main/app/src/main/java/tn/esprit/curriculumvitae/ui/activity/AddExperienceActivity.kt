package tn.esprit.curriculumvitae.ui.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.data.Experience
import tn.esprit.curriculumvitae.utils.AppDataBase

class AddExperienceActivity : AppCompatActivity() {

    private var selectedImageUri: Uri? = null

    lateinit var companyPic: ImageView

    lateinit var txtCompanyName: TextInputEditText
    lateinit var txtCompanyAddress: TextInputEditText
    lateinit var txtStartDate: TextInputEditText
    lateinit var txtEndDate: TextInputEditText

    lateinit var txtLayoutCompanyName: TextInputLayout
    lateinit var txtLayoutCompanyAddress: TextInputLayout
    lateinit var txtLayoutStartDate: TextInputLayout
    lateinit var txtLayoutEndDate: TextInputLayout

    lateinit var btnSave: MaterialButton

    private val startForResultOpenGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data!!.data
            companyPic.setImageURI(selectedImageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)

        val toolbar: Toolbar = findViewById(R.id.app_bar)

        toolbar.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Add Experience"

        companyPic = findViewById(R.id.companyPic)
        txtCompanyName = findViewById(R.id.txtCompanyName)
        txtCompanyAddress = findViewById(R.id.txtCompanyAddress)
        txtStartDate = findViewById(R.id.txtStartDate)
        txtEndDate = findViewById(R.id.txtEndDate)

        txtLayoutCompanyName = findViewById(R.id.txtLayoutCompanyName)
        txtLayoutCompanyAddress = findViewById(R.id.txtLayoutCompanyAddress)
        txtLayoutStartDate = findViewById(R.id.txtLayoutStartDate)
        txtLayoutEndDate = findViewById(R.id.txtLayoutEndDate)

        btnSave = findViewById(R.id.btnSave)

        val startDatePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select start date")
            .build()

        val endDatePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select end date")
            .build()

        startDatePicker.addOnPositiveButtonClickListener {
            txtStartDate.setText(startDatePicker.headerText.toString())
        }

        endDatePicker.addOnPositiveButtonClickListener {
            txtEndDate.setText(endDatePicker.headerText.toString())
        }

        txtStartDate.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                startDatePicker.show(supportFragmentManager, "START_DATE")
            }else{
                startDatePicker.dismiss()
            }
        }

        txtEndDate.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus){
                endDatePicker.show(supportFragmentManager, "END_DATE")
            }else{
                endDatePicker.dismiss()
            }
        }

        companyPic.setOnClickListener {
            openGallery()
        }

        btnSave.setOnClickListener {
            if (validate()){
                AppDataBase.getDatabase(this).experienceDao().insert(
                    Experience(
                        txtCompanyName.text.toString(),
                        txtCompanyAddress.text.toString(),
                        txtStartDate.text.toString(),
                        txtEndDate.text.toString(),
                        selectedImageUri.toString(),
                        getString(R.string.loremIpsum)
                    )
                )
                finish()
            }
        }

    }

    private fun openGallery(){
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startForResultOpenGallery.launch(intent)
    }

    private fun validate(): Boolean {
        txtLayoutCompanyName.error = null
        txtLayoutCompanyAddress.error = null
        txtLayoutStartDate.error = null
        txtLayoutEndDate.error = null

        if (selectedImageUri == null){
            Snackbar.make(
                findViewById(R.id.constraint_Layout),
                "Please select a logo for the company !",
                Snackbar.LENGTH_SHORT
            ).setBackgroundTint(getColor(R.color.colorPrimaryFade2)).show()
            return false
        }

        if (txtCompanyName.text!!.isEmpty()){
            txtLayoutCompanyName.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtCompanyAddress.text!!.isEmpty()){
            txtLayoutCompanyAddress.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtStartDate.text!!.isEmpty()){
            txtLayoutStartDate.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtEndDate.text!!.isEmpty()){
            txtLayoutEndDate.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        return true
    }
}