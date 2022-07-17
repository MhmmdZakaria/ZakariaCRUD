package com.example.zakariacrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt2;
    TextView text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        dbHelper = new DataHelper(this);
        text1 = (TextView) findViewById(R.id.npm);
        text2 = (TextView) findViewById(R.id.nama);
        text3 = (TextView) findViewById(R.id.tgl);
        text4 = (TextView) findViewById(R.id.jeniskelamin);
        text5 = (TextView) findViewById(R.id.alamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        bt2 = (Button) findViewById(R.id.kembali);
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