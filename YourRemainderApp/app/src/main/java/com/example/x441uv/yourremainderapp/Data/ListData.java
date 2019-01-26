package com.example.x441uv.yourremainderapp.Data;

public class ListData {
    String idjadwal,hari,jam,kegiatan;

    public ListData(String idjadwal, String hari, String jam, String kegiatan){
        this.idjadwal=idjadwal;
        this.hari=hari;
        this.jam=jam;
        this.kegiatan=kegiatan;
    }

    public String getIdjadwal() {
        return idjadwal;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }

    public String getKegiatan() {
        return kegiatan;
    }
}
