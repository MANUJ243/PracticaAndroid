package com.example.manue.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton1 = findViewById(R.id.entrenamientoButton);
        //progressBar = findViewById(R.id.loadingBar);
    }

    public void accionSinglePlayer(View view) {
        Intent intent = new Intent(this, RecyclePeliculas.class);
        startActivity(intent);
    }

    public void accionBSOQuiz(View view) {
        Intent intent = new Intent(this, Lista.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //boton1.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.INVISIBLE);
    }

    public void accionPerfil(View view) {
    }
}
