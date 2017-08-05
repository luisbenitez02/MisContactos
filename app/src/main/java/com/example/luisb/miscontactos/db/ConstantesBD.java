package com.example.luisb.miscontactos.db;

/**
 * Created by luisb on 3/08/2017.
 */
/*la clase tambien es constante*/
public final class ConstantesBD {

    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;
    /*nombres de las tablas-----------------------------*/
    public static final String TABLE_CONTACS            = "contacto";
    public static final String TABLE_CONTACS_ID         = "id";
    public static final String TABLE_CONTACS_NOMBRE     = "nombre";
    public static final String TABLE_CONTACS_TELEFONO   = "telefono";
    public static final String TABLE_CONTACS_EMAIL      = "email";
    public static final String TABLE_CONTACS_FOTO       = "foto";
    public static final String TABLE_LIKES_CONTACT = "contacto_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUM_LIKES = "numero_likes";
}
