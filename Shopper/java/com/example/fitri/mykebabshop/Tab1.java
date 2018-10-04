package com.example.fitri.mykebabshop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Tab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String USER_ID;
    private DatabaseReference myOrderDatabase;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Tab1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private void getBundle(Bundle bundle)
    {
        if(bundle!=null)
        {
           // USER_ID = bundle.getString("USER_ID");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container,false);
        final ListView listView = (ListView) view.findViewById(R.id.clientorders);


        myOrderDatabase = FirebaseDatabase.getInstance().getReference().child("Orders");
        final List<Order> myOrderList = new ArrayList<>();
        myOrderDatabase.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.i("Number of user:","Data changed "+Long.toString( dataSnapshot.getChildrenCount()));

                myOrderList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String key = postSnapshot.getKey();
                    //Log.d("Testing dataSnap:","Testing0000= "+ key);
                    Users user=postSnapshot.getValue(Users.class);
                    for(DataSnapshot postparent: postSnapshot.getChildren())
                    {
                        String key2 = postparent.getKey();
                        //Log.d("Testing postparent:","Testing11111= "+ key2);
                        Order myorders = postparent.getValue(Order.class);
                        myorders.setUSER_ID(key);
                       // Log.d("Testing Adding:","Testing222222= "+ myorders.getOrderItem());
                        myOrderList.add(myorders);
                        OrderedListAdapter orderedListAdapter = new OrderedListAdapter(getContext(),R.layout.myorder_card,myOrderList,user);
                        listView.setAdapter(orderedListAdapter);

                    }
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Log.d("Testing Adding:","Testing4444444= "+ "Set Adapters");

        
        return view;
    }


}
