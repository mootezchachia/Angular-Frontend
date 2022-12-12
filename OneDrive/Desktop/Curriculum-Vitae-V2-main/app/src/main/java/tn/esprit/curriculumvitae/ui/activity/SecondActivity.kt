package tn.esprit.curriculumvitae.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import tn.esprit.curriculumvitae.R

const val PREF_NAME = "DATA_CV_PREF"

const val SKILL_ANDROID = "SKILL_ANDROID"
const val SKILL_IOS = "SKILL_IOS"
const val SKILL_FLUTTER = "SKILL_FLUTTER"

const val LANGUAGE = "LANGUAGE"
const val IS_ENGLISH = "IS_ENGLISH"
const val IS_FRENCH = "IS_FRENCH"
const val IS_ARABIC = "IS_ARABIC"

const val HOBBIES = "HOBBIES"
const val IS_MUSIC = "IS_MUSIC"
const val IS_SPORT = "IS_SPORT"
const val IS_GAMES = "IS_GAMES"


class SecondActivity : AppCompatActivity() {

    var sliderAndroid: Slider? = null
    var sliderIos: Slider? = null
    var sliderFlutter: Slider? = null

    private var cbFrench : CheckBox? = null
    private var cbEnglish : CheckBox? = null
    private var cbArabic : CheckBox? = null

    private var cbSport : CheckBox? = null
    private var cbMusic : CheckBox? = null
    private var cbGames : CheckBox? = null

    private var btnSubmit : Button? = null

    lateinit var mSharedPref: SharedPreferences
    lateinit var cbRememberMe: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        title = getString(R.string.createYourResume)

        sliderAndroid = findViewById(R.id.seekBarAndroid)
        sliderIos = findViewById(R.id.seekBarIos)
        sliderFlutter = findViewById(R.id.seekBarFlutter)

        cbFrench = findViewById(R.id.cbFrench)
        cbEnglish = findViewById(R.id.cbEnglish)
        cbArabic = findViewById(R.id.cbArabic)

        cbSport = findViewById(R.id.cbSport)
        cbMusic = findViewById(R.id.cbMusic)
        cbGames = findViewById(R.id.cbGames)

        btnSubmit = findViewById(R.id.btnSubmit)
        cbRememberMe = findViewById(R.id.cbRememberMe)

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        btnSubmit!!.setOnClickListener {

            mSharedPref.edit().apply{
                putString(FULL_NAME, intent.getStringExtra(FULL_NAME).toString())
                putString(AGE, intent.getStringExtra(AGE).toString())
                putString(EMAIL, intent.getStringExtra(EMAIL).toString())
                putString(GENDER, intent.getStringExtra(GENDER).toString())

                putFloat(SKILL_ANDROID, sliderAndroid!!.value)
                putFloat(SKILL_IOS, sliderIos!!.value)
                putFloat(SKILL_FLUTTER, sliderFlutter!!.value)

                putString(IMAGE, intent.getStringExtra(IMAGE).toString())

                putBoolean(IS_ARABIC, cbArabic!!.isChecked)
                putBoolean(IS_ENGLISH, cbEnglish!!.isChecked)
                putBoolean(IS_FRENCH, cbFrench!!.isChecked)

                putBoolean(IS_MUSIC, cbMusic!!.isChecked)
                putBoolean(IS_SPORT, cbSport!!.isChecked)
                putBoolean(IS_GAMES, cbGames!!.isChecked)

                putBoolean(IS_REMEMBRED, cbRememberMe.isChecked)

            }.apply()

            if (cbRememberMe.isChecked){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, cbRememberMe.isChecked)
                }.apply()
            }

            val mainIntent = Intent(this, MainActivity::class.java).apply {

                putExtra(FULL_NAME, intent.getStringExtra(FULL_NAME).toString())
                putExtra(AGE, intent.getStringExtra(AGE).toString())
                putExtra(EMAIL, intent.getStringExtra(EMAIL).toString())
                putExtra(GENDER, intent.getStringExtra(GENDER).toString())

                putExtra(SKILL_ANDROID, sliderAndroid!!.value)
                putExtra(SKILL_IOS, sliderIos!!.value)
                putExtra(SKILL_FLUTTER, sliderFlutter!!.value)

                putExtra(IMAGE, intent.getStringExtra(IMAGE).toString())

                var language = ""

                if (cbArabic!!.isChecked)
                    language += cbArabic!!.text.toString() + " "
                if (cbEnglish!!.isChecked)
                    language += cbEnglish!!.text.toString() + " "
                if (cbFrench!!.isChecked)
                    language += cbFrench!!.text.toString()

                putExtra(LANGUAGE, language)
                putExtra(IS_ARABIC, cbArabic!!.isChecked)
                putExtra(IS_ENGLISH, cbEnglish!!.isChecked)
                putExtra(IS_FRENCH, cbFrench!!.isChecked)

                var hobbies = ""

                if (cbGames!!.isChecked)
                    hobbies += cbGames!!.text.toString() + " "
                if (cbSport!!.isChecked)
                    hobbies += cbSport!!.text.toString() + " "
                if (cbMusic!!.isChecked)
                    hobbies += cbMusic!!.text.toString()

                putExtra(HOBBIES, hobbies)
                putExtra(IS_MUSIC, cbMusic!!.isChecked)
                putExtra(IS_SPORT, cbSport!!.isChecked)
                putExtra(IS_GAMES, cbGames!!.isChecked)

            }

            startActivity(mainIntent)
            finish()
        }
    }
}