package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CrearMetapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_metapp);
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
                startActivityForResult(intent, 0);
                break;
        }
    }
}
