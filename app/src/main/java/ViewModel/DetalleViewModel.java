package ViewModel;

import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import Model.Libro;

public class DetalleViewModel extends AndroidViewModel {

    private MutableLiveData<Libro> mutableLibro;

    public DetalleViewModel(@NonNull Application application) {
        super(application);
        mutableLibro = new MutableLiveData<>();
    }

    public MutableLiveData<Libro> getMutableLibro() {
        return mutableLibro;
    }

    public void cargarLibro(Intent intent) {
        Libro libro = (Libro) intent.getSerializableExtra("libro");
        if (libro != null) {
            mutableLibro.setValue(libro);
        }
    }
}
