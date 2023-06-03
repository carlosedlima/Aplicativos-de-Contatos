package com.example.testeskytef.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.testeskytef.data.models.Contact;
import com.example.testeskytef.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private DetailsViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        Contact contact = getIntent().getExtras().getParcelable("CONTATO");

        binding.dadosNome.setText(contact.getFullname());
        binding.dadosPhone.setText(contact.getPhone());
        binding.idDoContato.setText(String.valueOf(contact.getId()));

        binding.Deletar.setOnClickListener(
                view1 -> {
                    viewModel.deleteContact(contact.getId());
                    finish();
                }
        );
    }


}