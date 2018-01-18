package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

public class DatosViewAdapter implements SimpleAdapter.ViewBinder {


    @Override
    public boolean setViewValue(View view, Object o, String s) {
        if(o instanceof RestauranteSidreria){
            ImageView vieww = (ImageView) view;
            RestauranteSidreria rest = (RestauranteSidreria) o;
            vieww.setImageResource(R.drawable.ic_launcher_background);
            return true;
        }
        return false;
    }
}