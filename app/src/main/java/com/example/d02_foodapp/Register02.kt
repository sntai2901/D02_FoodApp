package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register02.*

class Register02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register02)
        signin_btn.setOnClickListener {
            val intent = Intent(this, Register03::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
