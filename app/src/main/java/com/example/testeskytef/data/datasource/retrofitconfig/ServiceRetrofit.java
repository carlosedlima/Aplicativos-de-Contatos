package com.example.testeskytef.data.datasource.retrofitconfig;

import com.example.testeskytef.data.datasource.retrofitconfig.services.ContactRetrofitService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRetrofit {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl("https://619d3d93131c600017088e1b.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static ContactRetrofitService contactRetrofitService = retrofit.create(ContactRetrofitService.class);

    public static ContactRetrofitService getContactApi() {
        return contactRetrofitService;
    }

}
