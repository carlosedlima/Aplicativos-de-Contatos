package com.example.testeskytef.data.datasource.retrofitconfig.services;

import com.example.testeskytef.data.models.Contact;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ContactRetrofitService {

    @POST("contacts")
    Call<Boolean> registerUser(@Body Contact contact);

    @GET("contacts")
    Call<List<Contact>> getContacts();
    @GET("contacts/{id}")
    Call<Contact> getContact(@Path("id")int id);

    @DELETE("contacts/{id}")
    Call<Boolean> deleteContact(@Path("id")int id);

    @PUT("contacts/{id}")
    Call<Contact> updateContact (@Path("id")int id);

}
