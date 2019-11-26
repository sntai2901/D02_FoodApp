package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.d02_foodapp.databinding.ActivityWelcomeScreen1Binding
import kotlinx.android.synthetic.main.activity_welcome_screen1.*


class WelcomeScreen1 : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeScreen1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val isFirstRun =
//            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
//                .getBoolean("isFirstRun", true)
//
//        if (isFirstRun) { //show start activity
//            startActivity(Intent(this, SignIn::class.java))
//            Toast.makeText(this, "First Run", Toast.LENGTH_LONG)
//                .show()
//        }
//        getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
//            .putBoolean("isFirstRun", false).commit()
//        setContentView(R.layout.activity_welcome_screen1)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome_screen1)
        binding.w1Next.setOnClickListener {
            val intent = Intent(this, WelcomeScreen2::class.java)
            // start your next activity
            startActivity(intent)
        }
        binding.w1Skip.setOnClickListener {
            val intent1 = Intent(this, SignIn::class.java)
            startActivity(intent1)
//            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left)
        }
    }
}
