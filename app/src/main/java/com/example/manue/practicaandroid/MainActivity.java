package com.example.manue.practicaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    Button boton1;
    ProgressBar progressBar;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-8810149351311606~4636982690");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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
