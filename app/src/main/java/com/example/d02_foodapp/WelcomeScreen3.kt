package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome_screen3.*

class WelcomeScreen3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen3)
        w3Next.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            // start your next activity
            startActivity(intent)
        }
        w3Skip.setOnClickListener {
            val intent1 = Intent(this,SignIn::class.java)
            startActivity(intent1)
        }
    }
}
