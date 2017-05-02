package com.example.guswn_000.a170427inclass;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by guswn_000 on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    int imgno;
    AutoCompleteTextView actv;
    EditText et;
    ImageView img;
    Button b_next,b_add;
    public AddFruit(Context context, @Nullable AttributeSet attrs) //Attrivuteset이 달려있는 생성자를 만들어야 xml에도 추가된다
    {
        super(context, attrs);
        init(context);
    }

    void init(Context context)
    {
        LayoutInflater.from(context).inflate(R.layout.fruitadd,this);
        actv = (AutoCompleteTextView) findViewById(R.id.f_name);
        et = (EditText)findViewById(R.id.f_price);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == b_add)
        {
            if(b_add.getText().toString().equals("ADD"))
            {
                onAddListener.onAdd(actv.getText().toString(), Fruit.imglist[imgno] , et.getText().toString());
            }
            else
            {
                onModifyListener.onModify(actv.getText().toString(), Fruit.imglist[imgno] , et.getText().toString());
            }
        }
        else if (v ==  b_next)
        {
            if(imgno == Fruit.imglist.length - 1)
            {
                imgno = 0;
                img.setImageResource(Fruit.imglist[imgno]);
            }
            else
            {
                imgno++;
                img.setImageResource(Fruit.imglist[imgno]);
            }
        }
    }

    interface OnAddListener // 이녀석이랑 메인액티비티의 그리드뷰랑 통신하려면 이런 인터페이스가 필요함
    {
        void onAdd(String name, int imgno, String price); //인터페이스에 메소드 한개
    }
    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener)
    {
        this.onAddListener = onAddListener; // 메인액티비티한테 뭘 지정하기 위해서 만든거래...모르겟어...
        //애드버튼누를때 메인애티비티가 콜백으로 받음
    }

    interface OnModifyListener
    {
        void onModify(String name, int imgno, String price);
    }
    public OnModifyListener onModifyListener;

    public void setOnModifyListener(OnModifyListener onModifyListener)
    {
        this.onModifyListener = onModifyListener; // 메인액티비티한테 뭘 지정하기 위해서 만든거래...모르겟어...
        //애드버튼누를때 메인애티비티가 콜백으로 받음
    }
}