package com.example.manue.practicaandroid;

import android.view.View;
import android.widget.TextView;

/**
 * Created by MANUEL MORENO DELGADO
 */

public class UserViewHolder {
    public TextView title;                                      //declaro variables
    public TextView subTitle;

    UserViewHolder(View view){
        title = view.findViewById(R.id.TitleText);              //paso los TextViews a codigo
        subTitle = view.findViewById(R.id.SubTitleText);
    }
}
