package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Home_activity extends AppCompatActivity  {
   Button login,safe;
    LottieAnimationView animation,animatiobb;
    TextView textAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Home Page");
        setContentView(R.layout.activity_home);
        login = (Button) findViewById(R.id.login);
        safe = (Button) findViewById(R.id.safe);
        animation = (LottieAnimationView) findViewById(R.id.animatiob);
        animatiobb = (LottieAnimationView) findViewById(R.id.animatiobb);
        textAnimation = (TextView) findViewById(R.id.textAnimation);





        //Handler is mainly used to update the main thread from background thread or other than main thread
        // Post() − it going to post message from background thread to main thread using looper.
        //Any class whose instances are intended to be executed by a thread should implement the Runnable interface.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000000);


        safe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_activity.this,aboutUs.class));

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_activity.this,after_homescreen.class));

            }
        });


}


}