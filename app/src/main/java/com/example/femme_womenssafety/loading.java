package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class loading extends AppCompatActivity {
    LottieAnimationView wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
       wait= (LottieAnimationView) findViewById(R.id.wait);
       wait.animate().translationX(2000).setDuration(2000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(loading.this,ProfileActivity.class));

            }
        }, 1000);

    }
}