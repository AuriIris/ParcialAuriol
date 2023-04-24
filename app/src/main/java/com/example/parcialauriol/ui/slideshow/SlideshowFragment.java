package com.example.parcialauriol.ui.slideshow;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialauriol.MainActivity;
import com.example.parcialauriol.R;
import com.example.parcialauriol.databinding.FragmentSlideshowBinding;
import com.example.parcialauriol.ui.gallery.GalleryViewModel;
import com.example.parcialauriol.ui.gallery.NotasAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel vm =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        GalleryViewModel gm =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gm.getActividades().observe(getActivity(), new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> strings) {
                        vm.agregarNota(MainActivity.notas,binding.editTextNuevaNota.getText()+"");
                    }
                });
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}