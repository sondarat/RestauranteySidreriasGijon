package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private SimpleAdapter adaptador;
    private GestoraRestaurantes gestora;

    public SimpleAdapter getAdaptador() {
        return adaptador;
    }

    public GestoraRestaurantes getGestora() {
        return gestora;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = this.findViewById(R.id.listView);
        CargarXML();
        int[] to = {R.id.imagenRestaurante,R.id.Nombre,R.id.Email,R.id.Web,R.id.Direccion,R.id.Telefono};
        adaptador = new SimpleAdapter(this,gestora,R.layout.para_listview,MapRest.claves(),to);
        adaptador.setViewBinder(new DatosViewAdapter());
        lista.setAdapter(adaptador);
    }

    public void CargarXML(){
        CargadorXML cargador = new CargadorXML(this);
        gestora = GestoraRestaurantes.getInstance();
        cargador.execute("http://datos.gijon.es/doc/turismo/restaurantes.xml");
    }
    public void actualizarLista(){
        adaptador.notifyDataSetChanged();
    }

}
