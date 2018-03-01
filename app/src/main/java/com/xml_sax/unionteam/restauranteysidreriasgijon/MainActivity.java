package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;

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
    public void actualizarLista() {
        adaptador.notifyDataSetChanged();
        saltarNotificacion();
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

    public void saltarNotificacion(){
        NotificationManager notManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        int icono = android.R.drawable.stat_notify_chat;
        CharSequence textoTitulo = "¡Lectura terminada!";
        CharSequence textoPrincipal="Se han leido " + gestora.size() + " restaurantes y sidrerias";
        long hora = System.currentTimeMillis();
        Notification.Builder caracteristicas = new Notification.Builder(this)
                .setSmallIcon(icono)
                .setWhen(hora)
                .setContentTitle(textoTitulo)
                .setContentText(textoPrincipal);
        Notification notificacion=caracteristicas.build();
        notManager.notify(99, notificacion);
    }
    public void GuardarSidrerias(){
        try {
            final ArrayList<RestauranteSidreria> array= new ArrayList<>();
            for(RestauranteSidreria res : gestora)
            {
                RestauranteSidreria resta=new RestauranteSidreria();
                resta.put(MapRest.NOMBRE.toString(),res.get(MapRest.NOMBRE.toString()).toString());
                resta.put(MapRest.HORARIO.toString(),res.get(MapRest.HORARIO.toString()).toString());
                resta.put(MapRest.CORREO.toString(),res.get(MapRest.CORREO.toString()).toString());
                resta.put(MapRest.TLF.toString(),res.get(MapRest.TLF.toString()).toString());
                resta.put(MapRest.WEB.toString(),res.get(MapRest.WEB.toString()).toString());
                resta.put(MapRest.DESCRIPCION.toString(),res.get(MapRest.DESCRIPCION.toString()).toString());
                array.add(resta);
            }
            ObjectOutputStream escritor = new ObjectOutputStream(openFileOutput("ListaRest.dat",Context.MODE_PRIVATE));
            escritor.writeObject(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
