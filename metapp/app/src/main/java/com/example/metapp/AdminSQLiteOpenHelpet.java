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

        metappDB.execSQL("CREATE TABLE usuario ( id_usuario INTEGER PRIMARY KEY AUTOINCREMENT , nombre text , contrasena text ) ;");
        metappDB.execSQL("CREATE TABLE metapp ( id_meta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , descripcion text , fecha text , id_persona INTEGER );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase metappDB, int i, int i1) {

    }
}
