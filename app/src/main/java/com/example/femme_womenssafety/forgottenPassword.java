package com.example.femme_womenssafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgottenPassword extends AppCompatActivity  {
    public EditText forgotEmail;
    public Button forgotButton;
    private ProgressBar determinateBar2;
    private TextView backLogin;

//// Initialize Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.woman);
        mAuth = FirebaseAuth.getInstance();

        forgotEmail = (EditText) findViewById(R.id.forgotEmail);
        determinateBar2=(ProgressBar)findViewById(R.id.determinateBar);
        backLogin=(TextView)findViewById(R.id.backLogin);

        forgotButton = (Button) findViewById(R.id.forgotButton);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(forgottenPassword.this,signin.class);
                startActivity(intent);
            }
        });
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validData();
            }
        });


    }

    private void validData() {
      String email=forgotEmail.getText().toString();
       if(email.isEmpty()){
           forgotEmail.setError("Enter correct email");
       }


       else{
           mAuth.sendPasswordResetEmail(email).addOnCompleteListener((new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {

                   if (task.isSuccessful()) {



                       Toast.makeText(forgottenPassword.this, "Sucessfully ", Toast.LENGTH_SHORT).show();

                       startActivity(new Intent(forgottenPassword.this,signin.class));


                   } else {

                       Toast.makeText(forgottenPassword.this, "Try aagin", Toast.LENGTH_SHORT).show();

                   }

               }
           }));
       };

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






}




