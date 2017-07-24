package com.example.luisb.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;//Esta para dar soporte anteriores a 4
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luisb.miscontactos.R;
import com.example.luisb.miscontactos.adapter.ContactoAdaptador;
import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by luisb on 20/07/2017.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Contacto> contactos;

    private RecyclerView rvContactos;//Recycler View contactos

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Nuestra vista, le vamos a pasar un fragment (es como un setcontetView)
        //asociamos un layout a una clase, aqui asociamos un frament a una clase
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());//mostrara uno bajo el otro
        //GridLayoutManager llm = new GridLayoutManager(this,2);//muestra en grid (cuantas columnas?)
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);//el recycler view se comportara como Linear layout
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    /*para inicializar adaptador*/
    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        //asignamos el adaptador
        rvContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos= new ArrayList<Contacto>();

        contactos.add(new Contacto("Luis Benitez", "315478965","luis@mimail.co",R.drawable.fresa));
        contactos.add(new Contacto("Daniel Arevalo", "315478475","daniloca@mail.net",R.drawable.mora));
        contactos.add(new Contacto("Patricia Criollo", "3184602589","",R.drawable.naranja));
        contactos.add(new Contacto("Ana Lopez", "3225046132","anita@pepa.co",R.drawable.pera));
        contactos.add(new Contacto("Hernando", "3225046155","pepito@mail.co",R.drawable.sandia));
    }
}
