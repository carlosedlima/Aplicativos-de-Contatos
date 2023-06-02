package com.example.testeskytef.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.testeskytef.R;
import com.example.testeskytef.data.datasource.retrofitconfig.RetrofitContactDataSource;
import com.example.testeskytef.data.models.Contact;
import com.example.testeskytef.databinding.ActivityDetailsBinding;
import com.example.testeskytef.databinding.ActivityHomeBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    private RetrofitContactDataSource retrofitContactDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        retrofitContactDataSource = new RetrofitContactDataSource();

        Contact contact = getIntent().getExtras().getParcelable("CONTATO");

        binding.dadosNome.setText(contact.getFullname());
        binding.dadosPhone.setText(contact.getPhone());
        binding.idDoContato.setText(String.valueOf(contact.getId()));

        binding.Deletar.setOnClickListener(
                view1 -> {
                    retrofitContactDataSource.deleteContact(contact.getId());
                    finish();
                }
        );
    }


}