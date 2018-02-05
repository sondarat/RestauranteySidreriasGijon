package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

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
        this.put(MapRest.TLF.toString(), "tel:"+tlf.replace("\n",""));
    }
    public void setCorreo(String correo){
        this.put(MapRest.CORREO.toString(), correo.replace("\n",""));
    }
    public void setWeb(String web){
        //this.put(MapRest.WEB.toString(), web);//v2 mas abajo
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
        coords = coords.replace("\n","");
        while(coords.startsWith(" "))coords=coords.substring(1);
        if (!coords.equalsIgnoreCase("")){
            String[] coordenadas = coords.split(" ");
            Uri punto = Uri.parse("geo:"+coordenadas[0]+","+coordenadas[1]+"?q=<"+coordenadas[0]+">,<"+coordenadas[1]+">"+"("+this.get(MapRest.NOMBRE.toString())+")");
            this.put(MapRest.COORDS.toString(), punto);
        }
    }

    @Override
    public boolean equals(Object o) {
        RestauranteSidreria rest = (RestauranteSidreria) o;
        return this.get(MapRest.NOMBRE.toString()).equals(rest.get(MapRest.NOMBRE.toString()));
    }
public String getDescrip (){

   return  (String) this.get(MapRest.DESCRIPCION.toString());

}
    public String getIma (){

        return  (String) this.get(MapRest.FOTO.toString());

    }
