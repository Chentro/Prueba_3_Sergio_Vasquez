package com.eva.prueba_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rd_1, rd_2, rd_3;
    Button Btn1, Btn2;
    int nulo, boric, kast, blanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rd_1=(RadioButton) findViewById(R.id.Rd_btn_1);
        rd_2=(RadioButton) findViewById(R.id.Rd_btn_2);
        rd_3=(RadioButton) findViewById(R.id.Rd_btn_3);

        Btn1=(Button) findViewById(R.id.btn_1);
        Btn2=(Button) findViewById(R.id.btn_2);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta();
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(), Resulta2.class);
                startActivity(I);
            }
        });
    }

    public void alerta(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atencion!");
        builder.setMessage("¿Esta Seguro de Continuar?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                blanco=1;
                if (rd_1.isChecked()){
                    nulo=1; blanco=0;
                }
                if (rd_2.isChecked()){
                    boric=1; blanco=0;
                }
                if (rd_3.isChecked()){
                    kast=1; blanco=0;
                }

                SQLiteDatabase db;
                conexion conn=new conexion(getApplicationContext());
                db=conn.getWritableDatabase();
                ContentValues cv=new ContentValues();
                cv.put("voto_blaco", blanco);
                cv.put("voto_nulo", nulo);
                cv.put("voto_boric", boric);
                cv.put("voto_kast", kast);

                db.insert("votos",null,cv);
                Toast.makeText(getApplicationContext(),"Voto Guardado",Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}