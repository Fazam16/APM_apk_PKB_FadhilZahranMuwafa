package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar (). hide ();
        setContentView(R.layout.activity_main);
    }

    public void pindahDashboard(View view) {
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
    }
}