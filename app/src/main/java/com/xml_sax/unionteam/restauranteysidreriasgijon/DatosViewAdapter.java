package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.io.InputStream;
import java.net.URL;

public class DatosViewAdapter implements SimpleAdapter.ViewBinder {


    @Override
    public boolean setViewValue(View view, Object o, String s) {
        if(view instanceof ImageView){
            ImageView vieww = (ImageView) view;
            RestauranteSidreria rest = (RestauranteSidreria) o;
            try{
                InputStream is = (InputStream) new URL((String) rest.get(MapRest.FOTO.toString())).getContent();
                vieww.setImageDrawable(Drawable.createFromStream(is, "foto"));
            }catch (Exception e){
                vieww.setImageResource(R.mipmap.ico_error);
            }
            return true;
        }
        return false;
    }
}