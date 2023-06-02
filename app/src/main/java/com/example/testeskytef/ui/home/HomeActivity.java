package com.example.testeskytef.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.testeskytef.data.datasource.retrofitconfig.RetrofitContactDataSource;
import com.example.testeskytef.data.models.Contact;
import com.example.testeskytef.databinding.ActivityHomeBinding;
import com.example.testeskytef.ui.details.DetailsActivity;
import com.example.testeskytef.ui.home.adapter.ContactsAdapter;
import com.example.testeskytef.ui.register.RegisterActivity;
import com.example.testeskytef.util.RecyclerViewInterface;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ActivityHomeBinding binding;
    private ContactsAdapter contactsAdapter;

    private final RetrofitContactDataSource retrofitDataSource = new RetrofitContactDataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        settingRecycler();
        setAdapterItems();
        contactsAdapter.notifyDataSetChanged();
        binding.Add.setOnClickListener(onClick -> {
         startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrofitDataSource.getContacts();
        contactsAdapter.notifyDataSetChanged();
    }

    private void settingRecycler(){
        contactsAdapter = new ContactsAdapter(item -> {
            Intent intent = new Intent(this, DetailsActivity.class);

            intent.putExtra("CONTATO", (Parcelable) item);

            startActivity(intent);
        });
        binding.RecyclerPrincipal.setAdapter(contactsAdapter);
        binding.RecyclerPrincipal.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setAdapterItems(){
        contactsAdapter.setItems(retrofitDataSource.getContacts());
    }


    @Override
    public void onItemClick(int position) {

    }
}