package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

 LinearLayout  contact,helplinee,sirenn,safe,signout,current,tip,view_off;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.setTitle("Contact");
        contact = (LinearLayout) findViewById(R.id.contactt);
        sirenn = (LinearLayout) findViewById(R.id.sirenn);
        safe = (LinearLayout) findViewById(R.id.safe);
        current = (LinearLayout) findViewById(R.id.current);
        view_off = (LinearLayout) findViewById(R.id.view_off);

        tip = (LinearLayout) findViewById(R.id.tip);
        helplinee = (LinearLayout) findViewById(R.id.helplinee);
        signout = (LinearLayout) findViewById(R.id.signout);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        view_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), viewContactt.class);
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


        helplinee.setOnClickListener((View.OnClickListener) this);
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

//        contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ProfileActivity.this,contacts_activity.class));
//            }
//        });
//
//
//
//
//    }
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,contacts_activity.class));

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){



            case (R.id.helplinee):
            {
                startActivity(new Intent(ProfileActivity.this,helpine.class));

            }












        }
}

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}