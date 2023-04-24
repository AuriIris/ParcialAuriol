package com.example.parcialauriol.ui.gallery;

import android.os.Bundle;
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

import com.example.parcialauriol.R;
import com.example.parcialauriol.databinding.FragmentGalleryBinding;
public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final EditText editTextNota = root.findViewById(R.id.editText_nueva_nota);
        Button buttonCargarNota = root.findViewById(R.id.button_cargar);
        buttonCargarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nota = editTextNota.getText().toString().trim();

                // Validar si la nota está vacía
                if (nota.isEmpty()) {
                    Toast.makeText(getContext(), "No se puede agregar una nota vacía", Toast.LENGTH_SHORT).show();
                    return;
                }

                galleryViewModel.agregarNota(nota);

                editTextNota.setText("");
            }
        });

        return root;
    }
}