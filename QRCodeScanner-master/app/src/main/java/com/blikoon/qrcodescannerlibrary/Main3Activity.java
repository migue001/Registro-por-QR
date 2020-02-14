package com.blikoon.qrcodescannerlibrary;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.blikoon.qrcodescanner.CrearBD;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
public static RecyclerView recyclerView;
public static ArrayList<Recycler>j;
public static String idd;
    public static AdaptadorRecycler2 adaptadorRecycler2;
    public static CrearBD crearBD;
    public static SQLiteDatabase sqLiteDatabase;
    public static Cursor cursor1;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView=(RecyclerView) findViewById(R.id.informacion);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        crearBD=new CrearBD(Main3Activity.this,"bd_clases",null,1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        j=new ArrayList<>();
        llenar();
        imageButton=(ImageButton)findViewById(R.id.eliminar);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog=new AlertDialog.Builder(Main3Activity.this).create();
                alertDialog.setTitle("Eliminar");
                alertDialog.setMessage("Desea eliminar todas las clases?");
                alertDialog.setCancelable(false);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CrearBD crearBD=new CrearBD(Main3Activity.this,"bd_clases",null,1);
                        SQLiteDatabase db = crearBD.getWritableDatabase();
                        db.execSQL("DELETE FROM clasess");
                        j.clear();
                        adaptadorRecycler2=new AdaptadorRecycler2(j);
                        recyclerView.setAdapter(adaptadorRecycler2);
                        Toast.makeText(Main3Activity.this, "Se han eliminadp todas las clases", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alertDialog.show();

            }
        });
        /*ConexionBDD conexionBDD=new ConexionBDD(Main3Activity.this,"bd_clases",null, 2);
        SQLiteDatabase sqLiteDatabase=conexionBDD.getReadableDatabase();
        Cursor cursor1=sqLiteDatabase.rawQuery("SELECT * FROM clasess",null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
j=new ArrayList<String>();
if(cursor1!=null){
    while (cursor1.moveToNext()){
        j.add(cursor1.getInt(0)+cursor1.getString(1)+cursor1.getString(2)+cursor1.getString(4)+cursor1.getString(5)+cursor1.getString(6));
        //j.add("hola");
    }
}
else {
    Toast.makeText(Main3Activity.this, "No hay clases para mostrar", Toast.LENGTH_SHORT).show();
}*/
/*while (cursor1.moveToNext()){
    //j.add(cursor1.getInt(0)+cursor1.getString(1)+cursor1.getString(2)+cursor1.getString(4)+cursor1.getString(5)+cursor1.getString(6));
    j.add("hola");
}
AdaptadorRecycler adaptadorRecycler=new AdaptadorRecycler(j);
recyclerView.setAdapter(adaptadorRecycler);*/
        //textView.setText(cursor1.getString(0)+cursor1.getString(1)+cursor1.getString(2)+cursor1.getString(3)+cursor1.getString(4)+cursor1.getString(5));
        adaptadorRecycler2.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Main3Activity.this, "hola"+j.get(recyclerView.getChildAdapterPosition(view)).getId(), Toast.LENGTH_SHORT).show();
                idd=j.get(recyclerView.getChildAdapterPosition(view)).getId();
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
    }

    public static void llenar() {
         sqLiteDatabase=crearBD.getReadableDatabase();
        cursor1=sqLiteDatabase.rawQuery("SELECT * FROM clasess",null);
        if(cursor1!=null){
            while (cursor1.moveToNext()){
                //j.add(cursor1.getInt(0)+cursor1.getString(1)+cursor1.getString(2)+cursor1.getString(3)+cursor1.getString(4)+cursor1.getString(5)+cursor1.getString(6));
                //j.add("hola");
                j.add(new Recycler(""+cursor1.getInt(0),""+cursor1.getString(1)+"\nLaboratorio: "+cursor1.getString(2)+"\n"+cursor1.getString(4)));
            }
            //Toast.makeText(Main3Activity.this, "No hay clases para mostrar", Toast.LENGTH_SHORT).show();
        }
        adaptadorRecycler2=new AdaptadorRecycler2(j);
        recyclerView.setAdapter(adaptadorRecycler2);
    }
}
