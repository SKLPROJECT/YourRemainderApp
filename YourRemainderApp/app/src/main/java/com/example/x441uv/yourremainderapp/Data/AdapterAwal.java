package com.example.x441uv.yourremainderapp.Data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x441uv.yourremainderapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterAwal extends RecyclerView.Adapter<AdapterAwal.ViewHolder>{
    List<ListData>list;
    Context context;
    LayoutInflater inflater;

    public  AdapterAwal(Context context, List<ListData>list){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.list_jadwal_pertama,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListData listData=list.get(i);
        viewHolder.txtId.setText(listData.getIdjadwal());
        viewHolder.txt_Hari.setText(listData.getHari());
        viewHolder.txt_Kegiatan.setText(listData.getKegiatan());
        viewHolder.txt_Jam.setText(listData.getJam());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtId,txt_Hari,txt_Jam,txt_Kegiatan;
        public ViewHolder (View view){
            super(view);
            txtId=view.findViewById(R.id.txtId);
            txt_Hari=view.findViewById(R.id.txt_Hari);
            txt_Jam=view.findViewById(R.id.txt_Jam);
            txt_Kegiatan=view.findViewById(R.id.txt_Kegiatan);
        }
    }
}
