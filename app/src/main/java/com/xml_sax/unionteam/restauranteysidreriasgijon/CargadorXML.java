package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.os.AsyncTask;

/**
 * Created by DamLocal on 15/01/2018.
 */

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

        }
    }
}
