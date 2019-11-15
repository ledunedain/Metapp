package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearMetapp extends AppCompatActivity {

    int id_usuarioMU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_metapp);
        id_usuarioMU = getIntent().getExtras().getInt("id_usuario");
    }
    public void OnClick(View v){ //metodo de los botones
        Intent intent;

        switch (v.getId()){
            /*
            * en esta parte se deben de de seleccionar las categorías que el usuario escogerá para que este
            * empiece a crear una nueva Metapp
            */
            case R.id.btnViajes:
                intent = new Intent (v.getContext(), MetappViajes.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);

                break;
            case R.id.btnAhorro:
                intent = new Intent (v.getContext(), MetappAhorro.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);

                break;
            case R.id.btnAlcancia:
                intent = new Intent (v.getContext(), MetappAlcancia.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);
                break;
            case R.id.btnRegresarCM:
                intent = new Intent (v.getContext(), MenuUsuario.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);
                break;
            case R.id.CerrarSesionCM:
                intent = new Intent (v.getContext(), IniciarSesion.class);
                startActivityForResult(intent, 0);
                break;
        }
    }
}
