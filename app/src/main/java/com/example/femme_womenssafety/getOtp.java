package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.w3c.dom.Text;

public class getOtp extends AppCompatActivity {
    private EditText otp;
    private Button otpButton;
    private TextView otppText;
    private ProgressBar progress;
    private FirebaseAuth mAuth;
  String backend,verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp2);
        otp=(EditText) findViewById(R.id.otp);
        otpButton=(Button) findViewById(R.id.otpButton);
        otppText=(TextView)findViewById(R.id.otpp);
        progress=(ProgressBar)findViewById(R.id.progress);

//        otppText.setText(String.format(
//              getIntent().getStringExtra("mobile")
//        ));
//
//    backend=getIntent().getStringExtra("backend");
        mAuth = FirebaseAuth.getInstance();

        String OtpText = otp.getText().toString();
        String backend= getIntent().getExtras().getString("backend");
        FirebaseAuth mAuth = getIntent().getExtras().getParcelable("mAuth");



        otpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getOtp.this, "working", Toast.LENGTH_SHORT).show();


                FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
                PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(backend,OtpText);
                mAuth.signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                Intent signUpIntent = new Intent(getOtp.this, ProfileActivity.class);
                                startActivity(signUpIntent);
                                finish();
                            }
                        });
            };
                                     });



//                if(otp.getText().toString().trim().isEmpty()){
//                    Toast.makeText(getOtp.this, "Please enter vaild code", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                String enterCode=otp.getText().toString();
//                if(backend!=null){
//
//                    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
//
//                        PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(enterCode,backend);
//                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//
//                                    Intent intent=new Intent(getApplicationContext(),Home_activity.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                    startActivity(intent);
//                                }
//                                else{
//                                    Toast.makeText(getOtp.this, "failed", Toast.LENGTH_SHORT).show();
//                                }
//
//
//                          }
//                      });
//
//                 }
//                else{
//                  Toast.makeText(getOtp.this, "Otp Verify", Toast.LENGTH_SHORT).show();
//               }}


    }}





