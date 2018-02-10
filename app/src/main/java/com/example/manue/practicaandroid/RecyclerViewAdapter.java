package com.example.manue.practicaandroid;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.master.glideimageview.GlideImageView;
import java.io.IOException;
import java.util.List;

/**
 * Created by manue on 10/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<PeliculaBSO> mData;
    private MediaPlayer mediaPlayer;

    public RecyclerViewAdapter(Context mContext, List<PeliculaBSO> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_pelicula,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_pelicula_title.setText(mData.get(position).getTitle());
        holder.pelicula_thumbnail.loadImageUrl(mData.get(position).getUrl());
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(mContext, Uri.parse(mData.get(position).getAudio()));
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pelicula_title;
        GlideImageView pelicula_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_pelicula_title = (TextView) itemView.findViewById(R.id.pelicula_title_id);
            pelicula_thumbnail = (GlideImageView) itemView.findViewById(R.id.pelicula_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

}
