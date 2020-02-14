package com.blikoon.qrcodescanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jj on 20/10/19.
 */

public class CrearBD extends SQLiteOpenHelper{


    public CrearBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE clasess (id INTEGER primary key autoincrement,profesor TEXT,laboratorio TEXT,alumnoinfo TEXT,fecha TEXT,horaentrada TEXT,horasalida TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
