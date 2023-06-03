package com.example.testeskytef.ui.register.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeskytef.data.datasource.retrofitconfig.ServiceRetrofit;
import com.example.testeskytef.data.models.Contact;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterViewModel extends ViewModel {

    private int ID = 1;

    private final MutableLiveData<Contact> contact = new MutableLiveData<>();

    public MutableLiveData<Contact> getContact() {
        return contact;
    }

    public void registerContact(String name ,String phone ,String email){
        try{
            registerContact(new Contact(ID,name,phone));
            ID++;
        }catch (Exception E){
            Log.e("HomeViewModel",E.toString());
        }
    }

    public Contact registerContact(Contact contact) {
        ServiceRetrofit.getContactApi().registerUser(contact).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });

        return contact;
    }
}