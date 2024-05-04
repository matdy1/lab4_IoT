package com.example.lab4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.R;
import com.example.lab4.entity.Clime;

import java.util.List;

public class ClimeAdapter extends RecyclerView.Adapter<ClimeAdapter.ClimeViewHolder>{

    private List<Clime> listaClimates;
    private Context context;

    public List<Clime> getListaClimates() {
        return listaClimates;
    }

    public void setListaClimates(List<Clime> listaClimates) {
        this.listaClimates = listaClimates;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ClimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_city, parent, false);
        return new ClimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimeViewHolder holder, int position) {
        Clime c = listaClimates.get(position);
        holder.clime = c;

        TextView textViewModelo = holder.itemView.findViewById(R.id.nombreCiudad);
        textViewModelo.setText(c.getName());

        TextView textViewMarca = holder.itemView.findViewById(R.id.temp);
        textViewMarca.setText((int) c.getMain().getTemp());

        TextView textViewFecha = holder.itemView.findViewById(R.id.min);
        textViewFecha.setText("Min: "+ c.getMain().getTemp_min());

        TextView textViewFecha1 = holder.itemView.findViewById(R.id.max);
        textViewFecha1.setText("Max: "+ c.getMain().getTemp_max());


    }

    @Override
    public int getItemCount() {
        return listaClimates.size();
    }

    public class ClimeViewHolder extends RecyclerView.ViewHolder {
        Clime clime;

        public ClimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
