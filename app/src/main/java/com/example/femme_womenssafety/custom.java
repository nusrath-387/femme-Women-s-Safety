package com.example.femme_womenssafety;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;


public class custom extends ArrayAdapter<Contact_store> {
    private Activity context;
    private List<Contact_store>contactList;
    DatabaseReference databaseReference;





    public custom(Activity context , @NonNull List<Contact_store> contactList ) {
        //Activity context it's the context of current state of the application/object
        super(context, R.layout.sample_layout,contactList);
        this.contactList = contactList;
        this.context=context;




    }

    @NonNull
    @Override
    //getView() method in Adapter is for generating item's view of a ListView ,
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        // instantiate the contents of layout XML files into their corresponding View objects
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        Contact_store contact_store=contactList.get(position);
        TextView t11=view.findViewById(R.id.nameAdd);
        TextView t22=view.findViewById(R.id.numberAdd);
        ImageView msgRegister2=view.findViewById(R.id.msgRegister2);
        ImageView call2=view.findViewById(R.id.call2);
        t11.setText("Name : "+contact_store.getName());
        t22.setText(contact_store.getPhone_number());
        databaseReference = FirebaseDatabase.getInstance().getReference("femme_our project");
call2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:01721902799"));//for avoiding error have to give 'tel'
                context.startActivity(intent);
    }
});

//      msgRegister2.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
////              databaseReference.child(databaseReference.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
////                  @Override
////                  public void onComplete(@NonNull Task<Void> task) {
////
////
////                  }
////              });
//              Intent intent=new Intent(Intent.ACTION_DIAL);
////
////                intent.setData(Uri.parse("tel:String.valueOf(t22)"));//for avoiding error have to give 'tel'
////                context.startActivity(intent);
////
////          }

msgRegister2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//       FirebaseDatabase.getInstance().getReference("femme_our project").child(getView(position).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//
//            }
//        });
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","01721902799","null"));
        intent.putExtra("sms_body","");
        context.startActivity(intent);

    }});



        return view;
    }}