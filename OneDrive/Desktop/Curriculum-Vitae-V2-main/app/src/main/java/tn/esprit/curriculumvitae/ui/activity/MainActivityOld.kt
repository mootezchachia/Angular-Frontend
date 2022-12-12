package tn.esprit.curriculumvitae.ui.activity

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.curriculumvitae.R

class MainActivityOld : AppCompatActivity() {

    private var profilePic: ImageView? = null
    private var txtFullName: TextView? = null
    private var txtAge: TextView? = null
    private var txtEmail: TextView? = null
    private var txtGender: TextView? = null
    private var txtAndroidSkill: TextView? = null
    private var txtIosSkill: TextView? = null
    private var txtFlutterSkill: TextView? = null
    private var txtLanguage: TextView? = null
    private var txtHobbies: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Your Resume"

        profilePic = findViewById(R.id.profilePic)
        txtFullName = findViewById(R.id.txtFullName)
        txtAge = findViewById(R.id.txtAge)
        txtEmail = findViewById(R.id.txtEmail)
        txtGender = findViewById(R.id.txtGender)
        txtAndroidSkill = findViewById(R.id.txtAndroidSkill)
        txtIosSkill = findViewById(R.id.txtIosSkill)
        txtFlutterSkill = findViewById(R.id.txtFlutterSkill)
        txtLanguage = findViewById(R.id.txtLanguage)
        txtHobbies = findViewById(R.id.txtHobbies)

        profilePic!!.setImageURI(Uri.parse(intent.extras!!.getString(IMAGE)))

        txtFullName!!.text = "Name: "+intent.getStringExtra(FULL_NAME).toString()
        txtAge!!.text = "Age: " + intent.getStringExtra(AGE).toString()
        txtEmail!!.text = "Email: " + intent.getStringExtra(EMAIL).toString()
        txtGender!!.text = "Gender: " + intent.getStringExtra(GENDER).toString()

        txtAndroidSkill!!.text = "AndroidSkill: " + intent.getFloatExtra(SKILL_ANDROID, 0.0f).toString()
        txtIosSkill!!.text = "IosSkill: " + intent.getFloatExtra(SKILL_IOS, 0.0f).toString()
        txtFlutterSkill!!.text = "FlutterSkill: " + intent.getFloatExtra(SKILL_FLUTTER, 0.0f).toString()

        txtLanguage!!.text = "Languages: " + intent.getStringExtra(LANGUAGE).toString()
        txtHobbies!!.text = "Hobbies: " + intent.getStringExtra(HOBBIES).toString()

    }
}