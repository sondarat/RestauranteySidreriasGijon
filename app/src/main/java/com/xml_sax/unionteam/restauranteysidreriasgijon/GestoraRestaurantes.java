package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class GestoraRestaurantes extends ArrayList<RestauranteSidreria>{

    public static GestoraRestaurantes instance = null;
    protected GestoraRestaurantes(){}

    public static GestoraRestaurantes getInstance(){
        if(instance==null) instance = new GestoraRestaurantes();
        return instance;
    }

    public String[] getInfoRest(){
        int numero=this.size();
        String[] nombres=new String[numero];
        for (int pos=0;pos<numero;pos++){
            RestauranteSidreria uno=this.get(pos);
            nombres[pos]=(String)uno.get(MapRest.NOMBRE.toString());
        }
        return nombres;
    }
}

