package com.example.luisb.miscontactos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luisb on 10/07/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;

    /*creamos este constructor*/
    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //vamos a inflar nuestro layout con la cardView (Recycler view)
        //lo pasara al viewholder para que el obtenga cada elemento (views)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent, false);

        return new ContactoViewHolder(v);
    }

    /*
    * Se va incovando cada vez que se recorre la lista de contactos (uno a uno)
    * va extrayendo los elementos de la lista
    * asocia cada elemento de la vista a cada view
    * */
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto =  contactos.get(position);

        //asignamos los elementos a las vistas
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvtelefonoCV.setText(contacto.getTelefono());
    }

    @Override
    /*
    * //cantidad de elementos que contiene la lista de contactos*/
    public int getItemCount() {
        return contactos.size();
    }

    /*el metodo constructor*/
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private  TextView tvtelefonoCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvtelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
        }
    }
}
