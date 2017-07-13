package com.example.luisb.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContactoActivity extends AppCompatActivity {
    //son globales para manipularlos en los metodos de llamar y enviar mail
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);//para que se vea bien en todas las pantallas

        //vamos a recibir los parametros
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");

        //vamos a mostrar los datos en la view
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        //le asignamos los parametros que trajimos
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    public void llamar(View v) {

        String telefono = tvTelefono.getText().toString();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }

        //IMPORTANTE: Dale los permisos a la app desde la configuracion de tu telefono
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
    }

    public void enviarMail(View v){
        String email = tvEmail.getText().toString();

        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));//que tipo de envio sera? mailto: email
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);//a quien sera enviado
        //indicamos que tipo de aplicacion queremos en el chosser
        emailIntent.setType("message/rfc822");
        //vamos a crear un selector para elegir entre todas las apps de correo
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }

    @Override
    /*Vamos a capturar el evento de toque sobre el boton "back" para volver a la actividad anterior (esto por que la matamos antes y ya no esta en la pila)*/
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intento = new Intent(DetalleContactoActivity.this, MainActivity.class);
            startActivity(intento);
        }

        return super.onKeyDown(keyCode, event);
    }
}
