package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity{

    private ListView lista;
    private SimpleAdapter adaptador;
    private  GestoraRestaurantes gestora;

    public SimpleAdapter getAdaptador() {
        return adaptador;
    }

    public  GestoraRestaurantes getGestora() {
        return gestora;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = this.findViewById(R.id.listView);
        CargarXML();
        int[] to = {R.id.Nombre,R.id.imagenRestaurante,R.id.Telefono,R.id.Email,R.id.Web,R.id.Direccion};
        adaptador = new SimpleAdapter(this,gestora,R.layout.para_listview,MapRest.claves(),to);
        adaptador.setViewBinder(new DatosViewAdapter());
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int index = i;
                Intent intent = new Intent(MainActivity.this, Activity_descripcion.class);
                intent.putExtra("argumento", index);
                startActivity(intent);

            }
        });


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

