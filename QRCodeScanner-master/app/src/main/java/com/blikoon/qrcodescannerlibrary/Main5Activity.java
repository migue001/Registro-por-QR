package com.blikoon.qrcodescannerlibrary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.blikoon.qrcodescanner.CrearBD;

public class Main5Activity extends AppCompatActivity {
EditText editText,editText2,editText3,editText4,editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
editText=(EditText)findViewById(R.id.profesor2);
editText2=(EditText)findViewById(R.id.laboratorio2);
editText3=(EditText)findViewById(R.id.fff);
editText4=(EditText)findViewById(R.id.horaentrada2);
editText5=(EditText)findViewById(R.id.horasalida2);

        CrearBD crearBD=new CrearBD(Main5Activity.this,"bd_clases",null,1);
        SQLiteDatabase sqLiteDatabase=crearBD.getReadableDatabase();
        Cursor cursor1=sqLiteDatabase.rawQuery("SELECT profesor FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor1!=null){
            while(cursor1.moveToNext()){
                editText.setText(cursor1.getString(0));
            }
        }
        Cursor cursor11=sqLiteDatabase.rawQuery("SELECT laboratorio FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor11!=null){
            while(cursor11.moveToNext()){
                editText2.setText(cursor11.getString(0));
            }
        }
        Cursor cursor12=sqLiteDatabase.rawQuery("SELECT fecha FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if (cursor12!=null){
            while(cursor12.moveToNext()){
                editText3.setText(cursor12.getString(0));
            }
        }
        Cursor cursor13=sqLiteDatabase.rawQuery("SELECT horaentrada FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor13!=null){
            while (cursor13.moveToNext()){
                editText4.setText(cursor13.getString(0));
            }
        }
        Cursor cursor14=sqLiteDatabase.rawQuery("SELECT horasalida FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor14!=null){
            while (cursor14.moveToNext()){
                editText5.setText(cursor14.getString(0));
            }
        }
    }
}
