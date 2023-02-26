package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*?[A-Z])" +     // At least one upper case English letter,
                    "(?=.*?[0-9])" +      // At least one digit
                    "(?=.*?[a-z])" +     //// At least one lower case English letter,
                    "(?=\\S+$)" +            // no white spaces
                    ".{8,}" +                // at least 8 characters
                    "$");
    public Pattern PHONEE =
            Pattern.compile("^\\+?(88)?0?1[3456789][0-9]{8}");


    public Pattern emailPattern =
            Pattern.compile(
//                    "[0-9 A-Z a-z]([0-9 A-Z a-z-]{0,61}[0-9 A-Z a-z])?");
    "[a-z 0-9]+@[a-z]+.[a-z]");


    private EditText emailID, password, namee;
    public TextView signUpText;
    String userID;
    private CheckBox checkbox;

    public Button signupButton;
    private FirebaseAuth mAuth;
    private ProgressBar determinateBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        this.setTitle("Register");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);


        mAuth = FirebaseAuth.getInstance();

        emailID = (EditText) findViewById(R.id.emailID);
        namee = (EditText) findViewById(R.id.namee);
        password = (EditText) findViewById(R.id.passwordID);


        signupButton = (Button) findViewById(R.id.signupButton);


        signUpText = (TextView) findViewById(R.id.signUpText);
        determinateBar = (ProgressBar) findViewById(R.id.determinateBar);

        signupButton.setOnClickListener((View.OnClickListener) this);

        signUpText.setOnClickListener((View.OnClickListener) this);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    //Hide Password:
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    //Show Password:
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        if (emailID.length() > 8) {
            emailID.setError("Atleast 20 charachters");
            emailID.requestFocus();
            //requestFocus() give it hints about the direction
        }


    }

    @SuppressLint("NonConstantResourceId")//if statement inside switch/cases scenario crashes my app [duplicate]
    //when different button clicks,it crashes sometimes
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signupButton:
                userRegister();

                break;
            case R.id.signUpText:
                Intent intent = new Intent(getApplicationContext(), login_part2.class);

                startActivity(intent);
                break;


            default:
                break;
        }


    }


    private void userRegister() {
        String email = emailID.getText().toString().trim();
        String Password = password.getText().toString().trim();//returns a new string, without modifying the original string
        String Name = namee.getText().toString().trim();


        if (Name.isEmpty()) {
            namee.setError("Enter a name");
            namee.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            emailID.setError("Entry valid email");
            emailID.requestFocus();
            return;
        }
// Utils - A categorized directory of libraries and tools for Android
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Enter a valid  email");
            emailID.requestFocus();
            return;
        }
        determinateBar.setVisibility(View.VISIBLE);

        if (Password.isEmpty()) {
            password.setError("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:\n");
            password.requestFocus();
            return;
        }
        if (!PASSWORD_PATTERN.matcher(Password).matches()) {
            password.setError("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:\n");
            password.requestFocus();
            return;
        }

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        //Returns an instance of this class corresponding to the given FirebaseApp instance

        mAuth.createUserWithEmailAndPassword(email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            //
            ///Task<AuthResult> task Tries to create a new user account with the given email address and password.
            public void onComplete(@NonNull Task<AuthResult> task) {
                determinateBar.setVisibility(View.GONE);
                // Sign in success, update UI with the signed-in user's information

                if (task.isSuccessful()) {
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

                    firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            //Task<Void> task doesnt return
                            determinateBar.setVisibility(View.VISIBLE);
//                             userID=firebaseAuth.getCurrentUser().getUid();
//                             FirebaseUser users=firebaseAuth.getCurrentUser();


                            Toast.makeText(MainActivity.this, "Successfully registered,Check your email for verification", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(MainActivity.this, signin.class);
                            startActivity(intent1);

                        }


                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {


                            Toast.makeText(MainActivity.this, "Fail to send verfication email", Toast.LENGTH_SHORT).show();


                        }
                    });


                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(MainActivity.this, "Already Registered", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }

    //    @Override
//    public void onBackPressed() {
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//    }
//
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




    public void onBackPressed() {
        Intent intent=new Intent(getApplicationContext(),after_homescreen.class);

                startActivity(intent);

        Toast.makeText(this, "Femme-Women Safety", Toast.LENGTH_SHORT).show();
    }




}
