package com.example.d02_foodapp


import Retrofit2.APIUtilsKT
import Retrofit2.DataClientKT
import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.d02_foodapp.databinding.ActivityRegister02Binding
import kotlinx.android.synthetic.main.activity_register02.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileNotFoundException


@SuppressLint("ByteOrderMark")
class Register02 : AppCompatActivity() {
    private lateinit var binding: ActivityRegister02Binding
    val Request_Code_Image : Int = 123
    lateinit var imgReg : ImageView
    lateinit var btnCon2 : Button
    var realpath : String? = ""
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE : Int = 291
    val TAG :String = "AAA"
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register02)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_register02)
        // Assume this Activity is the current activity
        setupPermissions()

        anhxa()
        imgReg.setOnClickListener{
            val intent = Intent(ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,Request_Code_Image)
        }

        binding.txtSignIn.setOnClickListener {
                val intent = Intent(this, SignIn::class.java)
                // start your next activity
                imm.hideSoftInputFromWindow(it.windowToken,0)
                startActivity(intent)
            }
        binding.btnConr2.setOnClickListener {
            //            // Here, thisActivity is the current activity
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//                // Permission is not granted
//                // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    // Show an explanation to the user *asynchronously* -- don't block
//                    // this thread waiting for the user's response! After the user
//                    // sees the explanation, try again to request the permission.
//                } else {
//                    // No explanation needed, we can request the permission.
//                    ActivityCompat.requestPermissions(this,
//                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
//
//                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                    // app-defined int constant. The callback method gets the
//                    // result of the request.
//                }
//            } else {
//                // Permission has already been granted
//            }
            val file = File(realpath)
            var file_path: String = file.absolutePath
            var arrnamefile: List<String> = file_path.split(".")
            file_path = arrnamefile[0] + System.currentTimeMillis() + "." + arrnamefile[1]
            Log.d("BBB",file_path)
            var requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file)
            var body :MultipartBody.Part = MultipartBody.Part.createFormData("uploaded_file",file_path,requestBody)
            var dataClientKT: DataClientKT = APIUtilsKT.data!!
            var callback : Call<String> = dataClientKT.UploadPhoto(body)
            Log.d("BBB", callback.toString())
            callback.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response != null) {
                        val message :String = response.body()
                        Log.d("BBB", "success$message")
                    }else{
                        val message :String = response.body()
                        Log.d("BBB", "fail$message")
                    }
                }
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("BBB",t.message)
                }
            })
            imm.hideSoftInputFromWindow(it.windowToken,0)
        }
//        btn_conr2.setOnClickListener {
//            val intent = Intent(this, Register03::class.java)
//            // start your next activity
//            startActivity(intent)
//        }
    }
    //    fun onClick(view: View?) {
//        requestPermionAndPickImage()
//    }
    private fun anhxa(){
        imgReg = findViewById(R.id.imageUpload)
        btnCon2 = findViewById(R.id.btn_conr2)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Request_Code_Image && resultCode == Activity.RESULT_OK &&  null != data){
            val uri = data.data
            realpath = getRealPathFromURI(uri)
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
    private fun getRealPathFromURI(contentUri: Uri?): String? {
        var path: String? = null
        val proj = arrayOf(MediaStore.MediaColumns.DATA)
        val cursor =
            contentResolver.query(contentUri, proj, null, null, null)
        if (cursor.moveToFirst()) {
            val column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
            path = cursor.getString(column_index)
        }
        cursor.close()
        return path
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.READ_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }
    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }
}
