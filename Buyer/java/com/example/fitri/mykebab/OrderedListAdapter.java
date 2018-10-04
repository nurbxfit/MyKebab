package com.example.fitri.mykebab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fitri on 16/12/2017.
 */

public class OrderedListAdapter extends ArrayAdapter<Order> {

    List<Order> myOrder;

    public OrderedListAdapter(@NonNull Context context, int resource, @NonNull List<Order> objects) {
        super(context, resource, objects);
        myOrder = objects;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Order order = myOrder.get(position);
        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.myorder_card, null);

        ImageView myItemImage = (ImageView) view.findViewById(R.id.mymenuImage);
        TextView myItemname = (TextView) view.findViewById(R.id.mymenuName);
        TextView myItemQuantity= (TextView) view.findViewById(R.id.mymenuQuantity);
        TextView myItemPrice = (TextView) view.findViewById(R.id.mymenuPrice);

        myItemname.setText(order.getOrderItem());
        myItemPrice.setText("Total Price: RM"+order.getPrice());
        myItemQuantity.setText("Quantity:"+order.getQuantity());

        if(order.getOrderItem().equals("Kebab"))
        {
            myItemImage.setImageResource(R.drawable.pitakebab);
        }else if (order.getOrderItem().equals("Burger Goreng"))
        {
            myItemImage.setImageResource(R.drawable.burger);
        }
        else if (order.getOrderItem().equals("Kebab Rolls"))
        {
            myItemImage.setImageResource(R.drawable.kebabwrap);
        }
        else if (order.getOrderItem().equals("Satay Ikan"))
        {
            myItemImage.setImageResource(R.drawable.satay);
        }


        return  view;
    }
}