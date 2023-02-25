package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class contact1_Raya extends AppCompatActivity {
    String Phone;
    TextView call_raya,send1,email_raya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact1_raya);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);

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
                //implicit intent
                Intent intent=new Intent(Intent.ACTION_DIAL);
                //ACTION_DIAL Display the phone dialer with the person filled in.
                intent.setData(Uri.parse("tel:8745686799"));//for avoiding error have to give 'tel'

                //
                //setData() is used to point to the location of a data object
                //uri parse - want to pass data through intent(convert into the text)
                startActivity(intent);
            }
        });

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ACTION_VIEW Selecting a particular person to view would result in a new intent
                //ACTION_VIEW start an activity to display information
                //????Ask sir must
                //uri.fromparts  contains the scheme(sms/mms), scheme-specific part (ssp(phone no)) and the fragment (null in your case)
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8745686799","null"));
                intent.putExtra("sms_body","");
                //    intent.putExtra putExtra() method is to send values you need in the next activity.
                // while putExtra() adds simple data types
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homeee:
                Intent intent = new Intent(getApplicationContext(), Home_activity.class);

                startActivity(intent);
                break;


            case R.id.about:
                Intent intent1 = new Intent(getApplicationContext(),aboutUs.class);

                startActivity(intent1);
                break;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                finish();


                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent2);
                break;

            case R.id.share:
                FirebaseAuth.getInstance().signOut();
                finish();


                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Click the app link.\n\n https://drive.google.com/drive/folders/1VkGLDOOWkPvBNA8wvetj0vCC26_hZaEE?usp=share_link"+getPackageName();

                // subject of the content. you can share anything
                String shareSubject = "Your Subject Here";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

                startActivity(sharingIntent);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }






}