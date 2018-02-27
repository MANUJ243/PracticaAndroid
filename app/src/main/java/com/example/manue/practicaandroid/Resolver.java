package com.example.manue.practicaandroid;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Resolver extends AppCompatActivity {
    String texto;
    String nombreFilm;
    String audio;
    private MediaPlayer mediaPlayer;
    TextView textView,textViewIntento;
    private static final String TAG = "RESOLVER";
    ArrayList<Button> botonesActivos = new ArrayList<>();
    ArrayList<Button> botonesInactivos = new ArrayList<>();
    FirebaseUser user;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resolver);

        Intent datosEntrada = getIntent();  //cojo el intent
        user = FirebaseAuth.getInstance().getCurrentUser();

        if (datosEntrada != null){  //cojo los datos que me llegan del intent
            texto = datosEntrada.getStringExtra("textoIntent");
            nombreFilm = datosEntrada.getStringExtra("nombreIntent");
            audio = datosEntrada.getStringExtra("audioUrl");
        }

        textView = findViewById(R.id.resolverText);
        textViewIntento = findViewById(R.id.intentoText);

        if (audio.equals("")){
            textView.setText(texto);
        }else{
            textView.setText("BANDA SONORA");
            mediaPlayer = MediaPlayer.create(getApplicationContext() , Uri.parse(audio));
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    reproducirBSO();
                }
            });
        }

        generadorBotones(nombreFilm);
    }

    public void generadorBotones(String nombre){
        ArrayList<Character> letras = new ArrayList<>();
        String alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        FlexboxLayout ll = findViewById(R.id.linearBotones);
        final Button button = findViewById(R.id.botonFlex);
        botonesActivos.add(button);
        String nombreSinEspacios = nombre.replaceAll(" ","");
        nombreSinEspacios = nombreSinEspacios.toUpperCase();
        char letra;
        Random r = new Random();
        button.setText(alphabet.charAt(r.nextInt(alphabet.length()))+"");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                anadirTexto((String) button.getText());
            }
        });

        for (int i = 0; i < 23; i++) {
            if (i >= nombreSinEspacios.length()){
                letra = alphabet.charAt(r.nextInt(alphabet.length()));
                letras.add(letra);
            }else{
                letras.add(nombreSinEspacios.charAt(i));
            }
        }

        Collections.shuffle(letras);

        for (int i = 0; i < letras.size(); i++) {
            final Button myButton = new Button(this);
            myButton.setLayoutParams(button.getLayoutParams());
            myButton.setText(letras.get(i)+"");
            myButton.setBackground(button.getBackground());
            botonesActivos.add(myButton);
            ll.addView(myButton);
        }

        anadirListeners();
    }

    public void anadirListeners(){
        for (int i = 0; i < botonesActivos.size(); i++) {
            final Button boton = botonesActivos.get(i);

            boton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (anadirTexto((String) boton.getText())){
                        boton.setEnabled(false);
                        boton.setVisibility(View.INVISIBLE);
                        botonesInactivos.add(boton);
                        botonesActivos.remove(boton);
                    }
                }
            });
        }
    }

    public boolean anadirTexto(String texto){
        if(nombreFilm.length() == textViewIntento.getText().length()) {
            return false;
        }else if (nombreFilm.charAt(textViewIntento.length()) == ' '){
            textViewIntento.append(" "+texto);
            return true;
        }else{
            textViewIntento.append(texto);
            victoria();
            return true;
        }
    }

    public void borrarTexto(View view) {
        if (textViewIntento.getText().length() > 1){
            if (textViewIntento.getText().charAt(textViewIntento.getText().length()-2) == ' '){
                textViewIntento.setText(textViewIntento.getText().subSequence(0,textViewIntento.getText().length()-2));
            }else{
                textViewIntento.setText(textViewIntento.getText().subSequence(0,textViewIntento.getText().length()-1));
            }
        }else{
            textViewIntento.setText(textViewIntento.getText().subSequence(0,textViewIntento.getText().length()-1));
        }

        Button boton = botonesInactivos.get(botonesInactivos.size()-1);
        boton.setVisibility(View.VISIBLE);
        boton.setEnabled(true);
        botonesActivos.add(boton);
        botonesInactivos.remove(botonesInactivos.size()-1);
    }

    public void victoria(){
        if (textViewIntento.getText().toString().equals(nombreFilm.toUpperCase())){
            textViewIntento.setText("VICTORIA");

            actualizarPuntuacion(user.getUid(),1);
        }
    }

    private void actualizarPuntuacion(String UID, int points) {
        if (audio.equals("")){
            mDatabase.child("usuarios").child(UID).child("puntos").setValue(FireMetodos.puntos+points);
        }else{
            mDatabase.child("usuarios").child(UID).child("puntosBSO").setValue(FireMetodos.puntosBSO+points);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }

    private void reproducirBSO() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        }else{
            mediaPlayer.start();
        }
    }
}
