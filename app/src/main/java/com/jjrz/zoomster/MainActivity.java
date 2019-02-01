package com.jjrz.zoomster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapView mv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mv1 = findViewById(R.id.mapView1);
        mv1.onCreate(savedInstanceState);
        mv1.getMapAsync(this);

        Button btnTestClick = findViewById(R.id.btnAction);
        btnTestClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Bwahahahaha!",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onResume() {
        mv1.onResume();
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        mv1.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mv1.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mv1.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(33.896945, -118.206899);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.setMaxZoomPreference(20.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
