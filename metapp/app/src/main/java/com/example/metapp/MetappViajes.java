package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MetappViajes extends AppCompatActivity {
    int id_usuarioMA;

    EditText descripcionV, dateV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metapp_viajes);
        id_usuarioMA = getIntent().getExtras().getInt("id_usuario");

        descripcionV = (EditText) findViewById(R.id.TextDesc);
        dateV = (EditText) findViewById(R.id.TextDate);
    }

    public void OnClick(View v) { //metodo de los botones
        Intent intent;
        switch (v.getId()){
            case R.id.btnVAceptar:
                String desc =descripcionV.getText().toString();
                String date = dateV.getText().toString();

                if(desc.equals("") || date.equals("")){
                    Toast.makeText(this, "Faltan Campos Por llenar", Toast.LENGTH_SHORT).show();
                }else{
                    SubirMetapp(id_usuarioMA,desc,date);
                    intent = new Intent (v.getContext(), MenuUsuario.class);
                    intent.putExtra("id_usuario", id_usuarioMA);
                    startActivityForResult(intent, 0);
                }

                break;
            case R.id.bntVCancelar:

                intent = new Intent (v.getContext(), MenuUsuario.class);
                intent.putExtra("id_usuario", id_usuarioMA);
                startActivityForResult(intent, 0);
                break;
        }
    }

    private void SubirMetapp(int id_usuarioMU, String descripcionV, String dateV) {

        AdminSQLiteOpenHelpet admin = new AdminSQLiteOpenHelpet(this,"metappBD",null,1);
        SQLiteDatabase BDM = admin.getWritableDatabase();

        ContentValues content = new ContentValues();

        content.put("descripcion",descripcionV);
        content.put("fecha",dateV);
        content.put("id_persona",(Integer)id_usuarioMU);

        BDM.insert("metapp",null,content);

        BDM.close();
        Toast.makeText(this, "Metapp agregada exitosamente!", Toast.LENGTH_SHORT).show();
    }
}
