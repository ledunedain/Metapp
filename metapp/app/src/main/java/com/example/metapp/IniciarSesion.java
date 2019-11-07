package com.example.metapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
    }

    public void OnClick(View v){ //metodo de los botones
        Intent intent;

        switch (v.getId()){
            case R.id.btnRegistrar:
                /**en este se debe verificar en la base de datos los datos correctos del usuario para que inicie el otro activity, si no permanece
                 * en este hasta que cancele o digite los datos correctos
                 */
                Toast toast1 =Toast.makeText(getApplicationContext(),"BIENVENIDO USUARIO", Toast.LENGTH_SHORT);
                toast1.show();

                intent = new Intent (v.getContext(), MenuUsuario.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.bntCancelar: //volver al activity MainActivity (cerrando este activity)
                //intent = new Intent (v.getContext(), .class);
                //startActivityForResult(intent, 0);
                finish();
                break;
        }
    }
}
