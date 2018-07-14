package com.example.luisb.miscontactos.restApi;

/**
 *Esta clase es importante para tener los archivos y url organizado
 * No es mas que una clase para mantener informacion bien definida
 *
 * NO HACE NADA SOLO PASA INFO a otras clases que solicitan info a la API web
 */


public final class ConstantesRestApi {
    public final String VERSION = "/v1/";
    public final String ROOT_URL = "ttps://api.instagram.com" + VERSION;
    public final String ACCES_TOKEN = "1203680564.d566126.cdc0e3acc44c42cab7b9653c159535bd";
    public final String KEY_ACCES_TOKEN = "?access_token=";
    public final String KEY_GET_INFORMATION_USER = "users/self/media/recent/";
    public final String URL_GET_INFORMATION_USER = KEY_GET_INFORMATION_USER + KEY_ACCES_TOKEN + ACCES_TOKEN;



    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCES_TOKEN

}
