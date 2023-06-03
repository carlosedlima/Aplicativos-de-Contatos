package com.example.testeskytef.ui.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeskytef.data.datasource.retrofitconfig.ServiceRetrofit;
import com.example.testeskytef.data.models.Contact;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends ViewModel {

    private final MutableLiveData<Boolean> deletedContact = new MutableLiveData<>();

    public MutableLiveData<Boolean> getDeletedContact() {
        return deletedContact;
    }


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
