package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterShop extends RecyclerView.Adapter<AdapterShop.MyViewHolder>{

    Context context;
    ArrayList<CardShop> cardArrayList;
    public AdapterShop(Context context, ArrayList<CardShop> newArrayList) {
        this.context=context;
        this.cardArrayList=newArrayList;
    }

    @NonNull
    @Override
    public AdapterShop.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_shop,parent,false);
        return new AdapterShop.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterShop.MyViewHolder holder, int position) {
        CardShop cardShop = cardArrayList.get(position);
        holder.cardHeading.setText(cardShop.cHeading);
        holder.cardContact.setText(cardShop.cContact);
        holder.cardName.setText(cardShop.cName);
        holder.cardLocation.setText(cardShop.cLocation);
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cardHeading;
        TextView cardLocation;
        TextView cardContact;
        TextView cardName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeading = itemView.findViewById(R.id.txtHeadShop);
            cardLocation = itemView.findViewById(R.id.txtLocationShop);
            cardContact = itemView.findViewById(R.id.txtContactShop);
            cardName = itemView.findViewById(R.id.txtNameShop);

        }
    }
}
