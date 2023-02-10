package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class helpine extends AppCompatActivity {
     Button police_call,domestic,student,hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_helpine);
        this.setTitle("HelpLine");

        police_call=(Button)findViewById(R.id.police_call) ;
        hospital=(Button)findViewById(R.id.hospital) ;
        domestic=(Button)findViewById(R.id.domestic) ;
        student=(Button)findViewById(R.id.student) ;
        police_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //Uniform resource identifiers (URI)mobile applications use URIs to provide an address
                intent.setData(Uri.parse("tel:100"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:1098"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });
       hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //Uniform resource identifiers (URI)mobile applications use URIs to provide an address
                intent.setData(Uri.parse("tel:102"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });

       domestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //Uniform resource identifiers (URI)mobile applications use URIs to provide an address
                intent.setData(Uri.parse("tel:181"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });

    }
}