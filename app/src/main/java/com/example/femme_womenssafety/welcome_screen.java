package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class welcome_screen extends AppCompatActivity {
    private ProgressBar progress;
 private int progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().hide();

        progress=(ProgressBar)findViewById(R.id.progress);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWrok();
                startWork();

            }








});
        thread.start();
    }



    private void doWrok() {
        for(progressBar=20;progressBar<=100;progressBar=progressBar+20) {
            try {
                Thread.sleep(1000);
                progress.setProgress(progressBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    private void startWork() {
        Intent intent=new Intent(welcome_screen.this,Home_activity.class);
        startActivity(intent);
        finish();
    }


}