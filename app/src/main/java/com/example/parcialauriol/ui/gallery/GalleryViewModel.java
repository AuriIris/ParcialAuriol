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

    private MutableLiveData<List<String>> actividadesMutableLiveData;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        actividadesMutableLiveData = new MutableLiveData<>();
        cargarActividades();
    }

    private void cargarActividades() {
        List<String> actividades = new ArrayList<>();
        actividadesMutableLiveData.setValue(actividades);
    }

    public MutableLiveData<List<String>> getActividades() {
        return actividadesMutableLiveData;
    }
}