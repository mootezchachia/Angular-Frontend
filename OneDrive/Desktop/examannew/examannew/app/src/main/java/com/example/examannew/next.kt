package com.example.examannew

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class next : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView

    private lateinit var mSharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        //toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
        ///bottom bar
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        bottomNav = findViewById(R.id.bottomNavigationView)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mihome -> {
                    changeFragment(HomeFragment(),"")
                    toolbar.setTitle("Esprit Events");
                }
                R.id.mimessage -> {
                    changeFragment(ParticipationFragment(),"")
                    toolbar.setTitle("Esprit Events");
                }
                R.id.messenger -> {

                    val skillsFragment = ProfileFragment.newInstance(

                        mSharedPref.getString(fullname, "").toString(),
                        mSharedPref.getString(emailfull, "").toString())

                    changeFragment(skillsFragment, "")
                }


            }
            true
        }



    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("").commit()

    }

}