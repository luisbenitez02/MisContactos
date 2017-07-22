package com.example.luisb.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;//Esta para dar soporte anteriores a 4
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luisb.miscontactos.R;

/**
 * Created by luisb on 20/07/2017.
 */

public class RecyclerViewFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Nuestra vista, le vamos a pasar un fragment (es como un setcontetView)
        //asociamos un layout a una clase, aqui asociamos un frament a una clase
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }
}
