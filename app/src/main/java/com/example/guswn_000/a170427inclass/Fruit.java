package com.example.guswn_000.a170427inclass;

import android.widget.TextView;

/**
 * Created by guswn_000 on 2017-04-27.
 */

public class Fruit
{
    String name;
    int imgno;
    String price;
//    TextView pricetv;
    final static int imglist[] = {R.drawable.abocado,R.drawable.banana,R.drawable.cherry,R.drawable.cranberry,
            R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};

    public Fruit(String name, int imgno, String price)
    {
        this.name = name;
        this.imgno = imgno;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
//
//    public void setPricetv(TextView pricetv) {
//        this.pricetv = pricetv;
//    }
//
//    public TextView getPricetv() {
//        return pricetv;
//    }
}
