package com.blikoon.qrcodescannerlibrary;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blikoon.qrcodescanner.CrearBD;
public class Main4Activity extends AppCompatActivity {
TextView textView,textView2,textView3,textView4,textView5,textView6;
private String texto="",texto2="";
int a=0;
String l="Nombre:";
ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView=(TextView)findViewById(R.id.hh);
        textView2=(TextView)findViewById(R.id.profesor);
        textView3=(TextView)findViewById(R.id.laboratorio);
        textView4=(TextView)findViewById(R.id.fecha);
        textView5=(TextView)findViewById(R.id.horaentradaa);
        textView6=(TextView)findViewById(R.id.salida);
        imageButton=(ImageButton)findViewById(R.id.imageButton);

        final CrearBD crearBD=new CrearBD(Main4Activity.this,"bd_clases",null,1);
        SQLiteDatabase sqLiteDatabase=crearBD.getReadableDatabase();
        Cursor cursor1=sqLiteDatabase.rawQuery("SELECT alumnoinfo FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor1!=null){
            while (cursor1.moveToNext()) {
                //Toast.makeText(this, "Hola"+cursor1.getString(0), Toast.LENGTH_SHORT).show();
                texto=cursor1.getString(0);
            }
        }
    Cursor cursor2=sqLiteDatabase.rawQuery("SELECT profesor FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor2!=null){
            while (cursor2.moveToNext()){
                textView2.setText(cursor2.getString(0));
            }
        }
        Cursor cursor3=sqLiteDatabase.rawQuery("SELECT laboratorio FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor3!=null){
            while (cursor3.moveToNext()){
textView3.setText(cursor3.getString(0));
            }
        }
        Cursor cursor4=sqLiteDatabase.rawQuery("SELECT fecha FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor4!=null){
            while (cursor4.moveToNext()){
                textView4.setText(cursor4.getString(0));
            }
        }
        Cursor cursor5=sqLiteDatabase.rawQuery("SELECT horaentrada FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor5!=null){
            while (cursor5.moveToNext()){
                textView5.setText(cursor5.getString(0));
            }
        }
        Cursor cursor6=sqLiteDatabase.rawQuery("SELECT horasalida FROM clasess WHERE id='"+Main3Activity.idd+"'",null);
        if(cursor6!=null){
            while (cursor6.moveToNext()){
                textView6.setText(cursor6.getString(0));
            }
        }
        char [] arraychar=texto.toCharArray();
        for(int x=0;x<arraychar.length;x++){
            texto2+=arraychar[x];

            if(arraychar[x]==','){
                texto2+="\n";
                a++;
                if(a==1){
                    texto2+="Semestre: ";
                }
                if(a==2){
                    texto2+="Grupo:";
                }
                if(a==3){
                    texto2+="Licenciatura: ";

                }
                if(a==4){
                    texto2+="Numero de Cuenta: ";
                    a=0;
                }

            }
            if(arraychar[x]=='.'){
                texto2+="\n\n";
            }
        }
        textView.setText(texto2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog=new AlertDialog.Builder(Main4Activity.this).create();
alertDialog.setTitle("Eliminar");
alertDialog.setMessage("Desea eliminar esta Clase?");
alertDialog.setCancelable(false);
alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent=new Intent(Main4Activity.this,MainActivity.class);
        CrearBD crearBD=new CrearBD(Main4Activity.this,"bd_clases",null,1);
        SQLiteDatabase db=crearBD.getReadableDatabase();
        db.execSQL("DELETE FROM clasess WHERE id="+Main3Activity.idd+"");
        dialogInterface.dismiss();
        startActivity(intent);
        finish();
    }
});
alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
});
alertDialog.show();
                /*alertDialog.setTitle("Eliminar");
                alertDialog.setMessage("Desea eliminar la Clase?");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*CrearBD crearBD=new CrearBD(Main4Activity.this,"bd_clases",null,1);
                        SQLiteDatabase db = crearBD.getReadableDatabase();
                        String eliminar="DELETE FROM WHERE id='"+Main3Activity.idd+"'";
                        dialogInterface.dismiss();
                        db.execSQL(eliminar);*/

               //    }
                //});
                //alertDialog.show();
            }
        });
    }
}
