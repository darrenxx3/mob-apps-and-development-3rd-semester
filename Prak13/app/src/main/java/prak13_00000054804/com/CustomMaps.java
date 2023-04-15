package prak13_00000054804.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CustomMaps extends AppCompatActivity {
    Button terrain, satellite, normal, hybrid, mylocation, search;
    GoogleMap map;
    LatLng home, position;
    Double latitude, longitude, x, y;
    int PLACE_AUTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_maps);

        terrain=(Button) findViewById(R.id.btnTerrainMode);
        hybrid=(Button) findViewById(R.id.btnHybrid);
        satellite=(Button) findViewById(R.id.btnSatelliteMode);
        normal=(Button) findViewById(R.id.btnNormalMode);
        search=(Button) findViewById(R.id.btnSearch);
        mylocation=(Button) findViewById(R.id.btnMyLocations);

        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
        mylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(ActivityCompat.checkSelfPermission(getApplicationContext(this)),
                    Manifest.permission.ACCESS_FINE_LOCATION != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getApplicationContext(),"Error: Tidak ada akses ke GPS", Toast.LENGTH_LONG).show();
                        return;
                    }
                    map.setMyLocationEnabled(true);
                    LocationManager locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);
                    Criteria criteria = new Criteria();
                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();

                    position = new LatLng(latitude, longitude);
                    map.addMarker(new MarkerOptions().position(position).title("My Location Now")).showInfoWindow();
                    map.animateCamera(CameraUpdateFactory.newLatLng(position));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 18));
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                try{
                    intent= new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN).build(CustomMaps.this);
                    startActivityForResult(intent, PLACE_AUTO);
                }catch (GooglePlayServicesRepairableException e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }catch (GooglePlayServicesNotAvailableException e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void OnMapReady(GoogleMap googleMap){
        map = googleMap;

        home= new LatLng(-6.257385, 106.618320);
        map.addMarker(new MarkerOptions().position(home).title("Welcome to UMN")).showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newLatLng(home));
        map.moveCamera(CameraUpdateFactory.newLatLng(home, 16));
        map.setTrafficEnabled(true);
    }
    try{
        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    catch (Exception e){
        Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == PLACE_AUTO){
            if(resultCode == RESULT_OK){
                Place place = PlaceAutocomplete.getPlace(this, data);
                LatLng search = place.getLatLng();
                x = place.getLatLng().latitude;
                y = place.getLatLng().longitude;
                String alamat = place.getAddress().toString();
                String telp = place.getPhoneNumber().toString();
                String nama = place.getName().toString();
                String snip = alamat+System.getProperty("Line.separator")+telp;
                map.addMarker(new MarkerOptions().position(search).title(nama).snippet(snip)).showInfoWindow();
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(search, 18));

            }
        }
    }
}