package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Form extends AppCompatActivity implements View.OnClickListener {

    private EditText nama, nik, alamat, no_wa, lama_sewa, tanggal, uang_pembayaran;
    private Button sewa, cancel;
    private ImageView kembali;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_form);

        nama = findViewById(R.id.namaPenyewa);
        nik = findViewById(R.id.NIK);
        alamat = findViewById(R.id.alamat);
        no_wa = findViewById(R.id.noWa);
        lama_sewa = findViewById(R.id.lamaSewa);
        tanggal = findViewById(R.id.tanggalSewa);
        uang_pembayaran = findViewById(R.id.uangPembayaran);
        TextView merk_mobil = findViewById(R.id.merkMobil);
        TextView harga_sewa = findViewById((R.id.hargaSewa));

        sewa = findViewById(R.id.sewa);
        kembali = findViewById(R.id.back);
        cancel = findViewById(R.id.cancel);

        merk_mobil.setText(getIntent().getExtras().getString("merk"));
        harga_sewa.setText(getIntent().getExtras().getString("harga"));

        progressDialog = new ProgressDialog(this);
        sewa.setOnClickListener(this);
        kembali.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == sewa) {
            final String namaStr = nama.getText().toString().trim(),
                    nikStr = nik.getText().toString().trim(),
                    alamatStr = alamat.getText().toString().trim(),
                    no_waStr = no_wa.getText().toString().trim(),
                    merk_mobilStr = getIntent().getExtras().getString("merk"),
                    harga_sewaStr = getIntent().getExtras().getString("harga"),
                    lama_sewaStr = lama_sewa.getText().toString().trim(),
                    tanggalStr = tanggal.getText().toString().trim(),
                    uang_pembayaranStr = uang_pembayaran.getText().toString().trim();

            if(namaStr.length()==0 && nikStr.length()==0 && alamatStr.length()==0 && no_waStr.length()==0 && lama_sewaStr.length()==0 && tanggalStr.length()==0 && uang_pembayaranStr.length()==0) {
                Toast.makeText(getApplicationContext(), "Tidak boleh ada data yang kosong", Toast.LENGTH_LONG).show();
            } else {
                progressDialog.setMessage("Memproses data...");
                progressDialog.show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        Constant.URL_REGISTER,
                        response -> {
                            progressDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(getApplicationContext(), jsonObject.getString("pesan"), Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        },
                        error -> {
                            progressDialog.hide();
                            Toast.makeText(getApplication(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("nama", namaStr);
                        params.put("nik", nikStr);
                        params.put("alamat", alamatStr);
                        params.put("no_wa", no_waStr);
                        params.put("merk_mobil", merk_mobilStr);
                        params.put("harga_sewa", harga_sewaStr);
                        params.put("lama_sewa", lama_sewaStr);
                        params.put("tanggal", tanggalStr);
                        params.put("uang_pembayaran", uang_pembayaranStr);
                        return params;
                    }
                };
                RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
                Intent pindahInvoice = new Intent(this, Invoice.class);
                pindahInvoice.putExtra("nama", namaStr);
                pindahInvoice.putExtra("nik", nikStr);
                pindahInvoice.putExtra("alamat", alamatStr);
                pindahInvoice.putExtra("no_wa", no_waStr);
                pindahInvoice.putExtra("harga_sewa", harga_sewaStr);
                pindahInvoice.putExtra("merk_mobil", merk_mobilStr);
                pindahInvoice.putExtra("lama_sewa", lama_sewaStr);
                pindahInvoice.putExtra("tanggal", tanggalStr);
                pindahInvoice.putExtra("uang_pembayaran", uang_pembayaranStr);
                pindahInvoice.putExtra("gambarMobil", getIntent().getExtras().getInt("gambarMobil"));

                startActivity(pindahInvoice);
            }
        }
        else if(view == kembali)
            startActivity(new Intent(this, Spesifikasi_Mobil.class));
        else if(view == cancel)
            startActivity(new Intent(this, Form.class));
    }

}