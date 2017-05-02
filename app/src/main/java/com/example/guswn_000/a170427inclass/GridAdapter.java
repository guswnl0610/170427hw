package com.example.guswn_000.a170427inclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guswn_000 on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Fruit> fruit = new ArrayList<>();
    boolean visible = false;


    public GridAdapter(Context context, ArrayList<Fruit> fruit) {
        this.context = context;
        this.fruit = fruit;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
//        if(convertView == null)
//        {
//            convertView = LayoutInflater.from(context).inflate(R.layout.griditem,null);
//        }
//        final TextView tv = (TextView)convertView.findViewById(R.id.tv1);
//        final ImageView iv = (ImageView)convertView.findViewById(R.id.img1);
//        final TextView tv2 = (TextView)convertView.findViewById(R.id.tv2);
//        tv.setText(fruit.get(position).name);
//        tv2.setText(fruit.get(position).getPrice());
//        iv.setImageResource(fruit.get(position).imgno);
//
//        Fruit one = fruit.get(position);
//        one.setPricetv(tv2);

        if(convertView == null)
            convertView = new GridItem(context);
        ((GridItem)convertView).setData(fruit.get(position),visible);
        return convertView;
    }

    public void showprice(boolean visible)
    {
//        if(show == 0)
//        {
//            for (int i = 0 ; i < fruit.size() ; i++)
//            {
//                fruit.get(i).getPricetv().setVisibility(View.VISIBLE);
//            }
//        }
//        else
//        {
//            for (int i = 0; i < fruit.size() ; i++)
//            {
//                fruit.get(i).getPricetv().setVisibility(View.INVISIBLE);
//            }
//        }
        this.visible = visible;
        this.notifyDataSetChanged();
    }



}