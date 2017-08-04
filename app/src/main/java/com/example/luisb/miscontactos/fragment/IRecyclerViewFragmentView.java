package com.example.luisb.miscontactos.fragment;

import com.example.luisb.miscontactos.adapter.ContactoAdaptador;
import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by luisb on 1/08/2017.
 */

public interface IRecyclerViewFragmentView {

    /*para que nuestro recicler view sea mostrado en un linear Layout*/
    public void generarLinearLayoutVertical();

    /*inicializa el adaptador*/
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    /*vamos a setear el adaptador al recycler view (se lo vamos a pasar pues)*/
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
