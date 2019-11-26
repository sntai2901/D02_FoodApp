package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_register03.*

class Register03 : AppCompatActivity() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register03)
        btn_conr3.setOnClickListener {
            val intent = Intent(this, CompleteRegister::class.java)
            // start your next activity
            startActivity(intent)
        }
        textView7.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken,0)
            startActivity(intent)
        }
    }
}
