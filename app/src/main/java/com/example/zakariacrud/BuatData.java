package com.example.zakariacrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_data);
        dbHelper = new DataHelper(this);
        text1= (EditText) findViewById(R.id.npm);
        text2= (EditText) findViewById(R.id.nama);
        text3= (EditText) findViewById(R.id.tgl);
        text4= (EditText) findViewById(R.id.jeniskelamin);
        text5= (EditText) findViewById(R.id.alamat);
        bt1=(Button) findViewById(R.id.simpan);
        bt2=(Button) findViewById(R.id.kembali);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(npm,nama,tgl,jk,alamat) values('"+
                        text1.getText(). toString()+"','"+
                        text2.getText(). toString()+"','"+
                        text3.getText(). toString()+"','"+
                        text4.getText(). toString()+"','"+
                        text5.getText(). toString()+"')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}