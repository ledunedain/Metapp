package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v){ //metodo de los botones
        Intent intent;

        switch (v.getId()){
            case R.id.btn_Registrarse:
                intent = new Intent (v.getContext(), Registro.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.btn_IniciarSesion:
                intent = new Intent (v.getContext(), IniciarSesion.class);
                startActivityForResult(intent, 0);
                break;
        }
    }
}
