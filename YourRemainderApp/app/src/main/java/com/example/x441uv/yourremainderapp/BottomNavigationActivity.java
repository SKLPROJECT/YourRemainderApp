package com.example.x441uv.yourremainderapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.x441uv.yourremainderapp.Session.Session1;

import java.util.HashMap;


public class BottomNavigationActivity extends AppCompatActivity {

    Session1 session1;
    String nama;
    TextView txt_Nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        session1 = new Session1(this);
        HashMap<String, String> user = session1.getUserDetails();
        nama = user.get(session1.KEY_NAMA);
        txt_Nama=findViewById(R.id.txt_Nama);
        txt_Nama.setText(nama);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            Fragment selectedFragment = null;

            switch (Item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragament();
                    break;

                case R.id.nav_input:
                    selectedFragment = new InputJadwalFragament();
                    break;

                case R.id.nav_kalender:
                    selectedFragment = new KalenderFragament();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;

        }
    };
}
