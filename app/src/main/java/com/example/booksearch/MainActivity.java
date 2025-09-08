package com.example.booksearch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
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
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.btnBuscar.setOnClickListener(v -> {
            String titulo = binding.etBuscar.getText().toString();
            viewModel.buscarLibro(titulo);
        });

        viewModel.getMutableLibro().observe(this, libro -> {
            if (libro != null) {
                Intent intent = new Intent(this, DetalleActivity.class);
                intent.putExtra("libro", libro);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
