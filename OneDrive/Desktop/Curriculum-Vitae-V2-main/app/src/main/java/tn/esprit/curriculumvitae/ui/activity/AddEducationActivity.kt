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
import tn.esprit.curriculumvitae.data.Education
import tn.esprit.curriculumvitae.utils.AppDataBase

class AddEducationActivity : AppCompatActivity() {

    private var selectedImageUri: Uri? = null

    lateinit var univPic: ImageView

    lateinit var txtUnivName: TextInputEditText
    lateinit var txtUnivAddress: TextInputEditText
    lateinit var txtStartDate: TextInputEditText
    lateinit var txtEndDate: TextInputEditText

    lateinit var txtLayoutUnivName: TextInputLayout
    lateinit var txtLayoutUnivAddress: TextInputLayout
    lateinit var txtLayoutStartDate: TextInputLayout
    lateinit var txtLayoutEndDate: TextInputLayout

    lateinit var btnSave: MaterialButton

    private val startForResultOpenGallery = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            selectedImageUri = result.data!!.data
            univPic.setImageURI(selectedImageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_education)

        val toolbar: Toolbar = findViewById(R.id.app_bar)

        toolbar.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Add Education"

        univPic = findViewById(R.id.univPic)

        txtUnivName = findViewById(R.id.txtUnivName)
        txtUnivAddress = findViewById(R.id.txtUnivAddress)
        txtStartDate = findViewById(R.id.txtStartDate)
        txtEndDate = findViewById(R.id.txtEndDate)

        txtLayoutUnivName = findViewById(R.id.txtLayoutUnivName)
        txtLayoutUnivAddress = findViewById(R.id.txtLayoutUnivAddress)
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

        univPic.setOnClickListener {
            openGallery()
        }

        btnSave.setOnClickListener {
            if (validate()){
                AppDataBase.getDatabase(this).educationDao().insert(
                    Education(
                        txtUnivName.text.toString(),
                        txtUnivAddress.text.toString(),
                        txtStartDate.text.toString(),
                        txtEndDate.text.toString(),
                        selectedImageUri.toString()
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
        txtLayoutUnivName.error = null
        txtLayoutUnivAddress.error = null
        txtLayoutStartDate.error = null
        txtLayoutEndDate.error = null

        if (selectedImageUri == null){
            Snackbar.make(
                findViewById(R.id.constraint_Layout),
                "Please select a logo for the university !",
                Snackbar.LENGTH_SHORT
            ).setBackgroundTint(getColor(R.color.colorPrimaryFade2)).show()
            return false
        }

        if (txtUnivName.text!!.isEmpty()){
            txtLayoutUnivName.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (txtUnivAddress.text!!.isEmpty()){
            txtLayoutUnivAddress.error = getString(R.string.mustNotBeEmpty)
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