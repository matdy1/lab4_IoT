package com.example.lab4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4.entity.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{

    private List<City> listaCities;
    private Context context;

    public List<City> getListSites() {
        return listaCities;
    }

    public void setListSites(List<City> listaCities) {
        this.listaCities = listaCities;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_city, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City c = listaCities.get(position);
        holder.city = c;

        TextView textViewModelo = holder.itemView.findViewById(R.id.nombreCiudad);
        textViewModelo.setText(c.getName());

        TextView textViewMarca = holder.itemView.findViewById(R.id.lon);
        textViewMarca.setText("Lat: "+ c.getLat());

        TextView textViewFecha = holder.itemView.findViewById(R.id.lon);
        textViewFecha.setText("Lon: "+ c.getLon());

    }

    @Override
    public int getItemCount() {
        return listaCities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        City city;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
