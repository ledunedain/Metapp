package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MisMetapps extends AppCompatActivity {

    ArrayList<ObjectMetapp> datos;
    RecyclerView recycler;
    int id_usuarioMU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_metapps);

        recycler = (RecyclerView) findViewById(R.id.Recyclerid);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        id_usuarioMU = getIntent().getExtras().getInt("id_usuario");

        datos = new ArrayList<ObjectMetapp>();

    /*    for (int i=0; i<=50;i++){
            datos.add("dato: " + i);
        }*/

        AdminSQLiteOpenHelpet admin = new AdminSQLiteOpenHelpet(this, "metappBD",null, 1);
        SQLiteDatabase MBD = admin.getWritableDatabase();

        Cursor cursor = MBD.rawQuery("SELECT descripcion, fecha FROM metapp WHERE id_persona = '" +id_usuarioMU+ "' ;", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                ObjectMetapp iterator =
                        new ObjectMetapp(cursor.getString(cursor.getColumnIndex("descripcion")),cursor.getString(cursor.getColumnIndex("fecha")));

                datos.add(iterator);
                cursor.moveToNext();
            }
        }else{
            ObjectMetapp iterator = new ObjectMetapp("no hay metapps aun", "no hay metapps aun");
            datos.add(iterator);
        }
        MBD.close();
        AdapterDatos adapter = new AdapterDatos(datos);
        recycler.setAdapter(adapter);
    }
}