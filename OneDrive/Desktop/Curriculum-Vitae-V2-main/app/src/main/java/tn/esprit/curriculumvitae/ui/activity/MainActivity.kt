package tn.esprit.curriculumvitae.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.ui.fragment.AboutMeFragment
import tn.esprit.curriculumvitae.ui.fragment.HobbiesFragment
import tn.esprit.curriculumvitae.ui.fragment.LanguageFragment
import tn.esprit.curriculumvitae.ui.fragment.SkillsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var profilePic: ImageView
    private lateinit var txtFullName: TextView
    private lateinit var txtEmail: TextView

    private lateinit var btnSkills: Button
    private lateinit var btnHobbies: Button
    private lateinit var btnLanguage: Button

    private lateinit var btnMyCareer: Button

    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Your Resume"

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        profilePic = findViewById(R.id.profilePic)
        txtFullName = findViewById(R.id.txtFullName)
        txtEmail = findViewById(R.id.txtEmail)

        btnSkills = findViewById(R.id.btnSkills)
        btnHobbies = findViewById(R.id.btnHobbies)
        btnLanguage = findViewById(R.id.btnLanguage)

        btnMyCareer = findViewById(R.id.btnMyCareer)

//        profilePic.setImageURI(Uri.parse(intent.extras!!.getString(IMAGE)))
        profilePic.setImageURI(Uri.parse(mSharedPref.getString(IMAGE, "").toString()))

        txtFullName.text = mSharedPref.getString(FULL_NAME, "").toString()
//        txtFullName.text = intent.getStringExtra(FULL_NAME).toString()

        txtEmail.text = mSharedPref.getString(EMAIL, "").toString()
//        txtEmail.text = intent.getStringExtra(EMAIL).toString()

        btnMyCareer.setOnClickListener {
            val intent = Intent(this, CareerActivity::class.java)
            startActivity(intent)
        }

        btnSkills.setOnClickListener {

//            val skillsFragment = SkillsFragment.newInstance(
//                intent.getFloatExtra(SKILL_ANDROID, 0.0F),
//                intent.getFloatExtra(SKILL_IOS, 0.0F),
//                intent.getFloatExtra(SKILL_FLUTTER, 0.0F))

            val skillsFragment = SkillsFragment.newInstance(
                mSharedPref.getFloat(SKILL_ANDROID, 0.0F),
                mSharedPref.getFloat(SKILL_IOS, 0.0F),
                mSharedPref.getFloat(SKILL_FLUTTER, 0.0F))

            changeFragment(skillsFragment, "")
        }

        btnHobbies.setOnClickListener {

//            val hobbiesFragment = HobbiesFragment.newInstance(
//                intent.getBooleanExtra(IS_SPORT, false),
//                intent.getBooleanExtra(IS_MUSIC, false),
//                intent.getBooleanExtra(IS_GAMES, false))

            val hobbiesFragment = HobbiesFragment.newInstance(
                mSharedPref.getBoolean(IS_SPORT, false),
                mSharedPref.getBoolean(IS_MUSIC, false),
                mSharedPref.getBoolean(IS_GAMES, false))

            changeFragment(hobbiesFragment, "")
        }

        btnLanguage.setOnClickListener {

//            val languageFragment = LanguageFragment.newInstance(
//                intent.getBooleanExtra(IS_ARABIC, false),
//                intent.getBooleanExtra(IS_FRENCH, false),
//                intent.getBooleanExtra(IS_ENGLISH, false))

            val languageFragment = LanguageFragment.newInstance(
                mSharedPref.getBoolean(IS_ARABIC, false),
                mSharedPref.getBoolean(IS_FRENCH, false),
                mSharedPref.getBoolean(IS_ENGLISH, false))

            changeFragment(languageFragment, "")
        }

        val skillsFragment = SkillsFragment.newInstance(
            mSharedPref.getFloat(SKILL_ANDROID, 0.0F),
            mSharedPref.getFloat(SKILL_IOS, 0.0F),
            mSharedPref.getFloat(SKILL_FLUTTER, 0.0F))

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, skillsFragment).commit()

    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("").commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.infoMenu -> {

//                val aboutMeFragment = AboutMeFragment.newInstance(
//                    intent.getStringExtra(FULL_NAME).toString(),
//                    intent.getStringExtra(AGE).toString(),
//                    intent.getStringExtra(GENDER).toString(),
//                    intent.getStringExtra(EMAIL).toString())

                val aboutMeFragment = AboutMeFragment.newInstance(
                    mSharedPref.getString(FULL_NAME, "").toString(),
                    mSharedPref.getString(AGE, "").toString(),
                    mSharedPref.getString(GENDER, "").toString(),
                    mSharedPref.getString(EMAIL, "").toString()
                )

                changeFragment(aboutMeFragment,"AboutMe")
            }
            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.logoutTitle))
                builder.setMessage(R.string.logoutMessage)
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
