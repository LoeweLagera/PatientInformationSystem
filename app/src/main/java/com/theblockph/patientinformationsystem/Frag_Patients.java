package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Frag_Patients extends AppCompatActivity {

    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag__patients);

        //RecyclerView
        RecyclerView patientsRecyclerView = findViewById(R.id.patientsRecyclerView);
        patientsRecyclerView.setHasFixedSize(true);
        patientsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //All data inside the Recycler View
        listItems = new ArrayList<>();

        for (int i = 0; i<=10; i++){
            ListItem listItem = new ListItem(
                    "Charles" + (i+1),
                    "0995"
            );
            listItems.add(listItem);
        }

        //Set Adapter to Recycler View

        adapter = new ViewAdapter(listItems, this);

        patientsRecyclerView.setAdapter(adapter);


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

