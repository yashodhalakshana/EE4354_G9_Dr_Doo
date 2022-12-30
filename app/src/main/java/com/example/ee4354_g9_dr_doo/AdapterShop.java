package com.example.ee4354_g9_dr_doo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterShop extends RecyclerView.Adapter<AdapterShop.MyViewHolder>{

    Context context;
    ArrayList<CardShop> cardArrayList;
    private  static AdapterShop.RecyclerViewClickListener listener;

    public AdapterShop(Context context, ArrayList<CardShop> newArrayList, AdapterShop.RecyclerViewClickListener listener) {
        this.context=context;
        this.cardArrayList=newArrayList;
        this.listener=listener;
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
        holder.cardLocation.setText(cardShop.cLocation.latitude + ", " + cardShop.cLocation.longitude);
        //holder.cardImage.setImageURI(Uri.parse(cardShop.cImage));
    }

    @Override
    public int getItemCount() {
        return cardArrayList.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView cardHeading;
        TextView cardLocation;
        TextView cardContact;
        TextView cardName;
        ImageView cardImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeading = itemView.findViewById(R.id.txtHeadShop);
            cardLocation = itemView.findViewById(R.id.txtLocationShop);
            cardContact = itemView.findViewById(R.id.txtContactShop);
            cardName = itemView.findViewById(R.id.txtNameShop);
            cardImage=itemView.findViewById(R.id.imageViewCare);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
}
