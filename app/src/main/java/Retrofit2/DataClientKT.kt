package Retrofit2

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DataClientKT {
    @Multipart
    @POST("uploadIMG.php")
    fun UploadPhoto(@Part photo: MultipartBody.Part): Call<String>

}