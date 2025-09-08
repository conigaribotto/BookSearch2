package ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import Model.Libro;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final MutableLiveData<Libro> mutableLibro;
    private final List<Libro> listaLibros;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mutableLibro = new MutableLiveData<>();
        listaLibros = new ArrayList<>();

        listaLibros.add(new Libro("Mujercitas", "Louisa May Alcott", "Ficción"));
        listaLibros.add(new Libro("Cazadores de sombra", "Cassandra Clare", "Fantasía y Ciencia ficción"));
        listaLibros.add(new Libro("El tiempo de las moscas", "Claudia Piñeiro", "Policial"));
    }

    public LiveData<Libro> getMutableLibro() {
        return mutableLibro;
    }

    public void buscarLibro(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            mutableLibro.setValue(null);
            return;
        }

        String tituloNormalizado = titulo.trim().toLowerCase();

        for (Libro libro : listaLibros) {
            String libroTitulo = libro.getTitulo().trim().toLowerCase();
            if (libroTitulo.contains(tituloNormalizado)) {
                mutableLibro.setValue(libro);
                return;
            }
        }

        mutableLibro.setValue(null);
    }
}
