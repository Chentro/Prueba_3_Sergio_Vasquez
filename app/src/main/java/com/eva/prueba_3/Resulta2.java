package com.eva.prueba_3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Resulta2 extends AppCompatActivity {

    int a, b, c, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulta2);

        SQLiteDatabase db;
        conexion conn = new conexion(getApplicationContext());
        db = conn.getReadableDatabase();
        Cursor C = db.query("votos", null, null, null, null, null, null);
        if (C != null) {
            if (C.moveToFirst()) {
                do {
                    int voto_blaco = C.getInt(1);
                    int voto_nulo = C.getInt(2);
                    int voto_boric = C.getInt(3);
                    int voto_kast = C.getInt(4);

                    a=0;
                    b=0;
                    c=0;
                    d=0;

                    if (voto_blaco==1){
                        a=a+1;
                    }
                    if (voto_nulo==1){
                        b=b+1;
                    }
                    if (voto_boric==1){
                        c=c+1;
                    }
                    if (voto_kast==1){
                        d=d+1;
                    }

                }
                while (C.moveToNext());


            }
        }
    }
}