package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Login
    EditText getEmail, getPassword;
    Button btnLogin;

    Button btnSignUp;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getEmail = findViewById(R.id.editTextEmailLogin);
        getPassword = findViewById(R.id.editTextPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        fAuth = FirebaseAuth.getInstance();


        // SignUp
        btnSignUp = findViewById(R.id.btnsignup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent  = new Intent(getApplicationContext(),RegistrationForm.class);
                startActivity(signUpIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = getEmail.getText().toString().trim();
                String password = getPassword.getText().toString().trim();

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged In Succesfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeFragment.class));
                        }
                    }
                });

            }
        });


    }


}