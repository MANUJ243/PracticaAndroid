package com.example.manue.practicaandroid;

import android.view.View;
import android.widget.TextView;

public class UserViewHolder {
    public TextView title;
    public TextView subTitle;

    UserViewHolder(View view){
        title = view.findViewById(R.id.TitleText);
        subTitle = view.findViewById(R.id.SubTitleText);
    }
}
