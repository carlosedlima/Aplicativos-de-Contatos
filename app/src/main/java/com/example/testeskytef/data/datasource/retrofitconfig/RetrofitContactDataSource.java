package com.example.testeskytef.data.datasource.retrofitconfig;

import com.example.testeskytef.data.datasource.interfaces.ContactDataSource;

import com.example.testeskytef.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitContactDataSource implements ContactDataSource {



    @Override
    public List<Contact> getContacts() {


        ArrayList<Contact> contacts = new ArrayList<>();
        ServiceRetrofit.getContactApi().getContacts().enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    contacts.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
        return contacts;
    }

    @Override
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

    @Override
    public Contact getContact(int id) {

        final Contact[] contact = {new Contact()};

        ServiceRetrofit.getContactApi().getContact(id).enqueue(new Callback<Contact>() {
             @Override
             public void onResponse(Call<Contact> call, Response<Contact> response) {
                 if (response.isSuccessful()){
                     contact[0] = response.body();
                 }
             }

             @Override
             public void onFailure(Call<Contact> call, Throwable t) {

             }
         });
         return contact[0];
    }

    @Override
    public void deleteContact(int id) {
        ServiceRetrofit.getContactApi().deleteContact(id).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

    @Override
    public Contact updateContact(Contact contact) {

        final Contact[] updatedContact = {new Contact()};

        ServiceRetrofit.getContactApi().updateContact(contact.getId()).enqueue(new Callback<Contact>() {
             @Override
             public void onResponse(Call<Contact> call, Response<Contact> response) {
                 if (response.isSuccessful()){
                     updatedContact[0] = response.body();
                 }
             }

             @Override
             public void onFailure(Call<Contact> call, Throwable t) {

             }
         });
         return updatedContact[0];
    }

}
