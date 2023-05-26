package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class signup extends AppCompatActivity {
    ArrayList<String> ar;
    Spinner sp;
    ArrayAdapter<String> adapter;

    EditText eddob,edname,edmob,edloc;

    String stdob,stbloodgr,stname,stmob,stloc;
    DbHpr dbHprobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sp=findViewById(R.id.spinner);
        eddob=findViewById(R.id.editTextTextPersonName5);
        edname=findViewById(R.id.editTextTextPersonName);
        edmob=findViewById(R.id.editTextTextPersonName2);
        edloc=findViewById(R.id.editTextTextPersonName3);

        ar= new ArrayList<String>();
        dbHprobj= new DbHpr(this) ;
        eddob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog db=new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        eddob.setText(i+"/"+(1+i1)+"/"+i2);
                    }
                }, 2023, 0, 1);
                db.show();
            }
        });
        ar.add("B+");
        ar.add("A+");
        ar.add("O+");
        ar.add("AB+");
        ar.add("B-");
        ar.add("A-");
        ar.add("O-");
        ar.add("AB-");
        adapter= new ArrayAdapter<>(signup.this, android.R.layout.simple_spinner_dropdown_item,ar);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                stbloodgr=ar.get(i);
                Toast.makeText(signup.this, ""+stbloodgr, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }

    public void signup(View view) {
        stname=edname.getText().toString();
        stloc=edloc.getText().toString();
        stmob=edmob.getText().toString();
        stdob=eddob.getText().toString();
        Toast.makeText(this,stname+"-"
                +stmob+"-"
                +stloc+"-"
                +stdob
                , Toast.LENGTH_SHORT).show();

        dbHprobj.savedata(stname,stmob,stloc,stdob,stbloodgr);

    }
}