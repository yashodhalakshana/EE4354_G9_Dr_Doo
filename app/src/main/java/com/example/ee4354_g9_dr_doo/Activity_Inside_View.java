package com.example.ee4354_g9_dr_doo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        int Kind=0;
        String Heading = "N/A";
        String Name  = "N/A";
        String Location  = "N/A";
        String Contact  = "N/A";
        String Rewards  = "N/A";
        String Rating  = "N/A";
        String Date  = "N/A";

        Bundle extras = getIntent().getExtras();

        if(extras !=null){
            Kind    =   extras.getInt("Kind");
            Heading =   extras.getString("Heading");
            Name =   extras.getString("Name");
            Location =   extras.getString("Location");
            Contact =   extras.getString("Contact");
            Rewards =   extras.getString("Rewards");
            Rating =   extras.getString("Rating");
            Date =   extras.getString("Date");

        }
        if(Kind==1){ // from Care
            txtHeading.setText("Rescue a " + Heading);
            txtName.setText(Heading);
            txtLastSeen.setText(Date);
            txtLocation.setText(Location);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText("N/A");

        }else if(Kind==2){
            txtHeading.setText("Find a " + Heading);
            txtName.setText(Heading);
            txtLastSeen.setText(Date);
            txtLocation.setText(Location);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText(Rewards);
        }else if(Kind==3){
            txtHeading.setText("Shop of - "+ Heading);
            txtName.setText(Name);
            txtLastSeen.setText("N/A");
            txtLocation.setText(Location);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText("N/A");
        }else if(Kind==4){
            txtHeading.setText("Doctor for pet - "+Heading);
            txtName.setText(Name);
            txtLastSeen.setText("N/A");
            txtLocation.setText(Location);
            txContact.setText(Contact);
            txtRewards.setText("N/A");
            txtRating.setText(Rating);
        }



    }
}