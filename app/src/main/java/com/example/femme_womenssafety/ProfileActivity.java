package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity  {

 RelativeLayout contact,help,sirenn,safe,signout,current,tip,view_off;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);

        contact = ( RelativeLayout) findViewById(R.id.contactt);
        sirenn = ( RelativeLayout) findViewById(R.id.sirenn);
        safe = ( RelativeLayout) findViewById(R.id.safe);
        current = ( RelativeLayout) findViewById(R.id.current);
        view_off = ( RelativeLayout) findViewById(R.id.view_off);

        tip = ( RelativeLayout) findViewById(R.id.tip);
        help = ( RelativeLayout) findViewById(R.id.help);
        signout = (RelativeLayout)findViewById(R.id.signout);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),helpine.class);
                startActivity(intent);


            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), contacts_activity.class);
                startActivity(intent);

            }
        });

        view_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), contact_added.class);
                startActivity(intent);

            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, tip_off.class));

            }
        });



        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, safety_tips.class));

            }
        });

        sirenn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, Siren_paly.class));
            }
        });
        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, my_current.class));

            }
        });





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

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

                startActivity(sharingIntent);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }





















    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Femme-Women Safety", Toast.LENGTH_SHORT).show();
    }

}