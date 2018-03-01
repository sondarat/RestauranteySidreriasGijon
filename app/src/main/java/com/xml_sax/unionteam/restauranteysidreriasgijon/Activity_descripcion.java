package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_descripcion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.para_descripcion);
        int index = (int) getIntent().getSerializableExtra("argumento");

        RestauranteSidreria restu;
        restu = GestoraRestaurantes.getInstance().get(index);

        TextView descrip = findViewById(R.id.Descripcion);
        ImageView imagen = findViewById(R.id.imagenRestauranteDialog);
        //Bitmap ima = null;

        descrip.setText(restu.getDescrip());
        CargarImagen cargadora = new CargarImagen(imagen);
        cargadora.execute(restu.getIma());
        //imagen.setImageResource(R.mipmap.ico_error);




        super.onCreate(savedInstanceState);
    }
}
