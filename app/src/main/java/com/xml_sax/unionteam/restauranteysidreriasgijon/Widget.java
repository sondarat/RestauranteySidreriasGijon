package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;

/**
 * Implementation of App Widget functionality.
 */
public class Widget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        Intent intent= new Intent(context, LanzarDesdeWidget.class);
        /*PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId,intent,
                PendingIntent.FLAG_UPDATE_CURRENT);*/

        //GestoraRestaurantes resta=leer();
        //Collections.shuffle(resta);
        //RestauranteSidreria cogido=resta.get(0);
        //views.setOnClickPendingIntent(R.id.aqui, pendingIntent);

       //CharSequence nombre= (CharSequence) cogido.get(MapRest.NOMBRE.toString());
       //CharSequence horario= (CharSequence) cogido.get(MapRest.HORARIO.toString());

        //views.setTextViewText(R.id.aquiVaNombreRestaurante,nombre);
       // views.setTextViewText(R.id.aquiVaHorarioRestaurante,horario);



        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public GestoraRestaurantes leer(){
        File fichero= new File("ListaRest.dat");
        try {
            //ObjectInputStream lector= new ObjectInputStream(ope("fichTest_mem_int.txt"));
            //return  (GestoraRestaurantes) lector.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

