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
        Intent intent=new Intent(account_created.this,ProfileActivity.class);
        startActivity(intent);
        finish();
    }
    }
