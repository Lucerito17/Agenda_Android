package com.example.app2.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    SharedPreferences sharedPreferences;

    public RetrofitFactory(Context context) {
        sharedPreferences = context.getSharedPreferences("com.example.app2.MyAPPVJ" , Context.MODE_PRIVATE);

    }

    public  Retrofit build() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("AUTHORIZATION", sharedPreferences.getString("AUTHORIZATION", null))
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://63587803c26aac906f42ccd3.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
