package com.example.cacau2.testeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final LatLng VICOSA = new LatLng(- 20.7546,  -42.8825);
    private final LatLng UBA = new LatLng(-21.120123,-42.9426188 );
    private final LatLng CAIRO = new LatLng(30.0444196, 31.2357116 );

    private GoogleMap mMap;
    public Button vicosa_btn, uba_btn, cairo_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);

        vicosa_btn = findViewById(R.id.btn_vicosa);
        uba_btn = findViewById(R.id.btn_uba);
        cairo_btn = findViewById(R.id.btn_cairo);
    }

    public void onClick_Vicosa(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VICOSA,10));
    }

    public void onClick_Uba(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UBA,14));
    }

    public void onClick_Cairo(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CAIRO,2));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng vicosa = new LatLng( - 20.7546,  -42.8825);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(VICOSA));
        mMap.addMarker(new MarkerOptions().
                position(VICOSA).
                title("Marker in Viçosa City"));
        mMap.addMarker(new MarkerOptions().
                position(UBA).
                title("Marker in Ubá City"));
        mMap.addMarker(new MarkerOptions().
                position(CAIRO).
                title("Marker in Cairo City"));
    }

}
