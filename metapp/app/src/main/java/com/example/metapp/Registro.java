package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    TextView nombreET,contrasenaET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


    }
    public void OnClick(View v){ //metodo de los botones

        nombreET =  findViewById(R.id.TextNombreR);
        contrasenaET = findViewById(R.id.TextConstrasenaR);

        switch (v.getId()){
            case R.id.btnRegistrar:

                String nombre= nombreET.getText().toString();
                String contrasena = contrasenaET.getText().toString();

                if (!nombre.equals("") && !contrasena.equals("")) {
                    if(Registrar(nombre,contrasena)==true){
                        Toast toast1 =Toast.makeText(getApplicationContext(), "USUARIO REGISTRADO CON EXITO", Toast.LENGTH_SHORT);
                        toast1.show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"HUBO UN ERROR EN LA CARGA DE DATOS",Toast.LENGTH_SHORT);
                    }
                }else{
                    Toast toast2 =Toast.makeText(getApplicationContext(),"NO SE HA LLENADO ALGUN CAMPO",Toast.LENGTH_SHORT);
                    toast2.show();
                }
                break;
            case R.id.bntCancelar: //volver al activity MainActivity (cerrando este activity)
                //intent = new Intent (v.getContext(), .class);
                //startActivityForResult(intent, 0);
                finish();
                break;
        }
    }
    public boolean Registrar (String nombre , String contrasena){
        AdminSQLiteOpenHelpet admin = new AdminSQLiteOpenHelpet(this,"metappBD",null,1);
        SQLiteDatabase BDM = admin.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("nombre",nombre);
        content.put("contrasena",contrasena);
        BDM.insert("usuario",null,content);

        BDM.close();

        return true;
    }
}
