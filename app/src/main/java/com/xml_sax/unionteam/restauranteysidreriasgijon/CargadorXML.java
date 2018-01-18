package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.os.AsyncTask;

public class CargadorXML extends AsyncTask<String,Integer,Boolean> {
    private GestoraRestaurantes gestora;

    @Override
    protected Boolean doInBackground(String... strings) {
        RestauranteSaxParse parseador = new RestauranteSaxParse(strings[0]);
        gestora = parseador.parse();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        for (int i = 0; i < gestora.size(); i++) {
            gestora.get(i).get(MapRest.NOMBRE.toString());
            gestora.get(i).get(MapRest.FOTO.toString());
            gestora.get(i).get(MapRest.TLF.toString());
            gestora.get(i).get(MapRest.CORREO.toString());
            gestora.get(i).get(MapRest.WEB.toString());
            gestora.get(i).get(MapRest.HORARIO.toString());
            gestora.get(i).get(MapRest.DESCRIPCION.toString());
            gestora.get(i).get(MapRest.DIRECCION.toString());
            gestora.get(i).get(MapRest.COORDS.toString());
        }
    }
}
