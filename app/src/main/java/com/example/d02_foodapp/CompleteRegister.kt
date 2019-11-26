package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.d02_foodapp.databinding.ActivityCompleteRegisterBinding

class CompleteRegister : AppCompatActivity() {
    private lateinit var binding: ActivityCompleteRegisterBinding
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_complete_register)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_complete_register)
        binding.btnCompletereg.setOnClickListener {
            val intent = Intent(this, this::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken,0)
            startActivity(intent)
        }
    }
}
