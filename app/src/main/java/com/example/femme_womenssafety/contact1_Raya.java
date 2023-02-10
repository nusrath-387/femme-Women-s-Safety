package com.example.femme_womenssafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class contact1_Raya extends AppCompatActivity {
    String Phone;
    TextView call_raya,send1,email_raya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact1_raya);

        send1=(TextView) findViewById(R.id.send1);
        call_raya=(TextView) findViewById(R.id.call_raya);
        email_raya=(TextView) findViewById(R.id.email_raya);

        email_raya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contact1_Raya.this,send_email_raya.class);
                startActivity(intent);

            }
        });


        call_raya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:8745686799"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8745686799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });
    }
}