package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        btn_forgotpass.setOnClickListener {
            val intent = Intent(this, VerificationScreen::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
