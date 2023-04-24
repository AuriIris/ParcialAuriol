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

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<String>> mNotas;
    private NotasAdapter mNotasAdapter;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        mNotas = new MutableLiveData<>(new ArrayList<>());
        mNotasAdapter = new NotasAdapter(application.getApplicationContext(), mNotas.getValue());
    }

    public LiveData<ArrayList<String>> getNotas() {
        return mNotas;
    }

    public void agregarNota(String nota) {
        mNotasAdapter.agregarNota(nota);
        mNotas.setValue(mNotasAdapter.obtenerNotas());
    }

    public ArrayList<String> obtenerNotas() {
        return mNotas.getValue();
    }
}