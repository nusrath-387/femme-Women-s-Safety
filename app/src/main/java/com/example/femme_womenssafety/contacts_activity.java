package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contacts_activity extends AppCompatActivity {
    Button addData,loadData;
    EditText addNum,addNam;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        databaseReference= FirebaseDatabase.getInstance().getReference("femme_our project");

        addData=(Button) findViewById(R.id.addButton);

        addNam=(EditText) findViewById(R.id.addNam);
        addNum=(EditText) findViewById(R.id.addNum);
//        loadData.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent intent=new Intent(getApplicationContext(),viewContactt.class);
//        startActivity(intent);
//
//    }
//});

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }


        });
    }
    private void saveData() {
        String name=addNam.getText().toString();
        String number=addNum.getText().toString();
        String key=databaseReference.push().getKey();
        Contact_store Contact_store=new Contact_store(name,number);
        databaseReference.child(key).setValue("Contact_store");

        DatabaseReference postsRef = databaseReference.child("femme_our project");

        DatabaseReference newPostRef = postsRef.push();
        Toast.makeText(this, "suceesfully done", Toast.LENGTH_SHORT).show();

    }


}