package com.example.parcialauriol.ui.slideshow;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.parcialauriol.ui.gallery.NotasAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlideshowViewModel extends AndroidViewModel {

    public SlideshowViewModel(@NonNull Application application) {
        super(application);
    }

    public List<String> agregarNota(List notas, String nota){
        if(nota.length() == 0){
            Toast.makeText(getApplication(), "Ingrese una nota!", Toast.LENGTH_SHORT).show();
            return notas;
        }
        else {
            notas.add(nota);
            Toast.makeText(getApplication(), "Nota agregada!", Toast.LENGTH_SHORT).show();
            return notas;
        }

    }


}