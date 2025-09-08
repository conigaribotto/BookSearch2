package com.example.booksearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.booksearch.databinding.ActivityMainBinding;

import ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(binding.getRoot());

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = binding.etBuscar.getText().toString();
                viewModel.buscarLibro(titulo);
            }
        });

        viewModel.getMutableLibro().observe(this, libro -> {
            if (libro != null) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("libro", libro); // ahora Libro es Serializable -> debería funcionar
                startActivity(intent);
            } else {
                binding.tvMensaje.setText("Libro no encontrado");
            }
        });
    }
}
