package lk.acx.networkpractical.client;

import android.content.Context;

import lk.acx.networkpractical.interceptor.AuthInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    public static final String BASE_URL = "http://10.0.2.2:8080/api/v1/";
    /// emulators ==> [...](http://10.0.2.2:8080/api/v1)
    /// physical device ==> open.cmd -> ipconfig -> ipv4 address ==>[...] (http://192.168.1.100:8080/api/v1)

    public static Retrofit getInstance(Context context) {
        if (retrofit == null) {
           OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor(context))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}

