package com.example.android.maps3;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady=false;

    MarkerOptions griffith_park;

    MarkerOptions grove;

    MarkerOptions man_beach;

    MarkerOptions baby_blues;

    MarkerOptions staples;

    MarkerOptions king_taco;

    MarkerOptions showare;

    static final CameraPosition LOS_ANGELES = CameraPosition.builder()
            .target(new LatLng(34.05016,-118.2539))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        griffith_park = new MarkerOptions()
                .position(new LatLng(34.136555, -118.294197))
                .title("Griffith Park");


        grove = new MarkerOptions()
                .position(new LatLng(34.071733, -118.357143))
                .title("The Grove");


        man_beach = new MarkerOptions()
                .position(new LatLng(33.8847361,-118.4109089))
                .title("Manhattan Beach");


        baby_blues = new MarkerOptions()
                .position(new LatLng(34.0004,-118.4654))
                .title("Baby Blues BBQ");


        staples = new MarkerOptions()
                .position(new LatLng(34.04302,-118.2672))
                .title("Staples Center");


        king_taco = new MarkerOptions()
                .position(new LatLng(34.07619,-118.0213))
                .title("King Taco");




        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map){
        //MapsInitializer.initialize(getApplicationContext());
        mapReady=true;
        m_map = map;
        m_map.addMarker(griffith_park);
        m_map.addMarker(grove);
        m_map.addMarker(man_beach);
        m_map.addMarker(baby_blues);
        m_map.addMarker(staples);
        m_map.addMarker(king_taco);

        flyTo(LOS_ANGELES);
    }

    private void flyTo(CameraPosition target)
    {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
