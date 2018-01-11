package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.net.Uri;
import java.util.HashMap;

public class RestauranteSidreria extends HashMap<String,Object>{

    public RestauranteSidreria(String nombre, String foto, String tlf, String web, String horario, String descripcion, String direccion, String coords) {
        super();
        this.put(MapRest.NOMBRE.toString(), nombre);
        this.put(MapRest.FOTO.toString(), foto);
        this.put(MapRest.TLF.toString(), Uri.parse("tel:" + tlf));//v2 mas abajo
        this.put(MapRest.WEB.toString(), Uri.parse(web));//v2 mas abajo
        this.put(MapRest.HORARIO.toString(), horario);
        this.put(MapRest.DESCRIPCION.toString(), descripcion);
        this.put(MapRest.DIRECCION.toString(), direccion);
        this.put(MapRest.COORDS.toString(), coords);//v2 mas abajo
        /*
        String[] coordenadas = coords.split(" ");
        String punto = String.format("geo:%f, %f",coordenadas[0],coordenadas[1]);
        this.put(MapRest.COORDS, Uri.parse(punto));//Guarda la coord lista para el intent
        this.put(MapRest.TLF, Uri.parse("tel:"+tlf));//Guarda el tlf listo para el intent
        this.put(MapRest.WEB, Uri.parse(web));//Guarda la web lista para el intent
        */
    }
}
