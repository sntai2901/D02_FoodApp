package Retrofit2

object APIUtilsKT {
    const val Base_Url = "http://192.168.31.51/AccountManager/"
    val data: DataClientKT?
        get() = RetrofitClientkt.getClient(Base_Url)
            ?.create(DataClientKT::class.java)
}