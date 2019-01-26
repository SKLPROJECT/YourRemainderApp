package com.example.x441uv.yourremainderapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputJadwalFragament extends Fragment implements View.OnClickListener{

    EditText et_Hari,et_Jam,et_Kegiatan;
    Button simpanJadwal;
    DataHelper mydb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inputjadwal, container, false);
        mydb = new DataHelper(getContext());
        et_Hari=view.findViewById(R.id.et_Hari);
        et_Jam=view.findViewById(R.id.et_Jam);
        et_Kegiatan=view.findViewById(R.id.et_Kegiatan);
        simpanJadwal=view.findViewById(R.id.Simpanjadwal);
        simpanJadwal.setOnClickListener(this);
        return view;
    }

    private void kirim(){
        String Hari = et_Hari.getText().toString().trim();
        if (TextUtils.isEmpty(Hari)){
            Toast.makeText(getContext(),"Hari Harap Diisi !!!", Toast.LENGTH_SHORT).show();
            return;

        }

            String Jam = et_Jam.getText().toString().trim();
            if (TextUtils.isEmpty(Hari)){
                Toast.makeText(getContext(),"Jam Harap Diisi !!!", Toast.LENGTH_SHORT).show();
                return;

            }
                String Kegiatan = et_Kegiatan.getText().toString().trim();
                if (TextUtils.isEmpty(Hari)){
                    Toast.makeText(getContext(),"Kegiatan Harap Diisi !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

        boolean isInserted = mydb.inserData(Hari,Jam,Kegiatan);
                if (isInserted = true) {
                    Toast.makeText(getContext(), "JADWAL BERHASIL DISIMPAN", Toast.LENGTH_SHORT).show();
                    et_Hari.setText("");
                    et_Jam.setText("");
                    et_Kegiatan.setText("");
                }
                else
                    Toast.makeText(getContext(), "DATA GAGAL DISIMPAN", Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onClick(View v) {
        if(v == simpanJadwal){
            kirim();
        }

    }
}
