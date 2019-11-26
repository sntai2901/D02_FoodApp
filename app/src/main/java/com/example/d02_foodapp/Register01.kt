package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_register01.*

class Register01 : AppCompatActivity() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register01)
        btn_conr1.setOnClickListener {
            val intent = Intent(this, Register02::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken,0)
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
