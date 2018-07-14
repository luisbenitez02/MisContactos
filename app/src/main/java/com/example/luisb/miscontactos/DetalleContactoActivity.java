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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContactoActivity extends AppCompatActivity {
    //son globales para manipularlos en los metodos de llamar y enviar mail
   /* private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;*/

    private static final String KEY_EXTRA_URL = "url";//nombres de llaves con los que se enviaron parametros
    private static final String KEY_EXTRA_LIKES = "like";


    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);//para que se vea bien en todas las pantallas

        //vamos a recibir los parametros
        Bundle parametros = getIntent().getExtras();

        String url = parametros.getString(KEY_EXTRA_URL);//llaves aqui
        int likes = parametros.getInt(KEY_EXTRA_LIKES);


        //vamos a mostrar los datos en la view

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);

        //le asignamos los parametros que trajimos
        //falta la foto pero es por que la gestionaremos luego
        tvLikesDetalle.setText(String.valueOf(likes));
    }
    /*
    public void llamar(View v) {

        String telefono = tvTelefono.getText().toString();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }

        //IMPORTANTE: Dale los permisos a la app desde la configuracion de tu telefono
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
    }*/
/*
    public void enviarMail(View v){
        String email = tvEmail.getText().toString();

        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));//que tipo de envio sera? mailto: email
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);//a quien sera enviado
        //indicamos que tipo de aplicacion queremos en el chosser
        emailIntent.setType("message/rfc822");
        //vamos a crear un selector para elegir entre todas las apps de correo
        startActivity(Intent.createChooser(emailIntent,"Email "));
    }*/

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
