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

    private static final int LIKE = 1;//aumento de los likes
    private Context context;

    public ConstructorContactos(Context context) {
       this.context = context;
    }
    /*NOTA: No importa de donde obtenga los datos, siempre deben venir en arrayList*/
    public ArrayList<Contacto> obtenerDatos(){
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

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        //lenamos el objeto
        //obtenemos primero el ID
        contentValues.put(ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_CONTACT_NUM_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
