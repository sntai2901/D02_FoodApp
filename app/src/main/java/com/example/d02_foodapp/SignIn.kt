package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_signup.setOnClickListener {
            val intent = Intent(this, Register01::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken,0)
            startActivity(intent)
        }
        textView5.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken,0)
            startActivity(intent)
        }

        //hide keyboard


    }
}
