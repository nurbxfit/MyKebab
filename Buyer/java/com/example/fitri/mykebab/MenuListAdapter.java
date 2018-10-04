package com.example.fitri.mykebab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
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

public class MenuListAdapter extends ArrayAdapter<OrderMenu> {

    List<OrderMenu> menus;

    public MenuListAdapter(@NonNull Context context, int resource, @NonNull List<OrderMenu> objects) {
        super(context, resource, objects);
        this.menus = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        OrderMenu menu = menus.get(position);
        View view = convertView;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.menu_item,null);

        CardView menucard = (CardView) view.findViewById(R.id.cardmenu);
        ImageView image = (ImageView) view.findViewById(R.id.menuImage);
        TextView name = (TextView) view.findViewById(R.id.menuName);
        TextView price =(TextView) view.findViewById(R.id.menuPrice);
        TextView descpt = (TextView) view.findViewById(R.id.menuDescrp);


        if(menu.getNAME().equals("Kebab"))
        {
            image.setImageResource(R.drawable.pitakebab);
        }else if (menu.getNAME().equals("Burger Goreng"))
        {
            image.setImageResource(R.drawable.burger);
        }
        else if (menu.getNAME().equals("Kebab Rolls"))
        {
            image.setImageResource(R.drawable.kebabwrap);
        }
        else if (menu.getNAME().equals("Satay Ikan"))
        {
            image.setImageResource(R.drawable.satay);
        }
        name.setText(menu.getNAME());
        price.setText("RM "+menu.getPRICE());
        descpt.setText(menu.getDESCRIPTION());


        return  view;
    }
}
