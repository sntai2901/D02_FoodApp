package com.example.d02_foodapp

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_register02.*
import kotlinx.android.synthetic.main.activity_register02.view.*
import java.io.FileNotFoundException

class Register02 : AppCompatActivity() {
    val Request_Code_Image : Int = 123
    lateinit var imgReg : ImageView
//    val email = editTextEmail
//    val Request_Code_Image : Int = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register02)
        anhxa()
        imgReg.setOnClickListener{
            val intent = Intent(ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,Request_Code_Image)
        }

        btn_conr2.setOnClickListener {
            val intent = Intent(this, Register03::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
    private fun anhxa(){
        imgReg = findViewById(R.id.imageUpload)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Request_Code_Image && resultCode == Activity.RESULT_OK &&  null != data){
            val uri = data.data
            try {
                val inputStream = uri?.let { contentResolver.openInputStream(it) }
                var bitmap = BitmapFactory.decodeStream(inputStream)
                imgReg.setImageBitmap(bitmap)
            }
            catch (e : FileNotFoundException){
                e.printStackTrace()
            }


        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
