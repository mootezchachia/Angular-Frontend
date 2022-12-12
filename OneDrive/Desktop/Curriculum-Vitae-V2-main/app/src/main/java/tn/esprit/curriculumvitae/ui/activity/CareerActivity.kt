package tn.esprit.curriculumvitae.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.ui.fragment.EducationFragment
import tn.esprit.curriculumvitae.ui.fragment.ExperienceFragment

class CareerActivity : AppCompatActivity() {

    private lateinit var btnExperience: Button
    private lateinit var btnEducation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)

        val toolbar: Toolbar = findViewById(R.id.app_bar)

        toolbar.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Your Career"

        btnExperience = findViewById(R.id.btnExperience)
        btnEducation = findViewById(R.id.btnEducation)

        btnExperience.setOnClickListener {
            changeFragment(ExperienceFragment(), "")
        }

        btnEducation.setOnClickListener {
            changeFragment(EducationFragment(), "")
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ExperienceFragment()).commit()

    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("").commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuAddExp){
            val addIntent: Intent = Intent(this, AddExperienceActivity::class.java)
            startActivity(addIntent)
        }else{
            val addIntent: Intent = Intent(this, AddEducationActivity::class.java)
            startActivity(addIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        changeFragment(ExperienceFragment(), "")
        super.onResume()
    }

}