package com.example.parcialauriol.ui.gallery;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialauriol.R;

import java.util.ArrayList;
import java.util.List;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder>{
    private List<String> actividades;
    Context context;
    private LayoutInflater inflater;


    public void setActividades(Context context, List<String> actividades) {
        this.actividades = actividades;
        this.context=context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String nota = actividades.get(position);
        holder.Tvnombre.setText(nota);

    }

    @Override
    public int getItemCount() {
        return actividades != null ? actividades.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Tvnombre;

        public ViewHolder(View itemView) {
            super(itemView);
            Tvnombre = itemView.findViewById(R.id.tv_nota);
        }

    }
}
