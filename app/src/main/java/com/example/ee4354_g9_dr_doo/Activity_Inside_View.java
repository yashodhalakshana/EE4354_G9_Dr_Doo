package com.example.ee4354_g9_dr_doo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Inside_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_view);
        TextView txtHeading = findViewById(R.id.txtHeadingView);
        TextView txtName = findViewById(R.id.txtNameView);
        TextView txtLocation = findViewById(R.id.txtLocationView);
        TextView txContact = findViewById(R.id.txtContactView);
        TextView txtRewards = findViewById(R.id.txtRewardsView);
        TextView txtRating = findViewById(R.id.txtRatingsView);
        TextView txtLastSeen = findViewById(R.id.txtSeenView);
        ImageView imageView = findViewById(R.id.imageViewOnView);
        Button mapViewButton=findViewById(R.id.btnMapViewOn);

        int Kind=0;
        String Heading = "N/A";
        String Name  = "N/A";
        double lat =0;
        double lan =0;
        String Contact  = "N/A";
        String Rewards  = "N/A";
        String Rating  = "N/A";
        String Date  = "N/A";
        String Image = "";

        Bundle extras = getIntent().getExtras();

        if(extras !=null){
            Kind    =   extras.getInt("Kind");
            Heading =   extras.getString("Heading");
            Name =   extras.getString("Name");
            lat=   extras.getDouble("Lat");
            lan=   extras.getDouble("Lan");
            Contact =   extras.getString("Contact");
            Rewards =   extras.getString("Rewards");
            Rating =   extras.getString("Rating");
            Date =   extras.getString("Date");
            Image=   extras.getString("Image");

        }
        if(Kind==1){ // from Care
            txtHeading.setText("Rescue a " + Heading);
            txtName.setText(Heading);
            txtLastSeen.setText(Date);
            txtLocation.setText(lat +", " + lan);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText("N/A");


        }else if(Kind==2){
            txtHeading.setText("Find a " + Heading);
            txtName.setText(Heading);
            txtLastSeen.setText(Date);
            txtLocation.setText(lat +", " + lan);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText(Rewards);
        }else if(Kind==3){
            txtHeading.setText("Shop of - "+ Heading);
            txtName.setText(Name);
            txtLastSeen.setText("N/A");
            txtLocation.setText(lat +", " + lan);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText("N/A");
        }else if(Kind==4){
            txtHeading.setText("Doctor for pet - "+Heading);
            txtName.setText(Name);
            txtLastSeen.setText("N/A");
            txtLocation.setText(lat +", " + lan);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText(Rating);
        }

        try {
           // imageView.setImageURI(Uri.parse(Image));
        }catch (Exception e){

        }
        double finalLat = lat;
        double finalLan = lan;
        mapViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityMapView.class);
                intent.putExtra("Lat", finalLat);
                intent.putExtra("Lan", finalLan);
                startActivity(intent);
            }
        });


    }
}