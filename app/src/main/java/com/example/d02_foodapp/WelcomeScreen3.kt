package com.example.d02_foodapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.d02_foodapp.databinding.ActivityWelcomeScreen3Binding
import kotlinx.android.synthetic.main.activity_welcome_screen3.*

class WelcomeScreen3 : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreen3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_welcome_screen3)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome_screen3)
        binding.w3Next.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            // start your next activity
            startActivity(intent)
        }
        binding.w3Skip.setOnClickListener {
            val intent1 = Intent(this, SignIn::class.java)
            startActivity(intent1)
        }
    }
}
