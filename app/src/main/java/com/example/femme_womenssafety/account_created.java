package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class account_created extends AppCompatActivity {
    private ProgressBar progress;
    private int progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_created);
        getSupportActionBar().hide();
        progress=(ProgressBar)findViewById(R.id.progress);

//Any class whose instances are intended to be executed by a thread should implement the Runnable interface
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
                // The Java Thread.sleep() method can be used to pause the execution of the current
                // thread for a specified time in milliseconds.
                progress.setProgress(progressBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //The printStackTrace() method in Java is a tool used to handle exceptions and errors.
            }
        }

    }
    private void startWork() {
        Intent intent=new Intent(account_created.this,ProfileActivity.class);
        startActivity(intent);
        finish();
    }
    }
