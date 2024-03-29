package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuUsuario extends AppCompatActivity {

    int id_usuarioMU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        id_usuarioMU = getIntent().getExtras().getInt("id_usuario");

    }
    public void OnClick(View v){ //metodo de los botones
        Intent intent;

        switch (v.getId()){
            case R.id.btn_MisMetapps:
                intent = new Intent (v.getContext(), MisMetapps.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);
                break;
            case R.id.bnt_CrearMetapp:
                intent = new Intent (v.getContext(), CrearMetapp.class);
                intent.putExtra("id_usuario",id_usuarioMU);
                startActivityForResult(intent, 0);
                break;
        }
    }
}
