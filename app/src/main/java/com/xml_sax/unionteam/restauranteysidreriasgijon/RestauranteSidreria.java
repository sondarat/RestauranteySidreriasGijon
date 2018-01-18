package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.net.Uri;
import java.util.HashMap;

public class RestauranteSidreria extends HashMap<String,Object>{

    public RestauranteSidreria() {
        super();
    }
    public void setNombre(String nombre){
        this.put(MapRest.NOMBRE.toString(), nombre);
    }
    public void setFoto(String foto){
        this.put(MapRest.FOTO.toString(), foto);
    }
    public void setTlf(String tlf){
        this.put(MapRest.TLF.toString(), Uri.parse("tel:" + tlf));//v2 mas abajo
        //this.put(MapRest.TLF.toString(), Uri.parse("tel:"+tlf));//Guarda el tlf listo para el intent
    }
    public void setCorreo(String correo){
        this.put(MapRest.CORREO.toString(), correo);//mirar para hacer el intent
    }
    public void setWeb(String web){
        //this.put(MapRest.WEB.toString(), Uri.parse(web));//v2 mas abajo
        this.put(MapRest.WEB.toString(), Uri.parse(web));//Guarda la web lista para el intent
    }
    public void setHorario(String horario){
        this.put(MapRest.HORARIO.toString(), horario);
    }
    public void setDescripcion(String descripcion){
        this.put(MapRest.DESCRIPCION.toString(), descripcion);
    }
    public void setDireccion(String direccion){
        this.put(MapRest.DIRECCION.toString(), direccion);
    }
    public void setCoods(String  coords){
        this.put(MapRest.COORDS.toString(), coords);//v2 mas abajo
        /*
        String[] coordenadas = coords.split(" ");
        String punto = String.format("geo:%f, %f",coordenadas[0],coordenadas[1]);
        this.put(MapRest.COORDS.toString(), Uri.parse(punto));//Guarda la coord lista para el intent
        */
    }

}
