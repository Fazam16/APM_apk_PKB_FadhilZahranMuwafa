package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    private Button buttonAvanza, buttonHRV, buttonPajero, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Login.class));
        }

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);

        dataMobilAvanza();
        dataMobilHRV();
        dataMobilPajero();
    }

    public void dataMobilPajero() {
        buttonPajero = findViewById(R.id.buttonPajero);
        buttonPajero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahSpesifikasiMobil = new Intent(Dashboard.this,Spesifikasi_Mobil.class);
                String[] merkMobil = {"Pajero Sport", "Mitsubishi", "Rp. 500k/day", "220km/jam", "Matic", "4 Sil", "Solar", "8 Kursi", "2020"};
                int gambar = R.drawable.pajero;
                pindahSpesifikasiMobil.putExtra("merk", merkMobil[0]);
                pindahSpesifikasiMobil.putExtra("jenis", merkMobil[1]);
                pindahSpesifikasiMobil.putExtra("harga", merkMobil[2]);
                pindahSpesifikasiMobil.putExtra("gambarMobil", gambar);
                pindahSpesifikasiMobil.putExtra("speedometer", merkMobil[3]);
                pindahSpesifikasiMobil.putExtra("transmisi", merkMobil[4]);
                pindahSpesifikasiMobil.putExtra("silinder", merkMobil[5]);
                pindahSpesifikasiMobil.putExtra("bahanBakar", merkMobil[6]);
                pindahSpesifikasiMobil.putExtra("kursi" ,merkMobil[7]);
                pindahSpesifikasiMobil.putExtra("tanggal" ,merkMobil[8]);
                startActivity(pindahSpesifikasiMobil);
            }
        });
    }

    public void dataMobilHRV() {
        buttonHRV = findViewById(R.id.buttonHRV);
        buttonHRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahSpesifikasiMobil = new Intent(Dashboard.this,Spesifikasi_Mobil.class);
                String[] merkMobil = {"HRV", "Honda", "Rp. 450k/day", "220km/jam", "Matic", "2 Sil", "Bensin", "5 Orang", "2022"};
                int gambar = R.drawable.hrv;
                pindahSpesifikasiMobil.putExtra("merk", merkMobil[0]);
                pindahSpesifikasiMobil.putExtra("jenis", merkMobil[1]);
                pindahSpesifikasiMobil.putExtra("harga", merkMobil[2]);
                pindahSpesifikasiMobil.putExtra("gambarMobil", gambar);
                pindahSpesifikasiMobil.putExtra("speedometer", merkMobil[3]);
                pindahSpesifikasiMobil.putExtra("transmisi", merkMobil[4]);
                pindahSpesifikasiMobil.putExtra("silinder", merkMobil[5]);
                pindahSpesifikasiMobil.putExtra("bahanBakar", merkMobil[6]);
                pindahSpesifikasiMobil.putExtra("kursi" ,merkMobil[7]);
                pindahSpesifikasiMobil.putExtra("tanggal" ,merkMobil[8]);
                startActivity(pindahSpesifikasiMobil);
            }
        });
    }

    public void dataMobilAvanza() {
        buttonAvanza = findViewById(R.id.buttonAvanza);
        buttonAvanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahSpesifikasiMobil = new Intent(Dashboard.this, Spesifikasi_Mobil.class);
                String merkMobil[] = {"Avanza", "Toyota", "Rp. 350k/day", "180km/jam", "Manual", "2 Sil", "Bensin", "8 Orang", "2017"};
                int gambar = R.drawable.avanza;
                pindahSpesifikasiMobil.putExtra("merk", merkMobil[0]);
                pindahSpesifikasiMobil.putExtra("jenis", merkMobil[1]);
                pindahSpesifikasiMobil.putExtra("harga", merkMobil[2]);
                pindahSpesifikasiMobil.putExtra("gambarMobil", gambar);
                pindahSpesifikasiMobil.putExtra("speedometer", merkMobil[3]);
                pindahSpesifikasiMobil.putExtra("transmisi", merkMobil[4]);
                pindahSpesifikasiMobil.putExtra("silinder", merkMobil[5]);
                pindahSpesifikasiMobil.putExtra("bahanBakar", merkMobil[6]);
                pindahSpesifikasiMobil.putExtra("kursi" ,merkMobil[7]);
                pindahSpesifikasiMobil.putExtra("tanggal" ,merkMobil[8]);
                startActivity(pindahSpesifikasiMobil);
            }
        });
    }

    public void pindaMainActivity(View view) {
        Intent intent = new Intent(Dashboard.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == logout) {
            SharedPrefManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this, Login.class));
        }
    }
}