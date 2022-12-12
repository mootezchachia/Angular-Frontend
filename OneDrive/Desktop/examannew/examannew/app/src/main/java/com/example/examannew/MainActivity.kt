package com.example.examannew

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.examannew.data.Cars
import com.example.examannew.data.User
import com.example.examannew.utils.AppDataBase
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


const val PREF_NAME = "DATA_CV_PREF"
const val emailfull = "email"
const val fullname = "fullname"
const val password = "password"

const val IS_REMEMBRED = "remembred"
class MainActivity : AppCompatActivity() {

    private var txtFullName: TextInputEditText? = null

    private var txtPassword: TextInputEditText? = null


    private var txtLayoutFullName: TextInputLayout? = null

    private var txtLayoutPassword: TextInputLayout? = null

    private var btnSubmit: Button? = null

    lateinit var cbRememberMe: CheckBox

    lateinit var mSharedPref: SharedPreferences
    lateinit var educationList : MutableList<Cars>
    lateinit var dataBase: AppDataBase
    lateinit var userlist : MutableList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFullName = findViewById(R.id.txtFullName)

        txtPassword = findViewById(R.id.txtAge)

        txtLayoutFullName = findViewById(R.id.txtLayoutFullName)


        txtLayoutPassword = findViewById(R.id.txtLayoutAge)

        btnSubmit = findViewById(R.id.btnSubmit)
        cbRememberMe = findViewById(R.id.cbRememberMe)

        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        dataBase = AppDataBase.getDatabase(applicationContext)

        userlist = dataBase.userdao().getAllEducations()
        var test = 0
        for (name in userlist) {

            test++

        }
        if(test==0){
            AppDataBase.getDatabase(applicationContext).userdao().insert(
                User(0, username = "user1", password = "123", role = "ETD")
            )
            AppDataBase.getDatabase(applicationContext).userdao().insert(
                User(0, username = "club1", password = "123", role = "CLB")
            )
        }
        userlist = dataBase.userdao().getAllEducations()

        if (mSharedPref.getBoolean(IS_REMEMBRED, false)) {
            val mainIntent = Intent(this, next::class.java)
            startActivity(mainIntent)
            finish()
        }
        var test2=0
        var test3 =0
        btnSubmit!!.setOnClickListener {
            txtLayoutFullName!!.error = null

            txtLayoutPassword!!.error = null
            if (txtFullName?.text!!.isEmpty()) {
                txtLayoutFullName!!.error = "must not be empty"
                return@setOnClickListener
            }




            if (txtPassword?.text!!.isEmpty()) {
                txtLayoutPassword!!.error = "must not be empty"
                return@setOnClickListener
            }



            for (name in userlist) {

                if(name.username==txtFullName!!.text.toString() && name.password==txtPassword!!.text.toString()) {
                    mSharedPref.edit().apply {

                        putString(fullname, txtFullName!!.text.toString())
                        putString(password, "ETD")
                        putBoolean(IS_REMEMBRED, cbRememberMe.isChecked)

                    }.apply()
                }

            }







            if (cbRememberMe.isChecked){
                mSharedPref.edit().apply{
                    putBoolean(IS_REMEMBRED, cbRememberMe.isChecked)
                }.apply()
            }
            val mainIntent = Intent(this, next::class.java)


            startActivity(mainIntent)
            finish()
        }

    }

    fun isEmailValid(email: String?): Boolean {
        return !(email == null || TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email)
            .matches()
    }
}