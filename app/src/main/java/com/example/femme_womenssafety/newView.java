package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newView extends AppCompatActivity {
    EditText phoneNum,sendSMS;
    Button sendSMSS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_view);

        phoneNum = (EditText) findViewById(R.id.phoneNum);
        sendSMS = (EditText) findViewById(R.id.sendSMS);
        sendSMSS = (Button) findViewById(R.id.sendSMSS);

        sendSMSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check condition for permission

                //ContextCompat Helper for accessing features in Context(current state).

                if (ContextCompat.checkSelfPermission(newView.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)

                    //Permission is granted create a method
                    sendSMS();

                else {
                    //when permisson is not granted,request for permission
                    //ActivityCompat part of  android support library
                    ActivityCompat.requestPermissions(newView.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }

            }


        });
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        //check condition
//
//        if(requestCode==100 && grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
////permission granted
//            sendSMS();
//            Toast.makeText(this, "granted", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            //permission denied
//            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void sendSMS() {
            //get value from edittext
            String message=phoneNum.getText().toString();
            String phoneNumber=sendSMS.getText().toString();
            if(!phoneNumber.isEmpty()&& !message.isEmpty()){
                //intialize sms manager

                SmsManager smsManager=SmsManager.getDefault();
                //send message
                smsManager.sendTextMessage(phoneNumber,null,message,null,null);
                Toast.makeText(newView.this, "Sms Sent Sucessfully", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(newView.this, "Please enter phone number and message", Toast.LENGTH_SHORT).show();

            }}

    }
