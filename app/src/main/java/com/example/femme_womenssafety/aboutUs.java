package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class aboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        //A MenuInflater is an object that is able to create Menu from xml resources (of course only menus resources)
        menuInflater.inflate(R.menu.menu, menu);
        //from where it inflates location

        return true;
    }

    @Override
    //@NonNull annotation you can tell to the compiler that you don't want a null value in position
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
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
                // obtain an instance of signout class by calling getInstance()
                finish();


                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent2);
                break;

            case R.id.share:



                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                //Android uses the action ACTION_SEND to send data from one activity to another
                sharingIntent.setType("text/plain");

                // Body of the content
                String shareBody = "Click the app link.\n\n https://drive.google.com/drive/folders/1VkGLDOOWkPvBNA8wvetj0vCC26_hZaEE?usp=share_link"+getPackageName();

                // subject of the content. you can share anything
                String shareSubject = "Femme app link";

                // passing body of the content
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                //putExtras() to store certain data as a key value pair or Bundle data object
                //EXTRA_TEXT for text sending,EXTRA_STREAM for image sending

                // passing subject of the content
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                //EXTRA_SUBJECT holding the desired subject line of a message
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
               // If you want to custimize the title of that list, you can use createChooser here sharingIntent(subject of the content):

                startActivity(sharingIntent);

                return true;
        }


        return super.onOptionsItemSelected(item);
    }






    @Override
        public void onBackPressed() {
            Intent intent=new Intent(getApplicationContext(),after_homescreen.class);

            startActivity(intent);

            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
