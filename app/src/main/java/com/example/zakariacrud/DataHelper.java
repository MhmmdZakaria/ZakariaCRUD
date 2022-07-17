package com.example.zakariacrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASES_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) { super(context, DATABASES_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table biodata(npm integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("data", "onCreate: " + sql );
        db.execSQL(sql);
        sql = "INSERT INTO biodata (npm,nama,tgl,jk,alamat) VALUES ('100','Muhammad Zakaria','06 Februari 2001','L','Banjarmasin');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
