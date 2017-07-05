package com.example.luisb.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //nuestro array list, seran contactos ()incluyendo sus elementos
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos= new ArrayList<Contacto>();

        contactos.add(new Contacto("Luis Benitez", "315478965","luis@mimail.co"));
        contactos.add(new Contacto("Daniel Arevalo", "315478475","daniloca@mail.net"));
        contactos.add(new Contacto("Patricia Criollo", "35478965",""));
        contactos.add(new Contacto("Ana Lopez", "874599621","anita@pepa.co"));
        contactos.add(new Contacto("Hernando", "458745637","pepito@mail.co"));

        //vamos a llenar un array de contactos solo con sus nombre
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        //Debemos utilizar un adaptador si queremos llemar un ListView
        //simple_list_item = un layout para la lista sencillo
        //aqui vamos a llenar el list View
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

    }
}
