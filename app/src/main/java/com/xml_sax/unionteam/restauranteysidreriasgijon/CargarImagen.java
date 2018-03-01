package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class CargarImagen extends AsyncTask<String, Void, Bitmap> {

    private ImageView view;

    public CargarImagen(ImageView view) {
        this.view = view;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap imagen = null;
        try {
            URL imageUrl = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (Exception e) {

        }
        return imagen;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if(bitmap != null) view.setImageBitmap(bitmap);
    }
}
