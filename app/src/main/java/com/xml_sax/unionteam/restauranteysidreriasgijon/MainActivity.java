package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.app.Dialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

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
        lista = this.findViewById(R.id.ListView);
        CargarXML();
        int[] to = {R.id.Nombre,R.id.Telefono,R.id.Email,R.id.Web,R.id.Direccion};
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

    public void mostrarDescripcionAvanzada(View view) {

    }

    public void LanzaIntent(View view) {
        int idBoton=view.getId();
        Intent intento;
        switch (idBoton){
            case R.id.Telefono:
                intento = new Intent(Intent.ACTION_DIAL);
                intento.setData(Uri.parse(((TextView)view).getText().toString()));
                startActivity(intento);
                break;
            case R.id.Email:
                intento = new Intent(Intent.ACTION_SEND);
                intento.setType("text/plain");
                intento.putExtra(Intent.EXTRA_EMAIL, ((TextView)view).getText().toString());
                startActivity(Intent.createChooser(intento, "Send Email"));
                break;
            case R.id.Direccion:
                int culo = lista.getPositionForView((View) view.getParent());
                intento = new Intent(Intent.ACTION_VIEW, (Uri)gestora.get(culo).get(MapRest.COORDS.toString()));
                intento.setPackage("com.google.android.apps.maps");
                if (intento.resolveActivity(getPackageManager()) != null) {
                    startActivity(intento);
                }
                break;
            case R.id.Web:
                Uri pagina = Uri.parse(((TextView)view).getText().toString());
                intento = new Intent(Intent.ACTION_VIEW, pagina);
                if (intento.resolveActivity(getPackageManager()) != null) {
                    startActivity(intento);
                }
                break;
            default:break;
        }
    }
}
