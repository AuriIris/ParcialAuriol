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

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotaViewHolder> {

    private ArrayList<String> notas;
    private Context context;

    public NotasAdapter(Context context, ArrayList<String> notas) {
        this.context = context;
        this.notas = notas;
    }
    public void setNotas(ArrayList<String> notas) {
        //Log.d("NotasAdapter", "setNotas: Notas recibidas = " + notas);
        this.notas = notas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        NotaViewHolder vh = new NotaViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        String notaActual = notas.get(position);
        holder.tvNota.setText(notaActual);
    }

    @Override
    public int getItemCount() {
        return notas != null ? notas.size() : 0;
    }
    public static class NotaViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNota;

        public NotaViewHolder(View itemView) {
            super(itemView);
            tvNota = itemView.findViewById(R.id.tv_nota);
        }
    }

}