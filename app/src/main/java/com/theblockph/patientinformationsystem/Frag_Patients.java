package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Frag_Patients extends AppCompatActivity {
    EditText getFirstName, getMiddleName, getLastName, searchPatient;
    Button btnSearchPatient;

    DatabaseReference dbReff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag__patients);



        getFirstName = findViewById(R.id.etFirstNamePI);
        getMiddleName = findViewById(R.id.etMiddleNamePI);
        getLastName = findViewById(R.id.etLastNamePI);
        searchPatient = findViewById(R.id.etSearchPatientsPI);
        btnSearchPatient = findViewById(R.id.btnSearchPI);

        //Initialize and Assign Value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.patients);

        //=================================BOTTOM NAVIGATION BAR===================================
        //perform SelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                ,Frag_Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.patients:
                        return true;
                    case R.id.add_patients:
                        startActivity(new Intent(getApplicationContext()
                                ,Frag_AddPatients.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.lab_results:
                        startActivity(new Intent(getApplicationContext()
                                ,Frag_LaboratoryResults.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.prescriptions:
                        startActivity(new Intent(getApplicationContext()
                                ,Frag_Prescriptions.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //=================================END OF BOTTOM NAVIGATION BAR============================

        btnSearchPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbReff = FirebaseDatabase.getInstance().getReference().child("Patients").child("1");
                dbReff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String firstName = snapshot.child("fname").getValue().toString();
                        String middleName = snapshot.child("mname").getValue().toString();
                        String lastName = snapshot.child("lname").getValue().toString();

                        getFirstName.setText(firstName);
                        getMiddleName.setText(middleName);
                        getLastName.setText(lastName);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // -----Add Patient-----

        getMenuInflater().inflate(R.menu.patient_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_add) {

            startActivity(new Intent(Frag_Patients.this, Frag_AddPatients.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

