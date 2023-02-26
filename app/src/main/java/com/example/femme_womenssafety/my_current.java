package com.example.femme_womenssafety;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class my_current extends AppCompatActivity  implements OnMapReadyCallback{
    GoogleMap mMap;
    SupportMapFragment supportMapFragment;
    public boolean oke = false;
    TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_current);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);

        text1=(TextView)findViewById(R.id.text1) ;
        text2=(TextView)findViewById(R.id.text2);
        text3=(TextView)findViewById(R.id.text3);

        //  supportMapFragment This fragment is the simplest way to place a map in an application.

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //FragmentManager is class provided by the framework which is used to
        // create transactions for adding, removing or replacing fragments.getSupportFragmentManager  is fragment

        supportMapFragment.getMapAsync(this);
        //getMapAsync(OnMapReadyCallback) This class automatically initializes the maps system and the view.
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //LocationManager is the main class through which your application can access location services on Android.
        //system services, a reference can be obtained from calling the getSystemService() metho



        //You can use the API that requires the permission.
        if (ActivityCompat.checkSelfPermission(my_current.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        //ACCESS_COARSE_LOCATION permission if your application uses a network-based location provider only.
            //The more accurate GPS requires the ACCESS_FINE_LOCATION permission

        {
          //You can directly ask for the permission.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);

        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                if (oke) {
                    LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title("I am here"));
                    //marker option standard icon,title through MarkerOptions()

                    //The Maps SDK for Android allows you to change the user's viewpoint of the map by modifying the map's camera.
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    //CameraUpdateFactory.newLatLng(LatLng) gives you a CameraUpdate that changes the camera's latitude and longitude

                    text1.setText(String.valueOf(location.getLatitude()));
                    text2.setText(String.valueOf(location.getLongitude()));


                }
            }
        });
    }


    @Override
    //When map is loading onMapReady(GoogleMap googleMap)
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        oke = true;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeee:
                Intent intent = new Intent(getApplicationContext(), Home_activity.class);

                startActivity(intent);
                break;


            case R.id.about:
                Intent intent1 = new Intent(getApplicationContext(),aboutUs.class);

                startActivity(intent1);
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                finish();


                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent2);
                break;

            case R.id.share:
                FirebaseAuth.getInstance().signOut();
                finish();


                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Click the app link.\n\n https://drive.google.com/drive/folders/1VkGLDOOWkPvBNA8wvetj0vCC26_hZaEE?usp=share_link"+getPackageName();

                // subject of the content. you can share anything
                String shareSubject = "Your Subject Here";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                //The putExtra() method is used to send data between Android activities.

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

                startActivity(sharingIntent);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }






}
