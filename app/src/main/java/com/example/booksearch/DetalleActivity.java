package com.example.booksearch;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.booksearch.databinding.ActivityDetalleBinding;

import ViewModel.DetalleViewModel;
import Model.Libro;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    private DetalleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        setContentView(binding.getRoot());

        viewModel.getMutableLibro().observe(this, libro -> {
            if (libro != null) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText(libro.getAutor());
                binding.tvDescripcion.setText(libro.getDescripcion());
            }
        });

        viewModel.cargarLibro(getIntent());
    }
}
