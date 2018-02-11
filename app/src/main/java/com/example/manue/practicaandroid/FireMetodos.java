package com.example.manue.practicaandroid;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by manue on 20/01/2018.
 */

public class FireMetodos {
    public static ArrayList<Pelicula> listaD = new ArrayList<>();
    public static ArrayList<PeliculaBSO> listaBSO = new ArrayList<>();
    public static int puntos = -1;
    public static int puntosBSO = -1;
    public static Semaphore semaphore = new Semaphore(0);
    private static final String TAG = "FIREMETHOTS: ";

    public static void getPeliculaArrayList() {
        Log.i(TAG, "EL TAMANO DE LISTAD ES "+listaD.size());

            Log.i(TAG, "ESTOY DENTRO DE IF DE GETPELICULAS METODO");
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("peliculas");
            ref.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i(TAG, "ENTRO EN ON DATA CHANGE");

                    for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                        String emoji = dataSnapshot.child(i + "").child("emoji").getValue().toString();
                        String nombre = dataSnapshot.child(i + "").child("nombre_pelicula").getValue().toString();
                        Pelicula pelicula = new Pelicula(nombre, emoji);

                        listaD.add(pelicula);
                    }

                    Log.i(TAG, "LLAMO A GET_PUNTOS");
                    getPuntosFromFirebase();
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.i("FIREBASE METHOTS", error.toString());
                }
            });
    }

    public static void getPeliculaArrayListBSO() {
        if (listaBSO.size() == 0) {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("peliculasBSO");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    listaBSO.clear();

                    for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                        String nombre = dataSnapshot.child(i + "").child("nombre").getValue().toString();
                        String url = dataSnapshot.child(i + "").child("url").getValue().toString();
                        String audio = dataSnapshot.child(i + "").child("audio").getValue().toString();
                        PeliculaBSO pelicula = new PeliculaBSO(nombre, url, audio);

                        listaBSO.add(pelicula);
                    }
                    getPuntosFromFirebase();
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    Log.i("FIREBASE METHOTS", error.toString());
                }
            });
        }
    }

    public static void anadirPuntuacionUser(FirebaseUser user){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("usuarios").child(user.getUid()).child("puntos").setValue(0);
        mDatabase.child("usuarios").child(user.getUid()).child("puntosBSO").setValue(0);
    }

    public static void getPuntosFromFirebase() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = database.getReference().child("usuarios").child(user.getUid());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                puntos = Integer.parseInt(dataSnapshot.child("puntos").getValue().toString());
                puntosBSO = Integer.parseInt(dataSnapshot.child("puntosBSO").getValue().toString());

                Log.i(TAG, "COJO PUNTOS HAGO REALEASE");
                semaphore.release();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
