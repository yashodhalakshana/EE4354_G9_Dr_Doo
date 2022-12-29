package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterVet extends RecyclerView.Adapter<AdapterVet.MyViewHolder>{


    Context context;
    ArrayList<CardVet> cardArrayList;
    private  static AdapterVet.RecyclerViewClickListener listener;
    public AdapterVet(Context context, ArrayList<CardVet> newArrayList, AdapterVet.RecyclerViewClickListener listener) {
        this.context=context;
        this.cardArrayList=newArrayList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public AdapterVet.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_vet,parent,false);
        return new AdapterVet.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVet.MyViewHolder holder, int position) {
        CardVet cardVet = cardArrayList.get(position);
        holder.cardHeading.setText(cardVet.cHeading);
        holder.cardContact.setText(cardVet.cContact);
        holder.cardName.setText(cardVet.cName);
        holder.cardLocation.setText(cardVet.cLocation.latitude + ", " + cardVet.cLocation.longitude);
        holder.cardRating.setText(cardVet.cRating);
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView cardHeading;
        TextView cardLocation;
        TextView cardContact;
        TextView cardName;
        TextView cardRating;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeading = itemView.findViewById(R.id.txtHeadVet);
            cardLocation = itemView.findViewById(R.id.txtLocationVet);
            cardContact = itemView.findViewById(R.id.txtContactVet);
            cardName = itemView.findViewById(R.id.txtNameVet);
            cardRating=itemView.findViewById(R.id.txtRatings);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
}
