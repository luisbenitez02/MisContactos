package com.example.luisb.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.luisb.miscontactos.R;
import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by luisb on 3/08/2017.
 */

/*Intermediario entre la clase que consulta la BD*/
public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
       this.context = context;
    }
    /*NOTA: No importa de donde obtenga los datos, siempre deben venir en arrayList*/
    public ArrayList<Contacto> obtenerDatos(){
      /*  ArrayList<Contacto> contactos= new ArrayList<Contacto>();

        contactos.add(new Contacto("Luis Benitez", "315478965","luis@mimail.co", R.drawable.fresa, 5));
        contactos.add(new Contacto("Daniel Arevalo", "315478475","daniloca@mail.net",R.drawable.mora, 10));
        contactos.add(new Contacto("Patricia Criollo", "3184602589","",R.drawable.naranja, 3));
        contactos.add(new Contacto("Ana Lopez", "3225046132","anita@pepa.co",R.drawable.pera, 6));
        contactos.add(new Contacto("Hernando", "3225046155","pepito@mail.co",R.drawable.sandia, 9));

        return contactos;*/
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerAllContacts();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACS_NOMBRE, "Juana De Arco");
        contentValues.put(ConstantesBD.TABLE_CONTACS_TELEFONO, "3184596872");
        contentValues.put(ConstantesBD.TABLE_CONTACS_EMAIL, "mimail@sexymail.com");
        contentValues.put(ConstantesBD.TABLE_CONTACS_FOTO, R.drawable.sandia);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBD.TABLE_CONTACS_NOMBRE, "Luis Benitez");
        contentValues.put(ConstantesBD.TABLE_CONTACS_TELEFONO, "315478965");
        contentValues.put(ConstantesBD.TABLE_CONTACS_EMAIL, "luis@mimail.co");
        contentValues.put(ConstantesBD.TABLE_CONTACS_FOTO, R.drawable.fresa);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBD.TABLE_CONTACS_NOMBRE, "Patricia Criollo");
        contentValues.put(ConstantesBD.TABLE_CONTACS_TELEFONO, "3184602589");
        contentValues.put(ConstantesBD.TABLE_CONTACS_EMAIL, "paticita@mimail.co");
        contentValues.put(ConstantesBD.TABLE_CONTACS_FOTO, R.drawable.pera);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBD.TABLE_CONTACS_NOMBRE, "Hernando");
        contentValues.put(ConstantesBD.TABLE_CONTACS_TELEFONO, "3225046155");
        contentValues.put(ConstantesBD.TABLE_CONTACS_EMAIL, "pepito@mail.co");
        contentValues.put(ConstantesBD.TABLE_CONTACS_FOTO, R.drawable.mora);

        db.insertarContacto(contentValues);

    }
}
