package com.xml_sax.unionteam.restauranteysidreriasgijon;

public enum MapRest {
    NOMBRE,
    FOTO,
    TLF,
    CORREO,
    WEB,
    DIRECCION,
    HORARIO,
    DESCRIPCION,
    COORDS;
    public static String[] claves(){
        MapRest[] claves=MapRest.values();
        int numero=claves.length;
        String[] devolver=new String[numero];
        for (int i=0;i<numero;i++){
            devolver[i]=claves[i].toString();
        }
        return devolver;
    }
}
