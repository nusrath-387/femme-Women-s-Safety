package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verifyOTP extends AppCompatActivity {
  private Button verifyButton;
  private EditText num1,num2,num3,num4,num5,num6;
  private TextView resend;
    private ProgressBar progress2;
    private  String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        getSupportActionBar().hide();

        verifyButton=(Button) findViewById(R.id.verifyButton);
        resend=(TextView) findViewById(R.id.resend);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText) findViewById(R.id.num2);
        num3=(EditText) findViewById(R.id.num3);
        num4=(EditText) findViewById(R.id.num4);
        num5=(EditText) findViewById(R.id.num5);
        num6=(EditText) findViewById(R.id.num6);
        progress2=(ProgressBar)findViewById(R.id.progress2) ;


        inputSetup();
        TextView textMobile=(TextView) findViewById(R.id.textMobile);
        TextView resend=(TextView) findViewById(R.id.resend);
        textMobile.setText(String.format("+880-%s",getIntent().getStringExtra("mobilee")));

        verificationID=getIntent().getStringExtra("verificationID");

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(num1.getText().toString().isEmpty()
                        ||num2.getText().toString().isEmpty()
                        ||num3.getText().toString().isEmpty()
                        ||num4.getText().toString().isEmpty()
                        ||num5.getText().toString().isEmpty()
                        ||num6.getText().toString().isEmpty()){
                    Toast.makeText(verifyOTP.this, "Please enter vaild code", Toast.LENGTH_SHORT).show();
                    return;


                }
                String code=
                                num1.getText().toString()
                                +num2.getText().toString()
                                +num3.getText().toString()
                                +num4.getText().toString()
                                +num5.getText().toString()
                                +num6.getText().toString();
   if(verificationID!=null){
       progress2.setVisibility(View.GONE);
       PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(
               verificationID,
                code);

       FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       progress2.setVisibility(View.GONE);
                       if(task.isSuccessful()){
                           Intent intent=new Intent(getApplicationContext(),account_created.class);
                           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                           startActivity(intent);
                       }
                       else{
                           Toast.makeText(verifyOTP.this, "The verification was entered wrong", Toast.LENGTH_SHORT).show();
                       }

                   }
               });
   }


            }
        });
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+880"+getIntent().getStringExtra("mobilee"),
                        60,
                        TimeUnit.SECONDS,
                        verifyOTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(verifyOTP.this, "Please try again", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String newVerificationID, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                             verificationID= newVerificationID;
                                Toast.makeText(verifyOTP.this, "OTP Sent", Toast.LENGTH_SHORT).show();


                            }
                        });


            }
        });

            }

    private void inputSetup(){
        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    num2.requestFocus();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    num3.requestFocus();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    num4.requestFocus();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    num5.requestFocus();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        num5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    num6.requestFocus();


                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }

}











