package com.example.examannew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.examannew.data.User
import com.example.examannew.utils.AppDataBase

class splashscreen : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler = Handler()
        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 3000)
    }
}