package com.example.x441uv.yourremainderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DataHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "skl.db";
    public static int DATABASE_VERSION = 1;
    public static String TABLE_NAME = "jadwal";

    public DataHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table "+TABLE_NAME+"(Idjadwal INTEGER PRIMARY KEY AUTOINCREMENT, Hari VARCHAR, Jam TIME, Kegiatan VARCHAR )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);

    }

    public boolean inserData (String Hari, String Jam, String Kegiatan  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Hari", Hari);
        contentValues.put("Jam", Jam);
        contentValues.put("Kegiatan", Kegiatan);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        return res;

    }

    //Untuk menampilkan data paling pertama

    public Cursor getOneData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" ORDER BY Idjadwal ASC LIMIT 1",null);
        return res;
    }

    public boolean update (String Idjadwal,String Hari, String Jam, String Kegiatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Hari", Hari);
        contentValues.put("Jam", Jam);
        contentValues.put("Kegiatan", Kegiatan);
        db.update(TABLE_NAME, contentValues, "Idjadwal = ?", new String []{Idjadwal});
        return true;
    }

    public boolean hapus (String Idjadwal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Idjadwal", Idjadwal);
        db.delete(TABLE_NAME, "Idjadwal = ?", new String[]{Idjadwal});
        return true;
    }
}
