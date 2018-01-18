package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CargadorXML cargador = new CargadorXML();
        cargador.execute("http://datos.gijon.es/doc/turismo/restaurantes.xml");


    }
}
