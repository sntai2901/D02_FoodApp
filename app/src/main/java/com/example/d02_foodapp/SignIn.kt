package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_signup.setOnClickListener {
            val intent = Intent(this, Register01::class.java)
            // start your next activity
            startActivity(intent)
        }
        textView5.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
