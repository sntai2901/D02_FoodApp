package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.d02_foodapp.databinding.ActivityWelcomeScreen2Binding

import kotlinx.android.synthetic.main.activity_welcome_screen2.*

class WelcomeScreen2 : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreen2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_welcome_screen2)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome_screen2)
        binding.w2Next.setOnClickListener {
            val intent = Intent(this, WelcomeScreen3::class.java)
            // start your next activity
            startActivity(intent)
        }
        binding.w2Skip.setOnClickListener {
            val intent1 = Intent(this, SignIn::class.java)
            startActivity(intent1)
        }
    }
}
