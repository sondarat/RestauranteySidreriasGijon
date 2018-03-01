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

/**
 * Implementation of App Widget functionality.
 */
public class Widget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        Intent intent= new Intent(context, LanzarDesdeWidget.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, appWidgetId,intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

       /* int numero=(int)(Math.random()*resta.size());
        RestauranteSidreria cogido=resta.get(numero);
        views.setOnClickPendingIntent(R.id.aqui, pendingIntent);

       CharSequence nombre= (CharSequence) cogido.get(MapRest.NOMBRE);
        views.setTextViewText(R.id.aquiVaNombreRestaurante,nombre);

        CharSequence horario= (CharSequence) cogido.get(MapRest.HORARIO);
        views.setTextViewText(R.id.aquiVaHorarioRestaurante,horario);

        Bitmap foto= (Bitmap) cogido.get(MapRest.FOTO);
        views.setImageViewBitmap(R.id.aquiVaImagenRestaurante,foto);*/

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
}

