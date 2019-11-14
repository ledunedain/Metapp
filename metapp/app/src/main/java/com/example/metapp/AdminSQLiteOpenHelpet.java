package com.example.metapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelpet extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelpet(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase metappDB) {

        metappDB.execSQL("CREATE TABLE usuario ( id_usuario INTEGER PRIMARY KEY AUTOINCREMENT , nombre text , contrasena text ) ");
        metappDB.execSQL("CREATE TABLE metapp ( id_meta int NOT NULL PRIMARY KEY , descripcion text , fecha date , id_persona int NOT NULL, FOREIGN KEY ( id_persona ) REFERENCES usuario ( id_usuario ) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase metappDB, int i, int i1) {

    }
}
