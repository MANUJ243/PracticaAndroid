package com.example.manue.practicaandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by MANUEL MORENO DELGADO
 */

public class ListAdapter extends BaseAdapter{
    List<Pelicula> peliculas;                                         //declaro variables
    LayoutInflater inflater;

    ListAdapter(Context context, List<Pelicula> peliculas){           //entran el contexto y
        this.peliculas = peliculas;                                   //la lista de usuarios
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return peliculas.size();
    }

    @Override
    public Object getItem(int i) {
        return peliculas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {    //con el inflater
        View layout = view;                                         //paso XML a objetos
        UserViewHolder viewHolder = null;

        if (layout == null){
            layout = inflater.inflate(R.layout.fila_list, viewGroup, false);
            viewHolder = new UserViewHolder(layout);                //llamo a viewHolder para evitar
            layout.setTag(viewHolder);                              //cargar constantemente los TextView
        }else{
            viewHolder = (UserViewHolder) layout.getTag();
        }

        if (FireMetodos.puntos > i){
            viewHolder.title.setText(peliculas.get(i).desc);           //los doy texto a los TextView
            viewHolder.subTitle.setText(peliculas.get(i).nombre);        //de viewHolder
        }else if(FireMetodos.puntos == i ){
            viewHolder.title.setText(peliculas.get(i).desc);           //los doy texto a los TextView
            viewHolder.subTitle.setText("1 "+getEmojiByUnicode(0x1F31F));        //de viewHolder
        }else{
            viewHolder.title.setText("\uD83D\uDD12");           //los doy texto a los TextView
            viewHolder.subTitle.setText("BLOQUEADA");        //de viewHolder
        }

        return layout;                                              //retorno el layout
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
