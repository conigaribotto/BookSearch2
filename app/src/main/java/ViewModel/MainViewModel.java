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

    private MutableLiveData<Libro> mutableLibro;
    private List<Libro> listaLibros;

    public MainViewModel(@NonNull Application application) {
        super(application);
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Mujercitas", "Louisa May Alcott", "Ficcion"));
        listaLibros.add(new Libro("Cazadores de sombra", "Cassandra Clare", "Fantasia y Ciencia ficcion"));
        listaLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico"));
    }

    public LiveData<Libro> getMutableLibro() {
        if (mutableLibro == null) {
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }

    public void buscarLibro(String titulo) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                mutableLibro.setValue(libro);
                return;
            }
        }
        mutableLibro.setValue(null);
    }
}
