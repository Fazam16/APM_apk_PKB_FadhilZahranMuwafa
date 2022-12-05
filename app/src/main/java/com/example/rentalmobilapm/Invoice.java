package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Invoice extends AppCompatActivity {

    TextView namaPenyewa, nik, alamat, no_wa, merk_mobil, harga_sewa, lama_sewa, tanggal_sewa, uang_pembayaran;
    ImageView gambarMobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_invoice);

        namaPenyewa = findViewById(R.id.namaPenyewa);
        nik = findViewById(R.id.NIK);
        alamat = findViewById(R.id.alamat);
        no_wa = findViewById(R.id.noWa);
        merk_mobil = findViewById(R.id.merkMobil);
        harga_sewa = findViewById(R.id.hargaSewa);
        lama_sewa = findViewById(R.id.lamaSewa);
        tanggal_sewa = findViewById(R.id.tanggalSewa);
        uang_pembayaran = findViewById(R.id.uangPembayaran);
        gambarMobil = findViewById(R.id.gambar);

        Bundle bundle = new Bundle(getIntent().getExtras());
        namaPenyewa.setText(bundle.getString("nama"));
        nik.setText(bundle.getString("nik"));
        alamat.setText(bundle.getString("alamat"));
        no_wa.setText(bundle.getString("no_wa"));
        merk_mobil.setText(bundle.getString("merk_mobil"));
        harga_sewa.setText(bundle.getString("harga_sewa"));
        lama_sewa.setText(bundle.getString("lama_sewa"));
        tanggal_sewa.setText(bundle.getString("tanggal"));
        uang_pembayaran.setText(bundle.getString("uang_pembayaran"));
        gambarMobil.setImageResource(bundle.getInt("gambarMobil"));
    }

    public void onClick(View view) {
        startActivity(new Intent(Invoice.this, RiwayatPemesanan.class));
    }
}