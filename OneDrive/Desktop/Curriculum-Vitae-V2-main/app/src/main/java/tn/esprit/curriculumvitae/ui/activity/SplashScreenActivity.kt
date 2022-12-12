package tn.esprit.curriculumvitae.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import tn.esprit.curriculumvitae.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, FirstActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }
}