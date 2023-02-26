package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class login_part2 extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.activity_login_part2);
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

                        Intent intent=new Intent(getApplicationContext(),loading.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//remove all the other activities

                    //   intent.addFlags Flags exist to create a new activity, use an existing activity, .
                        startActivity(intent);








                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(login_part2.this, "Try again", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

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






    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Femme-Women Safety", Toast.LENGTH_SHORT).show();
    }

}
