package com.example.testeskytef.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.example.testeskytef.databinding.ActivityHomeBinding;
import com.example.testeskytef.ui.details.DetailsActivity;
import com.example.testeskytef.ui.home.adapter.ContactsAdapter;
import com.example.testeskytef.ui.home.viewmodel.HomeViewModel;
import com.example.testeskytef.ui.register.RegisterActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private ContactsAdapter contactsAdapter;
    private HomeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        settingRecycler();

        binding.Add.setOnClickListener(onClick -> {
         startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        });

        viewModelObservers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getContacts();
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
    private void viewModelObservers(){
            viewModel.getListOfContacts().observe(this, contacts -> {
                contactsAdapter.setItems(contacts);
            });
    }

}