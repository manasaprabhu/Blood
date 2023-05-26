package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class admin extends AppCompatActivity {
    ArrayList<String> bloodarray;

    ArrayAdapter<String> adapter;

    Spinner sp;
    String stdldgrp;
    DbHpr Hprobj;
    TextView v;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        sp=findViewById(R.id.spinner3);
        v=findViewById(R.id.textView);
        Hprobj=new DbHpr(admin.this);
        bloodarray=new ArrayList<>();
        bloodarray.add("B+");
        bloodarray.add("A+");
        bloodarray.add("O+");
        bloodarray.add("AB+");
        bloodarray.add("B-");
        bloodarray.add("A-");
        bloodarray.add("O-");
        bloodarray.add("AB-");
        adapter= new ArrayAdapter<>(admin.this, android.R.layout.simple_spinner_dropdown_item,bloodarray);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                stdldgrp=bloodarray.get(i);
                Toast.makeText(admin.this, ""+stdldgrp, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void select(View view) {
     String res= Hprobj.getdata(stdldgrp);
     v.setText(res);

    }
}