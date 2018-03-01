package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.os.AsyncTask;

public class CargadorXML extends AsyncTask<String,Integer,Boolean> {
    private GestoraRestaurantes gestora;
    private MainActivity activ;

    public CargadorXML(MainActivity activ){
        this.activ=activ;
    }
    @Override
    protected Boolean doInBackground(String... strings) {
        RestauranteSaxParse parseador = new RestauranteSaxParse(strings[0]);
        gestora=GestoraRestaurantes.getInstance();
        gestora = parseador.parse();
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        activ.actualizarLista();
        activ.GuardarSidrerias();
    }
}
