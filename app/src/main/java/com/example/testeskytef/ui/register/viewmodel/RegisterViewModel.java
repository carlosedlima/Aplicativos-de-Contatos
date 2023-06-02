package com.example.testeskytef.ui.register.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeskytef.data.datasource.retrofitconfig.RetrofitContactDataSource;
import com.example.testeskytef.data.models.Contact;



public class RegisterViewModel extends ViewModel {

    private RetrofitContactDataSource retrofitDataSource = new RetrofitContactDataSource();

    private int ID = 1;

    private final MutableLiveData<Contact> contact = new MutableLiveData<>();

    public MutableLiveData<Contact> getContact() {
        return contact;
    }

    public void registerContact(String name ,String phone ,String email){
        try{
            retrofitDataSource.registerContact(new Contact(ID,name,phone));
            ID++;
        }catch (Exception E){
            Log.e("HomeViewModel",E.toString());
        }
    }
}