package com.example.fitri.mykebabshop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by fitri on 17/12/2017.
 */

class OrderedListAdapter extends ArrayAdapter<Order> {
    List<Order> myOrder;
    Users user;

    public OrderedListAdapter(@NonNull Context context, int resource, @NonNull List<Order> objects,Users user) {
        super(context, resource, objects);
        myOrder = objects;
        this.user=user;

    }

    public OrderedListAdapter(@NonNull Context context, int resource, @NonNull List<Order> objects) {
        super(context, resource, objects);
        myOrder = objects;
        this.user=user;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Order order = myOrder.get(position);
        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.myorder_card, null);

        TextView myItemname = (TextView) view.findViewById(R.id.mymenuName);
        TextView myItemQuantity= (TextView) view.findViewById(R.id.mymenuQuantity);
        TextView myItemPrice = (TextView) view.findViewById(R.id.mymenuPrice);
        TextView buyerName = (TextView) view.findViewById(R.id.buyername);
        TextView buyerPhone = (TextView) view.findViewById(R.id.buyerphone);
        TextView location = (TextView) view.findViewById(R.id.location);

        Button doneButton = (Button) view.findViewById(R.id.doneButton);

        if(order.getUSER_ID().equals(""))
        {
            Log.d("Test ID Finish:","OALALALALALALA");
            doneButton.setVisibility(View.INVISIBLE);
        }
        else
        {
            Log.d("Test ID Finish:","ID="+order.getUSER_ID());
        }

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mydatabase = FirebaseDatabase.getInstance().getReference();
                String id = mydatabase.child("FinishedOrder").push().getKey();
                mydatabase.child("FinishedOrder").child(id).setValue(order);
                mydatabase.child("Orders").child(order.getUSER_ID()).child(order.getID()).removeValue();

            }
        });


        buyerName.setText(user.getName());
        buyerPhone.setText(user.getPhone());
        location.setText(order.getLocation());
        myItemname.setText(order.getOrderItem());
        myItemPrice.setText("Total: RM"+order.getPrice());
        myItemQuantity.setText("Quantity:"+order.getQuantity());


        return  view;
    }
}
