package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Siren_paly extends AppCompatActivity {
    ImageButton start_btn, stop_btn;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siren_paly);



    start_btn = (ImageButton) findViewById(R.id.start_btn);
    stop_btn = (ImageButton) findViewById(R.id.stop_btn);

        start_btn.setOnClickListener(new View.OnClickListener() // method when the view(component) is clicked
    {
        @Override  //onCreate method override
        public void onClick(View view) {
        if(mediaPlayer==null){
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.dangersiren);
            mediaPlayer.start();
        }
    }
    });
        stop_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mediaPlayer!=null){
                mediaPlayer.stop();
                mediaPlayer=null;
            }
        }
    });
}

}