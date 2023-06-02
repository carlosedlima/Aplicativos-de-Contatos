package com.example.testeskytef.data.datasource.interfaces;

import com.example.testeskytef.data.models.Contact;

import java.util.List;

public interface ContactDataSource {

    public List<Contact> getContacts();

    public Contact registerContact(Contact contact);

    public Contact getContact(int id);

    public void deleteContact(int id);

    public Contact updateContact(Contact cont);

}
