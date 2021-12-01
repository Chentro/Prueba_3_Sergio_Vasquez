package com.eva.prueba_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resulta2 extends AppCompatActivity {

    int a, b, c, d;
    TextView txt1, txt2, txt3,txt4;
    Button Btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulta2);

        txt1=(TextView) findViewById(R.id.textView2);
        txt2=(TextView) findViewById(R.id.textView4);
        txt3=(TextView) findViewById(R.id.textView6);
        txt4=(TextView) findViewById(R.id.textView8);

        Btn3=(Button) findViewById(R.id.button);

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });

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

        txt1.setText(b+"");
        txt2.setText(c+"");
        txt3.setText(d+"");
        txt4.setText(a+"");

    }
}