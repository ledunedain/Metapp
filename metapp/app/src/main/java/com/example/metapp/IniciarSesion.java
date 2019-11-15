package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {

    EditText nombreI,contrasenaI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        nombreI= (EditText) findViewById(R.id.TextNombre);
        contrasenaI = (EditText) findViewById(R.id.TextConstraseña);
    }

    public void OnClick(View v){ //metodo de los botones
        String nombre = nombreI.getText().toString();
        String contrasena = contrasenaI.getText().toString();

        Intent intent;

        switch (v.getId()){
            case R.id.btnInicar:

                if(!nombre.equals("") && !contrasena.equals("") ){
                    int id_usuario=Consultar(nombre,contrasena);

                    if(id_usuario>=0){
                        Toast toast1 =Toast.makeText(getApplicationContext(),"BIENVENIDO " + nombre + "!!!!", Toast.LENGTH_SHORT);
                        toast1.show();
                        intent = new Intent (v.getContext(), MenuUsuario.class);
                        intent.putExtra("id_usuario",id_usuario);
                        startActivityForResult(intent, 0);
                    }
                    else{
                        Toast toast1= Toast.makeText(getApplicationContext(),"NO EXISTE EL USUARIO",Toast.LENGTH_SHORT);
                        toast1.show();
                    }

                }else{
                    Toast toast1= Toast.makeText(getApplicationContext(),"HACE FALTA INFORMACIÓN",Toast.LENGTH_SHORT);
                    toast1.show();
                }

                break;
            case R.id.bntCancelar: //volver al activity MainActivity (cerrando este activity)
                //intent = new Intent (v.getContext(), .class);
                //startActivityForResult(intent, 0);
                finish();
                break;
        }
    }

    private int Consultar( String nombreC, String contrasenaC) {
        AdminSQLiteOpenHelpet admin = new AdminSQLiteOpenHelpet(this, "metappBD",null, 1);
        SQLiteDatabase MBD = admin.getWritableDatabase();

        Cursor cursor = MBD.rawQuery("SELECT id_usuario FROM usuario WHERE nombre = '" +nombreC+ "' AND contrasena = '" +contrasenaC+"' ;", null);

        if (cursor != null && cursor.moveToFirst()){
            Log.i("consulta","se encontro un elemento ");
            String num = cursor.getString(0);
            return Integer.parseInt(num);
        }
        return -1;
    }
}
