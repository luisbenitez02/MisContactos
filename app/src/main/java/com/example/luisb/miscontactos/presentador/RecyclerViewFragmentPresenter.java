package com.example.luisb.miscontactos.presentador;

import android.content.Context;

import com.example.luisb.miscontactos.adapter.ContactoAdaptador;
import com.example.luisb.miscontactos.db.ConstructorContactos;
import com.example.luisb.miscontactos.fragment.IRecyclerViewFragmentView;
import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by luisb on 3/08/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBD();
    }

    @Override
    public void obtenerContactosBD() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();//aqui separamos la fuente de los datos con la presentacion
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));

        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
