package com.example.testeskytef.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contact implements Serializable, Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("phone")
    private String phone;

    public Contact(int id, String fullname, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.phone = phone;
    }

    public Contact() {
    }

    protected Contact(Parcel in) {
        id = in.readInt();
        fullname = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(fullname);
        parcel.writeString(phone);
    }
}
