package com.xml_sax.unionteam.restauranteysidreriasgijon;

import java.util.ArrayList;

public class GestoraRestaurantes extends ArrayList<RestauranteSidreria>{
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
}
