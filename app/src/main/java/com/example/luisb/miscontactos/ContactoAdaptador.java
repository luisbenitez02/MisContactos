package com.example.luisb.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by luisb on 10/07/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    /*creamos este constructor*/
    //ahora le pasamos un activity
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
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
        final Contacto contacto =  contactos.get(position);

        //asignamos los elementos a las vistas
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvtelefonoCV.setText(contacto.getTelefono());

        /* Vamos a hacer que cada uno de nuestros items seal ckicleables */
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //mostramos un toast al tocar el elemento con el nombre
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_LONG).show();

                //intento que nos llevara a la pagina de detalle del contacto
                Intent intento = new Intent(activity, DetalleContactoActivity.class);

                intento.putExtra("nombre",contacto.getNombre());
                intento.putExtra("telefono",contacto.getTelefono());
                intento.putExtra("email",contacto.getEmail());

                activity.startActivity(intento);
            }
        });

        /*Ahora vamos a hacer clickeable la manito de me gusta*/
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Un like para " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

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
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvtelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
