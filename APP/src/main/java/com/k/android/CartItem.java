package com.k.android;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 2/19/2016.
 */
public class CartItem {
    private  static final String JSON_ID="id";
    private static final String JSON_NAME="name";
    private static final String JSON_QUANTITY="quantity";
    private static final String JSON_CATEGORY="category";
    private static final String JSON_PRICE="price";
    private String mId;
    private String mName;
    private int mQuantity;
    private String mCategory;
    private int mPrice;
    public JSONObject toJSON() throws JSONException{
        JSONObject json=new JSONObject();
        json.put(JSON_ID,mId);
        json.put(JSON_NAME,mName);
        json.put(JSON_QUANTITY,mQuantity);
        json.put(JSON_CATEGORY,mCategory);
        json.put(JSON_PRICE,mPrice);
        return  json;
    }
    public CartItem(JSONObject json) throws JSONException{
        mId=json.getString(JSON_ID);
        mName=json.getString(JSON_NAME);
        mQuantity=json.getInt(JSON_QUANTITY);
        mCategory=json.getString(JSON_CATEGORY);
        mPrice=json.getInt(JSON_PRICE);
    }
    public CartItem(String mId){
        this.mId=mId;
    }
    public String getId(){
        return mId;
    }
    public String getName(){return mName;}
    public int getQuantity(){return mQuantity;}
    public int getPrice(){return mPrice;}
    public String getCategory(){return mCategory;}
    public void setName(String name){mName=name;}
    public void setQuantity(int Quantity){mQuantity=Quantity;}
    public void setPrice(int Price){mPrice=Price;}
    public void setCategory(String Category){mCategory=Category;}
}
