package Retrofit2;

public class APIUtils {
    public static final String Base_Url = "http://192.168.1.12/AccountManager/";
    public static DataClient getData(){
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
