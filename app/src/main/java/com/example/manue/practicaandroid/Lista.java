package com.example.manue.practicaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class
Lista extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lista = findViewById(R.id.listaView);                    //cojo por codigo el listView

        ListAdapter adapter = new ListAdapter(this, FireMetodos.listaD);  //inicializo mi ListAdapter, pasandole el contexto
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (FireMetodos.puntos == position *3){
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
        startActivity(intent);
    }
}
