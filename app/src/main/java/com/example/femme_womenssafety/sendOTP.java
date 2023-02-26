package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class sendOTP extends AppCompatActivity {
    public Button getOTP;
    public EditText mobile;
    private ProgressBar progress1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);
        getOTP=(Button) findViewById(R.id.getOTP);
        mobile=(EditText) findViewById(R.id.mobile);
        progress1=(ProgressBar)findViewById(R.id.progress1) ;

        getSupportActionBar().hide();
        getOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(sendOTP.this, "Enter mobile number", Toast.LENGTH_SHORT).show();
                    return;

                }
                progress1.setVisibility(View.VISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+880"+mobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        sendOTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progress1.setVisibility(View.GONE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progress1.setVisibility(View.GONE);
                                Toast.makeText(sendOTP.this, "Please try again", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progress1.setVisibility(View.GONE);
                                Intent intent=new Intent(getApplicationContext(),verifyOTP.class);
                                intent.putExtra("mobilee",mobile.getText().toString());
                                intent.putExtra("verificationID",verificationID);
                                startActivity(intent);

                            }
                        });


            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

}