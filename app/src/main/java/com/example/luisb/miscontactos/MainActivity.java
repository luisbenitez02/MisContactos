package com.example.luisb.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.luisb.miscontactos.adapter.ContactoAdaptador;
import com.example.luisb.miscontactos.adapter.PageAdapter;
import com.example.luisb.miscontactos.fragment.PerfilFragment;
import com.example.luisb.miscontactos.fragment.RecyclerViewFragment;
import com.example.luisb.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //nuestro array list, seran contactos ()incluyendo sus elementos
    private ArrayList<Contacto> contactos;

    private RecyclerView rvContactos;//Recycler View contactos

    /*Variables de nuestro Fragment*/
    private Toolbar miToolbar;
    private TabLayout miTabLayout;
    private ViewPager miViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);//para que se vea bien en todas las pantallas

        miToolbar = (Toolbar) findViewById(R.id.mitoolbar);
        miTabLayout = (TabLayout) findViewById(R.id.miTabLayout);
        miViewPager = (ViewPager) findViewById(R.id.miViewPager);

        setUpViewPager();

        /*
        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);//mostrara uno bajo el otro
        //GridLayoutManager llm = new GridLayoutManager(this,2);//muestra en grid (cuantas columnas?)
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);//el recycler view se comportara como Linear layout
        inicializarListaContactos();
        inicializarAdaptador();
        */
        if(miToolbar !=null){
            setSupportActionBar(miToolbar);
        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    /*Pone en 'orbita' los fragments */
    private void setUpViewPager(){
        miViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        miTabLayout.setupWithViewPager(miViewPager);
    }

    /*para inicializar adaptador*/
    public void inicializarAdaptador(){
       ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
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
