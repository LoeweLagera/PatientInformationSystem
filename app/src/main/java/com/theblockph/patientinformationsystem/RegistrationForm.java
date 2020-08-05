package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.Objects;

public class RegistrationForm extends AppCompatActivity {

    EditText setFirstName, setLastName, setEmail, setPassword, setConfirmPassword;
    Button RegisterBtn;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        setFirstName = findViewById(R.id.editTxtFirstName);
        setLastName = findViewById(R.id.editTxtLastName);
        setEmail = findViewById(R.id.editTxtEmail);
        setPassword = findViewById(R.id.editTxtPassword);
        setConfirmPassword = findViewById(R.id.editTxtConfirmPassword);

        RegisterBtn = findViewById(R.id.btnRegister);

        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = setFirstName.getText().toString().trim();
                String lastName = setLastName.getText().toString().trim();
                String email = setEmail.getText().toString().trim();
                String password = setPassword.getText().toString().trim();
                String confirmPassword = setConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirmPassword)){
                    setFirstName.setError("First Name Required");
                    setLastName.setError("Last Name Required");
                    setEmail.setError("Email Required");
                    setPassword.setError("Password Required");
                    setConfirmPassword.setError("Confirm Password Required");
                }
                if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)){
                    setFirstName.setError("First Name Required");
                    setLastName.setError("Last Name Required");
                    setEmail.setError("Email Required");
                    setPassword.setError("Password Required");
                    setConfirmPassword.setError("Confirm Password Required");
                }
                if (password.length()<6){
                    setPassword.setError("Password Too Short");

                    //Toast.makeText(RegistrationForm.this, "Password Too Short",Toast.LENGTH_SHORT).show(); !THIS ONE IS A CODE
                }
                if(!password.equals(confirmPassword)){
                    setPassword.setError("Password Don't Match");
                    setConfirmPassword.setError("Password Don't Match");
                }

                //Firebase Authentication
                //CreateUserWithEmailAndPassword used to send the Details in Firebase Cloud "ONLY IN THE AUTHENTICATION TAB"
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(RegistrationForm.this, "User Created",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegistrationForm.this, "Error" + Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}