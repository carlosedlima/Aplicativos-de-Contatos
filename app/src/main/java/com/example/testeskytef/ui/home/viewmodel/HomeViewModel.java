package com.example.testeskytef.ui.home.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeskytef.data.datasource.retrofitconfig.ServiceRetrofit;
import com.example.testeskytef.data.models.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {


    private final MutableLiveData<List<Contact>> contacts = new MutableLiveData<>();

    public MutableLiveData<List<Contact>> getListOfContacts() {
        return contacts;
    }

    private final MutableLiveData<Contact> contact = new MutableLiveData<>();

    public MutableLiveData<Contact> getContactDetail() {
        return contact;
    }

    public void getContacts() {


        ServiceRetrofit.getContactApi().getContacts().enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    contacts.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });


    }

    public void getContact(int id) {

        ServiceRetrofit.getContactApi().getContact(id).enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                if (response.isSuccessful()) {
                    contact.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });
    }


}
