package com.example.rentalmobilapm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterUserAkun extends AppCompatActivity implements View.OnClickListener {

    TextView nama, password, nik, login;
    CheckBox lihat;
    Button submit;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register_user_akun);

        nama = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        nik = findViewById(R.id.nikEditText);
        submit = findViewById(R.id.buttonSubmit);
        lihat = findViewById(R.id.showPassword);
        login = findViewById(R.id.login);

        progressDialog = new ProgressDialog(this);
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lihat.isChecked())
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                else
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        submit.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == submit) {
            final String namaStr = nama.getText().toString().trim(),
                    passwordStr = password.getText().toString().trim(),
                    nikStr = nik.getText().toString().trim();

            if(namaStr.length() == 0 && passwordStr.length()==0 && nik.length()==0)
                Toast.makeText(getApplicationContext(), "Tidak boleh ada data yang kosong", Toast.LENGTH_LONG).show();
            else {
                progressDialog.setMessage("Sedang melakukan registrasi user...");
                progressDialog.show();
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        Constant.URL_REGISTER_AKUN,
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
                        params.put("password", passwordStr);
                        params.put("nik", nikStr);
                        return params;
                    }
                };
                RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
            }
        } else if(view == login) {
            startActivity(new Intent(this, Login.class));
        }
    }
}