package com.example.d02_foodapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.chaos.view.PinView
import kotlinx.android.synthetic.main.activity_verification_screen.*


class VerificationScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_screen)

        val pinView = findViewById<PinView>(R.id.firstPinView)
        pinView.setTextColor(
            ResourcesCompat.getColor(resources, R.color.light, theme))
        pinView.setTextColor(
            ResourcesCompat.getColorStateList(resources, R.color.hard, theme))
        pinView.setLineColor(
            ResourcesCompat.getColor(resources, R.color.light, theme))
        pinView.setLineColor(
            ResourcesCompat.getColorStateList(resources, R.color.hard, theme))
        pinView.itemCount = 4
        pinView.itemHeight = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size)
        pinView.itemWidth = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size)
        pinView.itemRadius = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_radius)
        pinView.itemSpacing = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing)
        pinView.lineWidth = resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width)
        pinView.setAnimationEnable(true)// start animation when adding text
        pinView.isCursorVisible = true
        pinView.cursorColor = ResourcesCompat.getColor(resources, R.color.hard , theme)
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
        signin_btn.setOnClickListener {
            val intent = Intent(this, VerificationScreen::class.java)
            // start your next activity
            startActivity(intent)
        }
    }




}
