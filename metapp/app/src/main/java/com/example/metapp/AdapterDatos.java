package com.example.metapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<ObjectMetapp> datos;

    public AdapterDatos(ArrayList<ObjectMetapp> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(datos.get(position).descripcion, datos.get(position).date);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView descR, dateR;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            descR = itemView.findViewById(R.id.RecyclerDesc);
            dateR = itemView.findViewById(R.id.RecyclerDate);

        }

        public void asignarDatos(String descripcio, String date) {
            descR.setText(descripcio);
            dateR.setText(date);
        }
    }
}
