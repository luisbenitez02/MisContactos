package com.example.luisb.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by luisb on 3/08/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTableContact = "CREATE TABLE " + ConstantesBD.TABLE_CONTACS + "("+                  ConstantesBD.TABLE_CONTACS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +                      ConstantesBD.TABLE_CONTACS_NOMBRE + " TEXT, " +
               ConstantesBD.TABLE_CONTACS_TELEFONO + " TEXT, " +
               ConstantesBD.TABLE_CONTACS_EMAIL + " TEXT, " +
               ConstantesBD.TABLE_CONTACS_FOTO + " INTEGER " +
                ")";
        String queryCrearTableLikesContact = "CREATE TABLE " + ConstantesBD.TABLE_LIKES_CONTACT + "(" + ConstantesBD.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
          ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +  ConstantesBD.TABLE_LIKES_CONTACT_NUM_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES "+ ConstantesBD.TABLE_CONTACS + "("+ ConstantesBD.TABLE_CONTACS_ID +")" +
                ")";

        db.execSQL(queryCreateTableContact);
        db.execSQL(queryCrearTableLikesContact);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBD.TABLE_CONTACS);
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBD.TABLE_LIKES_CONTACT);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerAllContacts(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_CONTACS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);//nos ayuda a recorrer los registros

        while (registros.moveToNext()){//vamos a recorrer los registros
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString((3)));
            contactoActual.setFoto(registros.getInt(4));

            //Recuperemos los likes
            String queryLikes = "SELECT COUNT("+ ConstantesBD.TABLE_LIKES_CONTACT_NUM_LIKES + ") as likes FROM " + ConstantesBD.TABLE_LIKES_CONTACT + " WHERE " + ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                contactoActual.setLikes(registrosLikes.getInt(0));
            } else{
                contactoActual.setLikes(0);
            }

            contactos.add(contactoActual);//rellenamos el array contactos
        }

        db.close();
        return contactos;
    }
    //contenvalues tiene el valor y su respectivo campo
    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_CONTACS,null,contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_CONTACT,null,contentValues);
        db.close();

    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes  = 0;
        String query = "SELECT COUNT(" + ConstantesBD.TABLE_LIKES_CONTACT_NUM_LIKES + ")" +
                " FROM " + ConstantesBD.TABLE_LIKES_CONTACT + " WHERE " + ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
