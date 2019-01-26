package com.example.x441uv.yourremainderapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.x441uv.yourremainderapp.Session.Session1;

public class DataDiriActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_Nama, et_Alamat, et_Nomor;
    Button simpan;
    Session1 session1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);
        et_Nama=findViewById(R.id.et_Nama);
        et_Alamat=findViewById(R.id.et_Alamat);
        et_Nomor=findViewById(R.id.et_Nomor);
        simpan=findViewById(R.id.simpan);
        simpan.setOnClickListener(this);
        session1 = new Session1(this);
        session1.checkLogin();
    }

    private void simpanData() {
        String nama = et_Nama.getText().toString().trim();
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(getApplicationContext(), "Harap mengisi nama!", Toast.LENGTH_SHORT).show();
            return;
        }

        String alamat = et_Alamat.getText().toString().trim();
        if (TextUtils.isEmpty(alamat)) {
            Toast.makeText(getApplicationContext(), "Harap mengisi Alamat!", Toast.LENGTH_SHORT).show();
            return;

        }

        String nomor = et_Nomor.getText().toString().trim();
        if (TextUtils.isEmpty(nomor)) {
            Toast.makeText(getApplicationContext(), "Harap mengisi Nomor Handphone!", Toast.LENGTH_SHORT).show();
            return;
        }

        session1.createLoginSession(nama,alamat,nomor);
        Intent i =new Intent(getApplicationContext(),BottomNavigationActivity.class);
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP | i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }


            @Override
    public void onClick(View v) {
        simpanData();
    }
}
