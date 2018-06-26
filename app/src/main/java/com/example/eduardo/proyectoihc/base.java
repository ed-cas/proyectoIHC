package com.example.eduardo.proyectoihc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class base extends SQLiteOpenHelper {


    String sql = "create table institucion (id INTEGER not null primary key autoincrement, nombre TEXT, direccion TEXT, telefono TEXT, descripcion TEXT, tipo TEXT, img BLOB)";

    public  base (Context context, String nom, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, nom, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sql);

    }

    public void  onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS institucion");

    }

}
