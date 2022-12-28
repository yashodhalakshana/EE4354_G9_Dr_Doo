package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFind extends RecyclerView.Adapter<AdapterFind.MyViewHolder>{
    Context context;
    ArrayList<CardFind> cardArrayList;

    public AdapterFind(Context context, ArrayList<CardFind> newArrayList) {
        this.context=context;
        this.cardArrayList=newArrayList;
    }

    @NonNull
    @Override
    public AdapterFind.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_find,parent,false);
        return new AdapterFind.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFind.MyViewHolder holder, int position) {
        CardFind cardFind = cardArrayList.get(position);
        holder.cardHeading.setText(cardFind.cHeading);
        holder.cardContact.setText(cardFind.cContact);
        holder.cardDate.setText(cardFind.cDate);
        holder.cardLocation.setText(cardFind.cLocation);
        holder.cardReward.setText(cardFind.cRewards);
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
        TextView cardReward;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeading = itemView.findViewById(R.id.txtHeadFind);
            cardLocation = itemView.findViewById(R.id.txtLocationFind);
            cardContact = itemView.findViewById(R.id.txtContactFind);
            cardDate = itemView.findViewById(R.id.txtDateFind);
            cardReward = itemView.findViewById(R.id.txtRewardsFind);
        }
    }
}
