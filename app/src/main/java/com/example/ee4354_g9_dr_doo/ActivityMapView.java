package com.example.ee4354_g9_dr_doo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityMapView extends AppCompatActivity implements OnMapReadyCallback {
    double lat=0;
    double lan=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);

        Bundle extras = getIntent().getExtras();
        lat=   extras.getDouble("Lat");
        lan=   extras.getDouble("Lan");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng sydney = new LatLng(lat, lan);
        googleMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("It locates here"));
        // [START_EXCLUDE silent]

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.animateCamera( CameraUpdateFactory.zoomTo( 12.0f ));
    }
}