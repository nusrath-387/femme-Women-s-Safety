package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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

        databaseReference = FirebaseDatabase.getInstance().getReference("femme_our project");

        contact=new ArrayList<Contact_store>();
        customAdapter=new custom(contact_added.this,contact);
        list_item=findViewById(R.id.list_item);

    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                contact.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    Contact_store students=snapshot1.getValue(Contact_store.class);
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
}