package com.example.luisb.miscontactos;

/**
 * Created by luisb on 4/07/2017.
 */

public class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private int foto;


    /*Contructor (Alt + Insert): para que el elemento exista minimo se requiere
        nombre y telefono */

    public Contacto(String nombre, String telefono, String email, int foto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
