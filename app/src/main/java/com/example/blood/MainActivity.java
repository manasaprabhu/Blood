package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void signup(View view) {
        Intent i=new Intent (MainActivity.this,signup.class);
        startActivity(i);

    }

    public void admin(View view) {
        Intent i=new Intent (MainActivity.this,admin.class);
        startActivity(i);

    }
}