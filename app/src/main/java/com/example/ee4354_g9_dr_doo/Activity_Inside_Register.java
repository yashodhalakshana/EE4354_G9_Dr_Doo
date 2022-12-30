package com.example.ee4354_g9_dr_doo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ee4354_g9_dr_doo.databinding.ActivityMainTabBinding;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.List;

public class Activity_Inside_Register extends AppCompatActivity {
    private int kindInt =0;
    EditText editLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_register);
        Button btnMap = findViewById(R.id.btnSetOnMap);
        Button btnReg = findViewById(R.id.btnRegister);
        TextView textHeading = findViewById(R.id.txtHeadingRegView);
        EditText editName = findViewById(R.id.editName);
        EditText editContact = findViewById(R.id.editContact);
        EditText editDate = findViewById(R.id.editDate);
        EditText editRewards = findViewById(R.id.editRewards);
        EditText editRatings = findViewById(R.id.editRating);
        editLocation = findViewById(R.id.editLocation);


        Bundle extras = getIntent().getExtras();
        kindInt = extras.getInt("Kind");
        switch (kindInt){
            case 1:
                textHeading.setText("New Animal To Rescue");
                break;
            case 2:
                textHeading.setText("Find My Pet");
                break;
            case 3:
                textHeading.setText("Add a Pet Shop");
                break;
            case 4:
                textHeading.setText("Add a Veterinarian");
                break;
        }

        FloatingActionButton fab = findViewById(R.id.fabAddImage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // code to select image
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,2);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(),mapActivity.class);
            startActivityForResult(intent,1);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ADD DATABASE CODE
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) { // from map
            if (resultCode == RESULT_OK) {
              double dLat = data.getDoubleExtra("Lat",0);
              double dLan = data.getDoubleExtra("Lan",0);
              editLocation.setText(dLat + ", "+dLan);
            }
        }else if(requestCode==2){ // from image browser
            if (resultCode == RESULT_OK && data !=null) {
                Uri selectImage = data.getData();
                ImageView imageView = findViewById(R.id.imageReg);
                imageView.setImageURI(selectImage);

            }
        }
    }



}