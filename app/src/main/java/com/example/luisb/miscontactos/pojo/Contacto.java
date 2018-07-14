package com.example.luisb.miscontactos.pojo;

/**
 * Created by luisb on 4/07/2017.
 */

public class Contacto {

    private String id;//No estara en el costructor pero si necesita getter y setter
    private String fullName;
    private String urlFoto;//la url me devuelve una cadena
    private int likes=0;


    /*Contructor (Alt + Insert): para que el elemento exista minimo se requiere
        nombre y telefono */

    public Contacto(String urlFoto, String fullName, int likes) {
        this.urlFoto = urlFoto;
        this.fullName = fullName;
        this.likes = likes;
    }

    public Contacto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
