package com.theblockph.patientinformationsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Frag_AddPatients extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //Insert Data to Firebase - find: Connect1
    EditText reg_patientfname, reg_patientmname, reg_patientlname;
    Spinner reg_gender, reg_marital;
    EditText reg_address, reg_religion, reg_occupation;
    EditText reg_age, reg_contact1, reg_contact2, reg_email;

    //Patient_ID
    long maxid=0;

    Button btn_register;
    Table_Patient table_patient;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag__add_patients);

        //=============================INSERT DATA TO DATABASE==================================

        //Insert Data to Firebase - name: Connect1

        //                      -----name_of_Activity------
        setContentView(R.layout.activity_frag__add_patients);

        //======================DATA TO BE INSERTED TO FIREBASE============================
            //                       -----Name_of_TextViews-----
        reg_patientfname=(EditText) findViewById(R.id.reg_patientfname);
        reg_patientmname=(EditText) findViewById(R.id.reg_patientmname);
        reg_patientlname=(EditText) findViewById(R.id.reg_patientlname);

        //                    -----Spinners-----
        reg_gender=(Spinner) findViewById(R.id.reg_gender);
        reg_marital=(Spinner) findViewById(R.id.reg_marital);


        reg_address=(EditText) findViewById(R.id.reg_address);
        reg_religion=(EditText) findViewById(R.id.reg_religion);

            //        ---AGE---Occupation---CELLPHONE---TELEPHONE---
        reg_age=(EditText) findViewById(R.id.reg_age);
        reg_occupation=(EditText) findViewById(R.id.reg_occupation);
        reg_contact1=(EditText) findViewById(R.id.reg_contact1);
        reg_contact2=(EditText) findViewById(R.id.reg_contact2);
        reg_email=(EditText) findViewById(R.id.reg_email);

        //                -----Button_to_insert_data_to_Firebase-----
        btn_register=(Button) findViewById(R.id.btn_register);

        //    Declared above      -----Patient.java-----
        table_patient=new Table_Patient();

        //                      -----Firebase_Reference-----
        reff= FirebaseDatabase.getInstance().getReference().child("Patients");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(int)dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //OnClickListener
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int age=Integer.parseInt(reg_age.getText().toString().trim());
                Long cellphone=Long.parseLong(reg_contact1.getText().toString().trim());
                Long telephone=Long.parseLong(reg_contact2.getText().toString().trim());
                // For integers and LONG convert to string first ^^^ CHECK METHOD HERE ^^^

                table_patient.setFname(reg_patientfname.getText().toString().trim());
                table_patient.setMname(reg_patientmname.getText().toString().trim());
                table_patient.setLname(reg_patientlname.getText().toString().trim());
                table_patient.setGender(reg_gender.getSelectedItem().toString().trim());
                table_patient.setMarital(reg_marital.getSelectedItem().toString().trim());

                table_patient.setAddress(reg_address.getText().toString().trim());
                table_patient.setReligion(reg_religion.getText().toString().trim());

                table_patient.setAge(age);
                table_patient.setCellphone(cellphone);
                table_patient.setTelephone(telephone);

                table_patient.setOccupation(reg_occupation.getText().toString().trim());
                table_patient.setEmail(reg_email.getText().toString().trim());

                reff.child(String.valueOf(maxid++)).setValue(table_patient);


                //redirect to Patients Tab
                startActivity(new Intent(getApplicationContext()
                        , Frag_Patients.class));
                overridePendingTransition(0, 0);

                Toast.makeText(Frag_AddPatients.this, "Patient Registered!", Toast.LENGTH_LONG).show();
            }
        });

        //   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^END OF INSERT DATA^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

        //Spinner for Marital Status
        Spinner spinner = findViewById(R.id.reg_marital);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Spinner for Gender
        Spinner spinner_Gender = findViewById(R.id.reg_gender);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Gender, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Gender.setAdapter(adapter2);
        spinner_Gender.setOnItemSelectedListener(this);

        //Initialize and Assign Value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.add_patients);

        //perform SelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                , Frag_Dashboard.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.patients:
                        startActivity(new Intent(getApplicationContext()
                                , Frag_Patients.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.add_patients:

                        return true;
                    case R.id.lab_results:
                        startActivity(new Intent(getApplicationContext()
                                , Frag_LaboratoryResults.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.prescriptions:
                        startActivity(new Intent(getApplicationContext()
                                , Frag_Prescriptions.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}