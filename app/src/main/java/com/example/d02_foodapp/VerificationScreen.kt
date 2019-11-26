package com.example.d02_foodapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.chaos.view.PinView
import com.example.d02_foodapp.databinding.ActivityVerificationScreenBinding
import kotlinx.android.synthetic.main.activity_verification_screen.*


class VerificationScreen : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationScreenBinding
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_verification_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_verification_screen)
        val pinView = binding.firstPinView
        pinView.setTextColor(
            ResourcesCompat.getColor(resources, R.color.light, theme)
        )
        pinView.setTextColor(
            ResourcesCompat.getColorStateList(resources, R.color.hard, theme)
        )
        pinView.setLineColor(
            ResourcesCompat.getColor(resources, R.color.light, theme)
        )
        pinView.setLineColor(
            ResourcesCompat.getColorStateList(resources, R.color.hard, theme)
        )
        pinView.itemCount = 4
        pinView.itemHeight = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size)
        pinView.itemWidth = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size)
        pinView.itemRadius = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_radius)
        pinView.itemSpacing = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing)
        pinView.lineWidth = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width)
        pinView.setAnimationEnable(true)// start animation when adding text
        pinView.isCursorVisible = true
        pinView.cursorColor = ResourcesCompat.getColor(resources, R.color.hard, theme)
        pinView.cursorWidth = resources.getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width)
        pinView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pinView.setItemBackgroundColor(Color.WHITE)
        pinView.setHideLineWhenFilled(false)
        (findViewById<View>(R.id.firstPinView) as PinView).setAnimationEnable(true)
        binding.btnVerification.setOnClickListener {
            val intent = Intent(this, VerificationScreen::class.java)
            // start your next activity
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            startActivity(intent)
        }
    }


}
