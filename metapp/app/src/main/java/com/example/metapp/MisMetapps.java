package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MisMetapps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_metapps);
    }

    /*
    aqui se deben mostrar todas las metapps del usuario y cuando este las selecciona deben de abrirse y
    mostrar su prograso (también con una gráfica) del cumplimiento de la metapp
     */
    public void OnClick(View v) { //metodo de los botones
        Intent intent;

        switch (v.getId()) {
            case R.id.metapp1:
                /*
                intent = new Intent(v.getContext(), .class);
                startActivityForResult(intent, 0);
                */
                break;
        }
    }
}