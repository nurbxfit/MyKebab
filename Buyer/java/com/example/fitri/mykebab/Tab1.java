package com.example.fitri.mykebab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Tab1 extends Fragment {
    private String username;
    private String userphone;
    private String USER_ID;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Bundle UserBundle;


    public Tab1() {
        UserBundle = getArguments();
        username = "Nur";
        userphone="0192887187";
    }


    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String username, String userphone,String USER_ID) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString("NAME", username);
        args.putString("PHONE", userphone);
        args.putString("USER_ID",USER_ID);
        fragment.setArguments(args);
        return fragment;
    }

    private void getBundle(Bundle bundle)
    {
        if(bundle!=null)
        {
            Log.d("TESTGETBUNDLE", "TESTINGGGGGG");
            username = bundle.getString("NAME");
            userphone = bundle.getString("PHONE");
            UserBundle = bundle;
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final List<OrderMenu> menus = new ArrayList<OrderMenu>();
        getBundle(getArguments());

        OrderMenu Kebab = new OrderMenu("Kebab","3.50","Kebab Pita Sedap");
        OrderMenu burger = new OrderMenu("Burger Goreng","3.00","Burger Goreng Sedap");
        OrderMenu rolls = new OrderMenu("Kebab Rolls","4.50","Kebab Rolls Sedap");
        OrderMenu satay = new OrderMenu("Satay Ikan","0.30","Satay Ikan Ori");
        menus.add(Kebab);
        menus.add(burger);
        menus.add(rolls);
        menus.add(satay);

        View view = inflater.inflate(R.layout.fragment_tab1,container,false);
        TextView nameview = (TextView) view.findViewById(R.id.username);
        nameview.setText(username);

        TextView phoneview = (TextView) view.findViewById(R.id.userphone);
        phoneview.setText(userphone);

        ListView listView = (ListView) view.findViewById(R.id.list_test);
        MenuListAdapter menuMenuListAdapter = new MenuListAdapter(getContext(),R.layout.menu_item,menus);
        listView.setAdapter(menuMenuListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"Item: "+ menus.get(i).getNAME(),Toast.LENGTH_SHORT).show();
                Intent detailsIntent = new Intent(getContext(),DetailOrder.class);
                UserBundle.putString("OITEM",menus.get(i).getNAME());
                UserBundle.putString("OPRICE",menus.get(i).getPRICE());
                detailsIntent.putExtras(UserBundle);
                startActivity(detailsIntent);

            }
        });

        return view;
    }





}
