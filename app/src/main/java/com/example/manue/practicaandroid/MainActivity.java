package com.example.manue.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    ProgressBar progressBar;
    private static final String TAG = "MAIN :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton1 = findViewById(R.id.entrenamientoButton);
        //progressBar = findViewById(R.id.loadingBar);
    }

    public void accionSinglePlayer(View view) {
        if (FireMetodos.listaD.size() == 0 || FireMetodos.puntos == -1) {
            Log.i(TAG, "ENTRO EN EL IF DE EL MAIN");
            FireMetodos.getPeliculaArrayList();
            Log.i(TAG, "METODO GET PELICULAS LLAMADO");
            try {
                Log.i(TAG, "INTENTO HACER EL AQUIRE DEL SEMAFORO");
                FireMetodos.semaphore.acquire();
            } catch (InterruptedException e) {
            }
        }

        Log.i(TAG, "LLAMO A LA ACTIVIDAD");
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }

    public void accionBSOQuiz(View view) {
        //Intent intent = new Intent(this, Lista.class);
        //startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //boton1.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.INVISIBLE);
    }

    public void accionPerfil(View view) {
        if (FireMetodos.listaBSO.size() == 0 || FireMetodos.puntosBSO == -1) {
            FireMetodos.getPeliculaArrayListBSO();
            try {
                FireMetodos.semaphore.acquire();
            } catch (InterruptedException e) {
            }
        }

        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }
}
