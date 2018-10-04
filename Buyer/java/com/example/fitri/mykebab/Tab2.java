package com.example.fitri.mykebab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Tab2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DatabaseReference myOrderDatabase;
    private static String USER_ID;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Tab2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Tab2 newInstance(String param1, String param2,String USER_ID) {
        Tab2 fragment = new Tab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString("USER_ID",USER_ID);
        fragment.setArguments(args);
        return fragment;
    }

    private void getBundle(Bundle bundle)
    {
        if(bundle!=null)
        {
            USER_ID = bundle.getString("USER_ID");
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
        //return inflater.inflate(R.layout.fragment_tab2, container, false);
        getBundle(getArguments());
        View view = inflater.inflate(R.layout.fragment_tab2, container,false);
        final ListView listView = (ListView) view.findViewById(R.id.OrderList);



        myOrderDatabase = FirebaseDatabase.getInstance().getReference("Orders").child(USER_ID);
        final List<Order> myOrderList = new ArrayList<>();
        myOrderDatabase.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                myOrderList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Order myorders = postSnapshot.getValue(Order.class);
                    myOrderList.add(myorders);
                    OrderedListAdapter orderedListAdapter = new OrderedListAdapter(getContext(),R.layout.myorder_card,myOrderList);
                    listView.setAdapter(orderedListAdapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        OrderedListAdapter orderedListAdapter = new OrderedListAdapter(getContext(),R.layout.myorder_card,myOrderList);
        listView.setAdapter(orderedListAdapter);





        return view;
    }





}
