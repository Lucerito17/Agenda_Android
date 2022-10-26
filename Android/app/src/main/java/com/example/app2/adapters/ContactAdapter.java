package com.example.app2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.R;
import com.example.app2.entities.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {

    List<Contact> data;

    public ContactAdapter (List<Contact> data){
        this.data = data;
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_contact, parent, false);
        return new ContactAdapter.ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        tvName.setText(data.get(position).nombre + " " + data.get(position).apellido);

        TextView tvNumber = holder.itemView.findViewById(R.id.tvNumber);
        tvNumber.setText(data.get(position).numero+ "");

        ImageView ivImage = holder.itemView.findViewById(R.id.ivImage);
        //ivImage.setImageResource(R.drawable.uno);
        Picasso.get().load(data.get(position).imgUrl).into(ivImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        public ContactViewHolder( View itemView){
            super(itemView);
        }
    }

}
