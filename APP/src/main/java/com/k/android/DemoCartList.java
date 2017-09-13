package com.k.android;
import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dell on 2/19/2016.
 */
public class DemoCartList {
    private ArrayList<CartItem> mCartList;
    private Context mAppContext;
    private static DemoCartList demoCartList;
    private DemoCartList(Context appContext){
        mAppContext=appContext;
        mCartList = new ArrayList<CartItem>();
        Random r1=new Random();
       /* for (int i=0;i<101;i++){
            int a=r1.nextInt();
            CartItem cartItem=new CartItem(Integer.toString(a));
            cartItem.setName("Name"+i);
            cartItem.setCategory("Category" + i);
            cartItem.setQuantity(0);
            mCartList.add(cartItem);
        } */
    }
    public static DemoCartList getL(Context c) {
        if (demoCartList== null) {
            demoCartList = new DemoCartList(c.getApplicationContext());
        }
        return demoCartList;
    }
    public ArrayList<CartItem> getList() {
        return mCartList;
    }
    public void addItem(CartItem cartItem){
        mCartList.add(cartItem);
    }
}
