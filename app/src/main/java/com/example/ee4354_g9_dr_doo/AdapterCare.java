package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCare extends RecyclerView.Adapter<AdapterCare.MyViewHolder>{
    Context context;
    ArrayList<CardCare> cardArrayList;
    public AdapterCare(Context context, ArrayList<CardCare> newArrayList) {
        this.context=context;
        this.cardArrayList=newArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_care,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CardCare cardCare = cardArrayList.get(position);
        holder.cardHeading.setText(cardCare.cHeading);
        holder.cardContact.setText(cardCare.cContact);
        holder.cardDate.setText(cardCare.cDate);
        holder.cardLocation.setText(cardCare.cLocation);
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cardHeading;
        TextView cardLocation;
        TextView cardContact;
        TextView cardDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeading = itemView.findViewById(R.id.txtHeadCare);
            cardLocation = itemView.findViewById(R.id.txtLocationCare);
            cardContact = itemView.findViewById(R.id.txtContactCare);
            cardDate = itemView.findViewById(R.id.txtDateCare);

        }
    }
}
