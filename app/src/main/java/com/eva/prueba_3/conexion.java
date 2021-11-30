package com.eva.prueba_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class conexion extends SQLiteOpenHelper {

    public static String Nombre_BD="Votos_Presidenciales.db";
    public static int version_DB=1;
    public static String NombreTabla="create table votos (id_voto integer primary key autoincrement, voto_blaco integer, voto_nulo integer, voto_boric integer, voto_kast integer)";

    public conexion(@Nullable Context context) {
        super(context, Nombre_BD,null, version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NombreTabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists votos");
        sqLiteDatabase.execSQL(NombreTabla);
    }
}
