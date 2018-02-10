package com.example.manue.practicaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclePeliculas extends AppCompatActivity {

    List<PeliculaBSO> lstPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_peliculas);

        lstPeliculas = new ArrayList<>();
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));
        lstPeliculas.add(new PeliculaBSO("Pelicula mala", "https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Narcos_season_1.png/250px-Narcos_season_1.png",1));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstPeliculas);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }
}
