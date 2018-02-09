package com.example.manue.practicaandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by manue on 10/02/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<PeliculaBSO> mData;

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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_pelicula_title.setText(mData.get(position).getTitle());
        holder.pelicula_thumbnail.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pelicula_title;
        ImageView pelicula_thumbnail;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_pelicula_title = (TextView) itemView.findViewById(R.id.pelicula_title_id);
            pelicula_thumbnail = (ImageView) itemView.findViewById(R.id.pelicula_img_id);

        }
    }

}
