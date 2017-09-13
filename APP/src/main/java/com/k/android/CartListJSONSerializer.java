package com.k.android;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by dell on 2/19/2016.
 */
public class CartListJSONSerializer {
    private Context mContext;
    private String mFilename;
    public CartListJSONSerializer(Context c,String f){
        mContext=c;
        mFilename=f;
    }
    public ArrayList<CartItem> loadCartItems() throws IOException, JSONException{
        ArrayList<CartItem> cartItems=new ArrayList<CartItem>();
        BufferedReader reader=null;
        try{
            InputStream in = mContext.openFileInput(mFilename);
            reader=new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder=new StringBuilder();
            String line=null;
            while((line=reader.readLine())!=null){
                stringBuilder.append(line);
            }
            JSONArray array=(JSONArray)new JSONTokener(stringBuilder.toString()).nextValue();
            for(int i=0;i<array.length();i++){
                cartItems.add(new CartItem(array.getJSONObject(i)));
            }}
            catch(FileNotFoundException e){

        }
        finally {
            if (reader != null)
                reader.close();
        }
        return cartItems;
    }
    public void saveCart(ArrayList<CartItem> cartItems) throws JSONException, IOException {
        JSONArray jsonArray=new JSONArray();
        for (CartItem cartItem:cartItems)
            jsonArray.put(cartItem.toJSON());
Writer writer=null;
        try{
            OutputStream out=mContext.openFileOutput(mFilename,Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonArray.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer!=null){
                writer.close();
            }
        }

    }
}
