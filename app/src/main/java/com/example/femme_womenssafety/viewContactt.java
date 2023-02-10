package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class viewContactt extends AppCompatActivity {
    ImageView phoneCall,msgRegister,phoneCall2,msgRegister2,phoneCall3,msgRegister3,phoneCall4,msgRegister4,phoneCall5,msgRegister5,phoneCall6,msgRegister6;
//    ListView list_itemw;
//    ArrayList<String>myArrayList=new ArrayList<>();
////    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contactt);
ImageView phoneCall=(ImageView) findViewById(R.id.phoneCall);
        ImageView msgRegister=(ImageView) findViewById(R.id.msgRegister);
        ImageView phoneCall2=(ImageView) findViewById(R.id.phoneCall2);
        ImageView msgRegister2=(ImageView) findViewById(R.id.msgRegister2);
        ImageView phoneCall3=(ImageView) findViewById(R.id.phoneCall3);
        ImageView msgRegister3=(ImageView) findViewById(R.id.msgRegister3);
        ImageView phoneCall4=(ImageView) findViewById(R.id.phoneCall4);
        ImageView msgRegister4=(ImageView) findViewById(R.id.msgRegister4);
        ImageView phoneCall5=(ImageView) findViewById(R.id.phoneCall5);
        ImageView msgRegister5=(ImageView) findViewById(R.id.msgRegister5);
        ImageView phoneCall6=(ImageView) findViewById(R.id.phoneCall6);
        ImageView msgRegister6=(ImageView) findViewById(R.id.msgRegister6);
        phoneCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);

            }
        });
        msgRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });
        phoneCall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);

            }
        });
        msgRegister3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });
        phoneCall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);

            }
        });
        msgRegister4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });
        phoneCall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);

            }
        });
        msgRegister5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });
        phoneCall6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);

            }
        });
        msgRegister6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                intent.putExtra("sms_body","");
                startActivity(intent);

            }
        });


        phoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                startActivity(intent);
            }
        });

        msgRegister.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View view) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
                    intent.putExtra("sms_body","");
                    startActivity(intent);

                }
            });
            }




//       final ArrayAdapter<String>myadapter=new ArrayAdapter<>(viewContactt.this, android.R.layout.simple_list_item_1,myArrayList);
//
//        list_itemw=(ListView) findViewById(R.id.list_itemw);
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("femme_our project");
//        list_itemw.setAdapter(myadapter);
//
//
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                Map<String,Contact_store> value= new HashMap<>();
//                contacts_activity value=snapshot.getValue(contacts_activity.class);
////                HashMap value = DataSnapshot.getValue(HashMap.class);
////                myArrayList.add(value);
//                myadapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                myadapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//
//    }

    }
