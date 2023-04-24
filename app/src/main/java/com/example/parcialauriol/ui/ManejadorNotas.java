package com.example.parcialauriol.ui;

import android.util.Log;

import com.example.parcialauriol.ui.gallery.GalleryViewModel;

import java.util.ArrayList;

public class ManejadorNotas {
    private static ManejadorNotas Mn;

    private ArrayList<String> mNotas;

    private ManejadorNotas() {
        mNotas = new ArrayList<>();
    }

    public static synchronized ManejadorNotas getInstance() {
        if (Mn == null) {
            Mn = new ManejadorNotas();
        }
        return Mn;
    }

    public void agregarNota(String nota) {
        mNotas.add(nota);
        for (int i = 0; i < mNotas.size(); i++) {
            String nota1 = mNotas.get(i);
            Log.d("NotasAdapter", "setNotas: Notas recibidas = " + nota1);
        }
    }

    public ArrayList<String> obtenerNotas() {
        return mNotas;
    }

}