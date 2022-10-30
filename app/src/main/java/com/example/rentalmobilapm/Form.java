package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Form extends AppCompatActivity {

    TextView merkMobil, hargaMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_form);

        merkMobil = findViewById(R.id.merkMobil);
        hargaMobil = findViewById((R.id.hargaSewa));

        String merk, harga;

        merk = getIntent().getExtras().getString("harga");
        harga = getIntent().getExtras().getString("merk");

        merkMobil.setText(merk);
        hargaMobil.setText(harga);
    }

    public void pindahSpesifikasi(View view) {
        Intent pindah = new Intent(Form.this, Spesifikasi_Mobil.class);
        startActivity(pindah);
    }
}