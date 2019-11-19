package com.example.d02_foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome_screen1.*


class WelcomeScreen1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen1)

        w1Next.setOnClickListener {
            val intent = Intent(this, WelcomeScreen2::class.java)
            // start your next activity
            startActivity(intent)
        }
        w1Skip.setOnClickListener {
            val intent1 = Intent(this,SignIn::class.java)
            startActivity(intent1)
//            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left)
        }
    }
}
