package com.example.guswn_000.a170427inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity
{

    ArrayList<Fruit> fruit = new ArrayList<>();
    final int imglist[] = {R.drawable.abocado,R.drawable.watermelon,R.drawable.orange,R.drawable.banana,
            R.drawable.cherry,R.drawable.cranberry,R.drawable.grape,R.drawable.kiwi};

    GridAdapter adapter;
    GridView gridView;
    AddFruit addFruit;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gridView = (GridView)findViewById(R.id.grid);
        fruit.add(new Fruit("아보카도",imglist[0],"1000원"));
        fruit.add(new Fruit("수박",imglist[1],"1000원"));
        fruit.add(new Fruit("오렌지",imglist[2],"1000원"));
        fruit.add(new Fruit("바나나",imglist[3],"1000원"));
        adapter = new GridAdapter(this,fruit);
        gridView.setAdapter(adapter);
        addFruit = (AddFruit)findViewById(R.id.add);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, String price) {
                Toast.makeText(getApplicationContext(), name + "" + imgno,Toast.LENGTH_SHORT).show();
                fruit.add(new Fruit(name,imgno,price));
                adapter.notifyDataSetChanged();
            }
        });
        checkBox = (CheckBox)findViewById(R.id.checkBox2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    adapter.showprice(0);
                }
                else
                {
                    adapter.showprice(1);
                }
            }
        });

    }
}
