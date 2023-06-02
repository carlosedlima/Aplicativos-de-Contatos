package com.example.testeskytef.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.testeskytef.databinding.ActivityRegisterBinding;
import com.example.testeskytef.ui.register.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {


    private ActivityRegisterBinding binding;

    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        binding.Cadastrar.setOnClickListener(view1 -> {
            verifyFields();
        });
    }

    private void verifyFields(){
        String nome = String.valueOf(binding.Nome.getText());
        String numero = String.valueOf(binding.Number.getText());
        String email = String.valueOf(binding.Email.getText());

        if(nome.isEmpty() || numero.isEmpty()){
            Toast.makeText(RegisterActivity.this , "Preencha os campos de nome e numero pelomenos", Toast.LENGTH_SHORT).show();
        }else{
            viewModel.registerContact(nome,numero,email);
            finish();
        }
    }


}