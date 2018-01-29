package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
        int[] to = {R.id.Nombre,R.id.imagenRestaurante,R.id.Telefono,R.id.Email,R.id.Web,R.id.Direccion};
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
        saltarNotificacion();
    }

    public void saltarNotificacion(){
        NotificationManager notManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        int icono = android.R.drawable.stat_notify_chat;
        CharSequence textoTitulo = "¡Atención!";
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
                intento = new Intent(Intent.ACTION_SENDTO);
                intento.setData(Uri.parse("mailto:"+((TextView)view).getText().toString()));
                startActivity(intento);
                break;
            default:break;
        }
    }
}
