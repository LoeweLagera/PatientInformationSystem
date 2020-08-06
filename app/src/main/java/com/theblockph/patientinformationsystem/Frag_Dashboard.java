package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Frag_Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag__dashboard);

        //Initialize and Assign Value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //perform SelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard:
                        return true;
                    case R.id.patients:
                        startActivity(new Intent(getApplicationContext()
                                ,Frag_Patients.class));
                        overridePendingTransition(0,0);
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
    }
}