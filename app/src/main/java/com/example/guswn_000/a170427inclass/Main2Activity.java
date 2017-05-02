package com.example.guswn_000.a170427inclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    String[] atcvitems = {"Abocado","Banana","Cherry","Cranberry","Grape","Kiwi","Orange","Watermelon",
                        "아보카도","바나나","체리","크랜베리","포도","키위","오렌지","수박"};
    GridAdapter adapter;
    GridView gridView;
    AddFruit addFruit;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Fruit Store");

        gridView = (GridView)findViewById(R.id.grid);
//        fruit.add(new Fruit("아보카도",imglist[0],"1000원"));
//        fruit.add(new Fruit("수박",imglist[1],"1000원"));
//        fruit.add(new Fruit("오렌지",imglist[2],"1000원"));
//        fruit.add(new Fruit("바나나",imglist[3],"1000원"));
        adapter = new GridAdapter(this,fruit);
        gridView.setAdapter(adapter);
        addFruit = (AddFruit)findViewById(R.id.add);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imgno, String price) {
//                Toast.makeText(getApplicationContext(), name + "" + imgno,Toast.LENGTH_SHORT).show();
                fruit.add(new Fruit(name,imgno,price));
                adapter.notifyDataSetChanged();
            }
        });

        addFruit.actv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, atcvitems)); //

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
                final Fruit one = fruit.get(position);
                addFruit.b_add.setText("M");
                addFruit.actv.setText(one.getName());
                addFruit.et.setText(one.getPrice());
                addFruit.img.setImageResource(one.getImgno());
//                addFruit.imgno = 이녀석의 imgno는 인덱스다..
                if(one.getImgno() == R.drawable.abocado) {addFruit.imgno = 0;}
                else if(one.getImgno() == R.drawable.banana) {addFruit.imgno = 1;}
                else if(one.getImgno() == R.drawable.cherry) {addFruit.imgno = 2;}
                else if(one.getImgno() == R.drawable.cranberry) {addFruit.imgno = 3;}
                else if(one.getImgno() == R.drawable.grape) {addFruit.imgno = 4;}
                else if(one.getImgno() == R.drawable.kiwi) {addFruit.imgno = 5;}
                else if(one.getImgno() == R.drawable.orange) {addFruit.imgno = 6;}
                else if(one.getImgno() == R.drawable.watermelon) {addFruit.imgno = 7;}

                addFruit.setOnModifyListener(new AddFruit.OnModifyListener()
                {
                    @Override
                    public void onModify(String name, int imgno, String price)
                    {
                        one.setName(name);
                        one.setImgno(imgno);
                        one.setPrice(price);
                        addFruit.b_add.setText("ADD");
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

        checkBox = (CheckBox)findViewById(R.id.checkBox2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {adapter.showprice(isChecked);}
                else
                {adapter.showprice(isChecked);}
            }
        });
    }
}