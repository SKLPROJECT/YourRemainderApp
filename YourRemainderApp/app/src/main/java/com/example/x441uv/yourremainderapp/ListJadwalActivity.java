package com.example.x441uv.yourremainderapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.x441uv.yourremainderapp.Data.AdapterAwal;
import com.example.x441uv.yourremainderapp.Data.AdapterJadwal;
import com.example.x441uv.yourremainderapp.Data.ListData;
import com.example.x441uv.yourremainderapp.Session.Session1;

import java.util.ArrayList;
import java.util.List;

public class ListJadwalActivity extends AppCompatActivity {
    List<ListData> list;
    RecyclerView rv;
    AdapterJadwal adapterJadwal;
    DataHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jadwal);
        mydb=new DataHelper(getApplicationContext());
        rv=findViewById(R.id.recyclerviewJadwal);
        rv.setHasFixedSize(true);
        list=new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapterJadwal=new AdapterJadwal(getApplicationContext(),list);
        getData();

    }

    private void getData(){
        Cursor res = mydb.getAllData();
        if(res.getCount()==0){
            Toast.makeText(getApplicationContext(),"Anda belum memasukkan jadwal!",Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()){
            ListData listData= new ListData(res.getString(0),res.getString(1),res.getString(2),
                    res.getString(3));
            list.add(listData);
        }
        rv.setAdapter(adapterJadwal);
    }
}
