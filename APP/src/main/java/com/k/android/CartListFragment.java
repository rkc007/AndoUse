package com.k.android;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ActionMode;
import android.widget.AbsListView.MultiChoiceModeListener;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu.ContextMenuInfo;

import org.json.JSONException;
import org.w3c.dom.Text;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dell on 2/19/2016.
 */
public class CartListFragment extends ListFragment {
    private ArrayList<CartItem> mCartList;
    private CartListJSONSerializer serializer;
    private static final String FILENAME = "cartlist.json";
    ListView listView;
    @Override
    public void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        serializer=new CartListJSONSerializer(getActivity(),FILENAME);
        try {
            mCartList = serializer.loadCartItems();
        } catch (Exception e) {
            mCartList = new ArrayList<CartItem>();
            Log.e("nope", "Error loading crimes: ", e);
        }

        CartListAdapter adapter=new CartListAdapter(mCartList);

        setListAdapter(adapter);

        setHasOptionsMenu(true);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cart, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Random r1=new Random();
                int a=r1.nextInt();
                CartItem cartItem=new CartItem(Integer.toString(a));
                cartItem.setName("Name"+item.getItemId());
                cartItem.setCategory("category");
                cartItem.setPrice(8);
                cartItem.setQuantity(0);
                mCartList.add(cartItem);

                saveCart(mCartList);
                ((CartListAdapter)getListAdapter()).notifyDataSetChanged();
                return true;
            case R.id.scanner:
            {Intent i=new Intent(getActivity(),BarCodeReader.class);
            getActivity().startActivityForResult(i,20);

                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle args=getArguments();
        args.getString("key", "");
        CartItem cartItem=new CartItem(args.getString("key",""));
        mCartList.add(cartItem);
        saveCart(mCartList);
        ((CartListAdapter)getListAdapter()).notifyDataSetChanged();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v=super.onCreateView(inflater, parent, savedInstanceState);
        ListView listView = (ListView)v.findViewById(android.R.id.list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.crime_list_item_context, menu);
                return true;
            }

            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_delete_crime:
                        CartListAdapter adapter = (CartListAdapter) getListAdapter();

                        for (int i = adapter.getCount() - 1; i >= 0; i--) {
                            if (getListView().isItemChecked(i)) {
                                deleteCartItem(adapter.getItem(i));
                            }
                        }
                        mode.finish();
                        adapter.notifyDataSetChanged();
                        return true;
                    default:
                        return false;
                }
            }

            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {

            }
        });
        return v;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.crime_list_item_context, menu);
    }
    public boolean saveCart(ArrayList<CartItem> cartItems){

        try{
            serializer.saveCart(cartItems);
            Log.d("    ", "crimes saved to file");
            return true;
        } catch (Exception e) {
            Log.e("    ", "Error saving crimes: ", e);
            return false;
        }
    }

    public void deleteCartItem(CartItem cartItem){
        mCartList.remove(cartItem);
        saveCart(mCartList);
    }
    public void onResume(){
        super.onResume();
    }
    private class CartListAdapter extends ArrayAdapter<CartItem>{
        public CartListAdapter(ArrayList<CartItem> cartList){super(getActivity(),0,cartList);}
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView==null){
                convertView=getActivity().getLayoutInflater().inflate(R.layout.listitem,null);
            }
            CartItem c = getItem(position);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.item_name);
            titleTextView.setText(c.getName());
            TextView idTextView =
                    (TextView) convertView.findViewById(R.id.item_id);
            idTextView.setText(c.getId());
            TextView quantityTextView =
                    (TextView) convertView.findViewById(R.id.quantity);
            quantityTextView.setText(c.getPrice()+"");
            return convertView;
        }
    }
    public static CartListFragment newInstance(String scanContent) {
        Bundle args = new Bundle();
        args.putString("key", scanContent);
        CartListFragment cartListFragment=new CartListFragment();
        cartListFragment.setArguments(args);

        return cartListFragment;
    }
}
