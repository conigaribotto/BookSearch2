package ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.booksearch.R;

import Model.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> mutableLibro;
    private List<Libro> listaLibros;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mutableLibro = new MutableLiveData<>(); // <- inicializado aquí
        listaLibros = new ArrayList<>();

        listaLibros.add(new Libro("Mujercitas", "Louisa May Alcott", "Ficción", R.drawable.mujercitas));
        listaLibros.add(new Libro("Cazadores de sombra", "Cassandra Clare", "Fantasía y Ciencia ficción", R.drawable.cazadores));
        listaLibros.add(new Libro("El tiempo de las moscas", "Claudia Piñeiro", "Policial", R.drawable.moscas));

    }

    public LiveData<Libro> getMutableLibro() {
        return mutableLibro;
    }

    public void buscarLibro(String titulo) {
        if (titulo == null) {
            mutableLibro.setValue(null);
            return;
        }
        String buscado = titulo.trim();
        if (buscado.isEmpty()) {
            mutableLibro.setValue(null);
            return;
        }

        for (Libro libro : listaLibros) {
            // Igualdad completa (case-insensitive). Si quieres coincidencia parcial usa contains()
            if (libro.getTitulo().equalsIgnoreCase(buscado)) {
                mutableLibro.setValue(libro);
                return;
            }
        }
        // no encontrado
        mutableLibro.setValue(null);
    }
}
