package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class contact_added extends AppCompatActivity {
    DatabaseReference databaseReference;
    private List<Contact_store> contact;
   private custom customAdapter;
   private ListView list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_added);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);

        databaseReference = FirebaseDatabase.getInstance().getReference("femme_our project");

        contact=new ArrayList<Contact_store>();
        customAdapter=new custom(contact_added.this,contact);
        // Adapters are responsible for supplying the data and creating the views representing each item
        //Custom ArrayAdapter – It is used whenever we need to display a custom list
        list_item=findViewById(R.id.list_item);

    }

    @Override
    protected void onStart() {
        //A ValueEventListener listens for data changes to a specific location in your database -
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            // ValueEventListener has one event callback method and read a static snapshot of the contents at a given path
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contact.clear();
                //A DataSnapshot instance contains data from a Firebase Database location
                // Then, each time the contents change, another call updates the document snapshot.
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                //getChildren() Gives access to all of the immediate children of this snapshot.
                {
                    Contact_store students=snapshot1.getValue(Contact_store.class);
                    //getValue() returns the data contained in this snapshot
                    contact.add(students);
                }
                list_item.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
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