package com.example.manue.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class
Lista extends AppCompatActivity {
    ListView lista;
    public static ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        FireMetodos.getPeliculaArrayList();

        lista = findViewById(R.id.listaView);

        adapter = new ListAdapter(this, FireMetodos.listaD);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (FireMetodos.puntos == position){
                    Pelicula pelicula = (Pelicula) FireMetodos.listaD.get(position);
                    resolverAction(pelicula.desc,pelicula.nombre);
                }
            }
        });
    }

    public void resolverAction(String texto,String nombre){
        Intent intent = new Intent(this, Resolver.class);
        intent.putExtra("textoIntent",texto);
        intent.putExtra("nombreIntent",nombre);
        intent.putExtra("audioUrl","");
        startActivity(intent);
    }
}
