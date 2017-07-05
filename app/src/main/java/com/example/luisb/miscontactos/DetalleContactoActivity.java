package com.example.luisb.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //vamos a recibir los parametros
        Bundle parametros =getIntent().getExtras();

        String nombre   = parametros.getString(getResources().getString(R.string.pnombre));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email    = parametros.getString(getResources().getString(R.string.pemail));

        //vamos a mostrar los datos en la view
        TextView tvNombre   = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail    = (TextView) findViewById(R.id.tvEmail);

        //le asignamos los parametros que trajimos
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }
}
