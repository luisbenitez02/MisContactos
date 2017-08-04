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
import com.example.luisb.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.example.luisb.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by luisb on 20/07/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Contacto> contactos;

    private RecyclerView rvContactos;//Recycler View contactos
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Nuestra vista, le vamos a pasar un fragment (es como un setcontetView)
        //asociamos un layout a una clase, aqui asociamos un frament a una clase
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());// uno bajo el otro
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);//el recycler view se comportara como Linear layout
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
