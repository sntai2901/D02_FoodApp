package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_welcome_screen2.*
class WelcomeScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen2)
        w2Next.setOnClickListener {
            val intent = Intent(this, WelcomeScreen3::class.java)
            // start your next activity
            startActivity(intent)
        }
        w2Skip.setOnClickListener {
            val intent1 = Intent(this,SignIn::class.java)
            startActivity(intent1)
        }
    }
}
