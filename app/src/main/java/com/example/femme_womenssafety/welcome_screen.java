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

        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().hide();

        progress=(ProgressBar)findViewById(R.id.progress);


        Thread thread=new Thread(new Runnable() {
            //Thread is  lightweight sub-process that provides us a way to do background operations without interrupting the User Interface (UI).
            // When an app is launched, it creates a single thread in which all app components will run by default.
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
                //every one second progressbar's value will be changed,thats why we set
                //value int progressbar
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