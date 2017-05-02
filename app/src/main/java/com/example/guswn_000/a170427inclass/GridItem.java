package com.example.guswn_000.a170427inclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by guswn_000 on 2017-04-27.
 */

public class GridItem extends LinearLayout
{
    TextView tv;
    ImageView iv;
    TextView tv2;
    public GridItem(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.griditem,this);
        tv = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        iv = (ImageView)findViewById(R.id.img1);
    }
    public void setData(Fruit one,boolean visible)
    {
        tv.setText(one.getName());
        tv2.setText(one.getPrice());
        iv.setImageResource(one.getImgno());
        if(visible){tv2.setVisibility(VISIBLE);}
        else {tv2.setVisibility(INVISIBLE);}
    }

}
