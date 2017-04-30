package com.example.guswn_000.a170427inclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by guswn_000 on 2017-04-27.
 */

public class SpinnerAdapter extends BaseAdapter
{
    String fruit[];
    Context context;

    public SpinnerAdapter(String[] fruit, Context context) {
        this.fruit = fruit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int position) {
        return fruit[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner,null);
        }
        TextView tv = (TextView)convertView.findViewById(R.id.textView);
        tv.setText(fruit[position]);
        //만약에 체크박스 체크할때마다 이벤트를 걸고싶을땐 겟뷰에서
        CheckBox c1 = (CheckBox)convertView.findViewById(R.id.checkBox);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {

                }
            }
        });
        return convertView;
    }
}
