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

import com.example.parcialauriol.R;
import com.example.parcialauriol.databinding.FragmentSlideshowBinding;
import com.example.parcialauriol.ui.ManejadorNotas;
import com.example.parcialauriol.ui.gallery.GalleryViewModel;
import com.example.parcialauriol.ui.gallery.NotasAdapter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private NotasAdapter mAdapter;
    private ManejadorNotas mManejadorNotas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mRecyclerView = root.findViewById(R.id.recycler_view_notas);
        mAdapter = new NotasAdapter(getContext(),new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mManejadorNotas = ManejadorNotas.getInstance();
        mViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        mViewModel.getNotas().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> notas) {
                mAdapter.setNotas(notas);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.setNotas(mManejadorNotas.obtenerNotas());
    }
}