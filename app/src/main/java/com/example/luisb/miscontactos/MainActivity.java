package com.example.luisb.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        contactos.add(new Contacto("Patricia Criollo", "3184602589",""));
        contactos.add(new Contacto("Ana Lopez", "3225046132","anita@pepa.co"));
        contactos.add(new Contacto("Hernando", "3225046155","pepito@mail.co"));

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

        /*vamos a crear un intent Implicito: nos permitira unir las actividades */

        //escuchara cuando se hace click sobre elemento de la lista

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //donde estoy y a donde quiero ir
                Intent intento = new Intent(MainActivity.this, DetalleContactoActivity.class);

                //necesitamos pasar los parametros del elemento seleccionado
                //con putextra los añadimos al intent
                //(nombre, telefono, mail) ---> uno por uno
                //getResources().getString(R.string.pnombre) --> corresponde}
                //a las claves que utilizaremos para identificar el elemento
                //y tambien son definidos como recursos string
                intento.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intento.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intento.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                startActivity(intento);
            }
        });

    }
}
