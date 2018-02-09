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

/**
 * Created by manue on 20/01/2018.
 */

public class FireMetodos {
    public static ArrayList<Pelicula> listaD = new ArrayList<>();
    public static int puntos;
    private static final String TAG = "Lista";

    public static void getPeliculaArrayList(final Context context) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("peliculas");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaD.clear();

                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    String emoji = dataSnapshot.child(i + "").child("emoji").getValue().toString();
                    String nombre = dataSnapshot.child(i + "").child("nombre_pelicula").getValue().toString();
                    Pelicula pelicula = new Pelicula(nombre, emoji);

                    listaD.add(pelicula);
                }
                getPuntosFromFirebase(context);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.i("FIREBASE METHOTS", error.toString());
            }
        });
    }

    public static void anadirPuntuacionUser(FirebaseUser user){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("usuarios").child(user.getUid()).setValue(0);
    }

    public static void writeNewFilm(String peliculaID, String name, String desc) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Pelicula pelicula = new Pelicula(name, desc);
        mDatabase.child("peliculas").child(peliculaID).setValue(pelicula);
    }

    public static void getPuntosFromFirebase(final Context context) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference ref = database.getReference().child("usuarios").child(user.getUid());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                puntos = Integer.parseInt(dataSnapshot.getValue().toString());

                Intent intent = new Intent(context, Lista.class);
                context.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
