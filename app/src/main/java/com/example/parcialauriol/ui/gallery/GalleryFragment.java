package com.example.parcialauriol.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialauriol.MainActivity;
import com.example.parcialauriol.R;
import com.example.parcialauriol.databinding.FragmentGalleryBinding;
public class GalleryFragment extends Fragment {

    private RecyclerView rv;
    private NotasAdapter ma;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        rv = root.findViewById(R.id.recycler_view_notas);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        ma = new NotasAdapter();
        rv.setAdapter(ma);

        GalleryViewModel actividadvm = new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
        actividadvm.getActividades().observe(getViewLifecycleOwner(), actividades -> {
            ma.setActividades(getContext(), MainActivity.notas);
        });
        return root;
    }}
