package com.muneiah.javaretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance
{
    private static Retrofit retrofit;


    public static Retrofit getRetrofitInstance() {
        String BASE_URL = "https://jsonplaceholder.typicode.com/";
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
