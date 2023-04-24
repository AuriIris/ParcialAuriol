package com.example.parcialauriol.ui.gallery;

import android.app.Application;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.parcialauriol.R;
import com.example.parcialauriol.ui.ManejadorNotas;

import java.util.ArrayList;
import java.util.List;
public class GalleryViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<String>> mNotas;
    private ManejadorNotas mManejadorNotas;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        mNotas = new MutableLiveData<>();
        mNotas.setValue(new ArrayList<>()); // Inicializar la lista vacía
        mManejadorNotas = ManejadorNotas.getInstance();
    }

    public LiveData<ArrayList<String>> getNotas() {
        return mNotas;
    }

    public void agregarNota(String nota) {
        mManejadorNotas.agregarNota(nota);
        mNotas.setValue(mManejadorNotas.obtenerNotas());
    }
}