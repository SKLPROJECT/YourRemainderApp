package com.example.x441uv.yourremainderapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x441uv.yourremainderapp.Data.AdapterAwal;
import com.example.x441uv.yourremainderapp.Data.ListData;
import com.example.x441uv.yourremainderapp.Session.Session1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragament extends Fragment implements View.OnClickListener {
    List<ListData>list;
    RecyclerView rv;
    AdapterAwal adapterAwal;
    Session1 session1;
    DataHelper mydb;
    TextView txt_Nama;
    Button btn_List;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        mydb = new DataHelper(getContext());
        session1 = new Session1(getActivity());
        HashMap<String, String> user = session1.getUserDetails();
        String nama = user.get(session1.KEY_NAMA);
        txt_Nama= view.findViewById(R.id.txt_Nama);
        txt_Nama.setText(nama);
        rv=view.findViewById(R.id.recyclerviewAwal);
        rv.setHasFixedSize(true);
        list=new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterAwal=new AdapterAwal(getContext(),list);
        btn_List=view.findViewById(R.id.btn_list);
        btn_List.setOnClickListener(this);
        getData();
        return view;
    }

    //memanggil data pertama dari tabel

    private void getData(){
        Cursor res = mydb.getOneData();
        if(res.getCount()==0){
            Toast.makeText(getContext(),"Anda belum memasukkan jadwal!",Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()){
            ListData listData= new ListData(res.getString(0),res.getString(1),res.getString(2),
                    res.getString(3));
            list.add(listData);
        }
        rv.setAdapter(adapterAwal);

    }

    @Override
    public void onClick(View v) {
        if(v == btn_List){
            Intent intent = new Intent(getContext(), ListJadwalActivity.class);
            startActivity(intent
            );
        }
    }
}
