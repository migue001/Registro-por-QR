package com.blikoon.qrcodescannerlibrary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.blikoon.qrcodescanner.CrearBD;
import com.blikoon.qrcodescanner.QrCodeActivity;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
Button buttonfecha,agregar;
public static EditText ff,horadeentrada,horadesalida,laboratorioo,profesore;
    Calendar cal;
    private static final int REQUEST_CODE_QR_SCAN = 101;

    int dia, mes, año,id=1;
public static String fecha,horqdeentrada,horasalida,profesorr,laboratorio;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cal=Calendar.getInstance();
        dia=cal.get(Calendar.DAY_OF_MONTH);
        mes=cal.get(Calendar.MONTH);
        año=cal.get(Calendar.YEAR);
        setContentView(R.layout.activity_main2);
buttonfecha=(Button)findViewById(R.id.fechaa);
agregar=(Button)findViewById(R.id.agregaralumnos);
//labotratorio2=laboratorio.getText().toString();
ff=(EditText)findViewById(R.id.fff);
horadeentrada=(EditText)findViewById(R.id.horaentrada);
horadesalida=(EditText)findViewById(R.id.horasalida);
        laboratorioo=(EditText)findViewById(R.id.laboratorio);
        profesore=(EditText)findViewById(R.id.profesor);
buttonfecha.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        DatePickerDialog datePickerDialog=new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                ff.setText(i2+"/"+(i1+1)+"/"+i);
            }
        },año,mes,dia);
        datePickerDialog.show();
    }
});
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ff.getText().toString().equalsIgnoreCase("") || horadesalida.getText().toString().equalsIgnoreCase("") || horadeentrada.getText().toString().equalsIgnoreCase("") || laboratorioo.getText().toString().equalsIgnoreCase("") || profesore.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(Main2Activity.this, "Rellena todos los campos de Texto", Toast.LENGTH_SHORT).show();
                }
                else {
                    registrar();
                    Intent i = new Intent(Main2Activity.this, QrCodeActivity.class);
                    startActivityForResult(i, REQUEST_CODE_QR_SCAN);
                    finish();
                }
            }
        });

    }

    private void registrar() {
        QrCodeActivity.fecha=ff.getText().toString();
        QrCodeActivity.profesorr=profesore.getText().toString();
        QrCodeActivity.laboratorio=laboratorioo.getText().toString();
        QrCodeActivity.horasalida=horadesalida.getText().toString();
        QrCodeActivity.horqdeentrada=horadeentrada.getText().toString();
       /* try {
            ConexionBDD crearBD = new ConexionBDD(Main2Activity.this, "bd_clases", null, 2);
            SQLiteDatabase sqLiteDatabase = crearBD.getReadableDatabase();
            sqLiteDatabase.execSQL("INSERT INTO clasess (profesor, laboratorio, fecha, horaentrada, horasalida)VALUES('" + profesore.getText().toString() + "','" + laboratorioo.getText().toString() + "','" + ff.getText().toString() + "','" + horadeentrada.getText().toString() + "','" + horadesalida.getText().toString() + "')");
            Toast.makeText(Main2Activity.this, "Se ha creado la clase, Agregue Alumnos" + laboratorioo.getText().toString(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(Main2Activity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i(""+e.getMessage(),null);
        }*/
    }
}
