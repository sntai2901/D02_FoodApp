package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register01.*

class Register01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register01)
        btn_conr1.setOnClickListener {
            val intent = Intent(this, Register02::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}
