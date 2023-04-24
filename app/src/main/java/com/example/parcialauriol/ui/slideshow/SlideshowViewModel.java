package com.example.parcialauriol.ui.slideshow;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.parcialauriol.ui.gallery.NotasAdapter;

import java.util.ArrayList;

public class SlideshowViewModel extends AndroidViewModel {

    private NotasAdapter adapter;
    private MutableLiveData<ArrayList<String>> mNotas;

    public SlideshowViewModel(@NonNull Application application) {
        super(application);
        mNotas = new MutableLiveData<>(new ArrayList<>()); // Inicializar mNotas
    }

    public LiveData<ArrayList<String>> getNotas() {
        return mNotas;
    }

    public void setNotas(ArrayList<String> notas) {
        ArrayList<String> copiaNotas = new ArrayList<>(notas);
        for (String nota : copiaNotas) {
            adapter.agregarNota(nota);
        }
        mNotas.postValue(adapter.obtenerNotas());
    }
}