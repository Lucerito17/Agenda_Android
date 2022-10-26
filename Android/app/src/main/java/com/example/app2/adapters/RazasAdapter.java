package com.example.app2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.R;
import com.example.app2.entities.RazaPerro;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RazasAdapter extends RecyclerView.Adapter{

    List<RazaPerro> data;

    public RazasAdapter(List<RazaPerro> data){this.data = data;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_raza, parent, false);
        return new RazasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvId = holder.itemView.findViewById(R.id.tvId2);
        tvId.setText(data.get(position).id+"");
        TextView tvRaza = holder.itemView.findViewById(R.id.tvRaza2);
        tvRaza.setText(data.get(position).name);
        TextView tvBredFor = holder.itemView.findViewById(R.id.tvBredFor2);
        tvBredFor.setText(data.get(position).bredFor);
        TextView tvTemperament = holder.itemView.findViewById(R.id.tvTemperament2);
        tvTemperament.setText(data.get(position).temperament);
        ImageView ivPerro = holder.itemView.findViewById(R.id.ivImage2);
        Picasso.get().load(data.get(position).image.url).into(ivPerro);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class RazasViewHolder extends RecyclerView.ViewHolder{
        public RazasViewHolder(@NonNull View itemView) {super(itemView); }
    }
}
