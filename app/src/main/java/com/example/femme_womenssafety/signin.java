package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class signin extends AppCompatActivity implements View.OnClickListener {

    public Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");
      public ProgressBar determinateBar1;
    public EditText emailSignUp,passwordSignUP;
    public TextView createAccount,forgotPassword;
    public Button signUpButton;
    private CheckBox checkbox;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);
        emailSignUp=(EditText) findViewById(R.id.emailSignUp);
        passwordSignUP=(EditText) findViewById(R.id.passwordSignUP);
        createAccount=(TextView) findViewById(R.id.createAccount);
        forgotPassword=(TextView) findViewById(R.id.Forgot);
        signUpButton=(Button) findViewById(R.id.signUpButton);
        determinateBar1=(ProgressBar)findViewById(R.id.determinateBar1);


        signUpButton.setOnClickListener((View.OnClickListener) this);
        createAccount.setOnClickListener((View.OnClickListener) this);
        forgotPassword.setOnClickListener((View.OnClickListener) this);
        mAuth = FirebaseAuth.getInstance();
        checkbox=(CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    passwordSignUP.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else{
                    passwordSignUP.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case(R.id.createAccount):
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


                break;

            case(R.id.Forgot):
                Intent intent2=new Intent(getApplicationContext(),forgottenPassword.class);

                startActivity(intent2);

                break;

            case(R.id.signUpButton):

                UserSignIn();

                break;
                default:
                break;

        }
    }

    private void UserSignIn() {
        String email= emailSignUp.getText().toString().trim();
        String password= passwordSignUP.getText().toString().trim();

        if(email.isEmpty()){
            emailSignUp.setError("Enter a valid email address");
            emailSignUp.requestFocus();
            return;
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailSignUp.setError("Enter a valid email address");
            emailSignUp.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordSignUP.setError("Enter a valid password");
            passwordSignUP.requestFocus();
            return;
        }
        if(!PASSWORD_PATTERN.matcher(password).matches()){
            passwordSignUP.setError("Enter a valid password");
            passwordSignUP.requestFocus();
            return;

        }
        determinateBar1.setVisibility(View.VISIBLE);
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                determinateBar1.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    if (firebaseAuth.getCurrentUser().isEmailVerified()&&firebaseAuth.getCurrentUser()!=null) {
                        Intent intent=new Intent(getApplicationContext(),sendOTP.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);


                    }
                    else{
                        Toast.makeText(signin.this, "Please verify email", Toast.LENGTH_SHORT).show();
                    }




                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(signin.this, "Try again", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}