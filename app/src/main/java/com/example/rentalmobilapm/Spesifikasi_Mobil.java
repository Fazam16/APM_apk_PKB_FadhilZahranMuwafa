package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Spesifikasi_Mobil extends AppCompatActivity {

    private TextView merkMobil, jenisMobil, hargaMobil;
    private TextView ketSpeed, ketTransmisi, ketEngine, ketBahanBakar, ketMuatanKursi, ketTanggalPembuatan;
    private ImageView gambarMobil;
    private ImageView bintang1, bintang2, bintang3, bintang4, bintang5;
    private ImageView blank2, blank3, blank4, blank5, blank7, blank8, blank9, blank10, blank12, blank13, blank14, blank15;
    private Button pindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_spesifikasi_mobil);

        String merk, jenis, harga;
        String ketSpeedometer, ketTransmisiS, ketEngineS, ketBBakar, ketKursi, ketTanggal;
        int gambar;

        merkMobil = findViewById(R.id.merkMobil);
        jenisMobil = findViewById(R.id.jenisMobil);
        gambarMobil= findViewById(R.id.gambarMobil);
        hargaMobil = findViewById(R.id.hargaMobil);
        ketSpeed = findViewById(R.id.ketSpeedometer);
        ketTransmisi = findViewById(R.id.ketTransmisi);
        ketEngine = findViewById(R.id.ketEngine);
        ketBahanBakar = findViewById(R.id.ketGasStation);
        ketMuatanKursi = findViewById(R.id.ketKursi);
        ketTanggalPembuatan = findViewById(R.id.ketTahun);
        pindah = findViewById(R.id.buttonLanjut);


        Bundle bundle = getIntent().getExtras();
        merk = bundle.getString("merk");
        jenis = bundle.getString("jenis");
        gambar = bundle.getInt("gambarMobil");
        harga = bundle.getString("harga");
        ketSpeedometer = bundle.getString("speedometer");
        ketTransmisiS = bundle.getString("transmisi");
        ketEngineS = bundle.getString("silinder");
        ketBBakar = bundle.getString("bahanBakar");
        ketKursi = bundle.getString("kursi");
        ketTanggal = bundle.getString("tanggal");

        merkMobil.setText(merk);
        jenisMobil.setText(jenis);
        gambarMobil.setImageResource(gambar);
        hargaMobil.setText(harga);
        ketSpeed.setText(ketSpeedometer);
        ketTransmisi.setText(ketTransmisiS);
        ketEngine.setText(ketEngineS);
        ketBahanBakar.setText(ketBBakar);
        ketMuatanKursi.setText(ketKursi);
        ketTanggalPembuatan.setText(ketTanggal);

        bintang(merk);
        rating(merk);

        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahLokasi = new Intent(Spesifikasi_Mobil.this, Form.class);
                pindahLokasi.putExtra("harga", harga);
                pindahLokasi.putExtra("merk", merk);
                startActivity(pindahLokasi);
            }
        });
    }

    public void rating(String merkMobil) {
        int rating = R.drawable.kotak_rating_warna, rating_kanan = R.drawable.kotak_rating_warna_kanan;
        if (merkMobil.equals("Avanza")) {
            blank2 = findViewById(R.id.blank2); blank3 = findViewById(R.id.blank3); blank4 = findViewById(R.id.blank4);
            blank2.setImageResource(rating); blank3.setImageResource(rating); blank4.setImageResource(rating);

            blank7 = findViewById(R.id.blank7); blank8 = findViewById(R.id.blank8);
            blank7.setImageResource(rating); blank8.setImageResource(rating);

            blank12 = findViewById(R.id.blank12);
            blank12.setImageResource(rating);
        } else if(merkMobil.equals("HRV")) {
            blank2 = findViewById(R.id.blank2);blank3 = findViewById(R.id.blank3);blank4 = findViewById(R.id.blank4);blank5 = findViewById(R.id.blank5);
            blank2.setImageResource(rating); blank3.setImageResource(rating); blank4.setImageResource(rating); blank5.setImageResource(rating_kanan);

            blank7 = findViewById(R.id.blank7);
            blank7.setImageResource(rating);

            blank12 = findViewById(R.id.blank12);blank13 = findViewById(R.id.blank13); blank14 = findViewById(R.id.blank14);
            blank12.setImageResource(rating);  blank13.setImageResource(rating); blank14.setImageResource(rating);
        } else if(merkMobil.equals("Pajero Sport")) {
            blank2 = findViewById(R.id.blank2);blank3 = findViewById(R.id.blank3);
            blank2.setImageResource(rating); blank3.setImageResource(rating);

            blank7 = findViewById(R.id.blank7); blank8 = findViewById(R.id.blank8); blank9 = findViewById(R.id.blank9); blank10 = findViewById(R.id.blank10);
            blank7.setImageResource(rating); blank8.setImageResource(rating); blank9.setImageResource(rating); blank10.setImageResource(rating_kanan);

            blank12 = findViewById(R.id.blank12);blank13 = findViewById(R.id.blank13); blank14 = findViewById(R.id.blank14);
            blank12.setImageResource(rating);  blank13.setImageResource(rating); blank14.setImageResource(rating);
        }

    }

    public void bintang(String merkMobil) {
        bintang1 = findViewById(R.id.bintang_1); bintang2 = findViewById(R.id.bintang_2); bintang3 = findViewById(R.id.bintang_3); bintang4 = findViewById(R.id.bintang_4); bintang5 = findViewById(R.id.bintang_5);
        int bintang = R.drawable.emojione_star;

        if (merkMobil.equals("Avanza")) {
            bintang1.setImageResource(bintang); bintang2.setImageResource(bintang); bintang3.setImageResource(bintang); bintang4.setVisibility(View.VISIBLE); bintang5.setVisibility(View.VISIBLE);
        } else if(merkMobil.equals("HRV")) {
            bintang1.setImageResource(bintang); bintang2.setImageResource(bintang); bintang3.setImageResource(bintang); bintang4.setImageResource(bintang); bintang5.setVisibility(View.VISIBLE);
        } else if(merkMobil.equals("Pajero Sport")) {
            bintang1.setImageResource(bintang); bintang2.setImageResource(bintang); bintang3.setImageResource(bintang); bintang4.setImageResource(bintang); bintang5.setImageResource(bintang);
        }
    }

    public void pindahDashboard(View view) {
        Intent pindah = new Intent(Spesifikasi_Mobil.this, Dashboard.class);
        startActivity(pindah);
    }
}