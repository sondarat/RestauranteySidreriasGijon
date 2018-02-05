package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ismao on 29/01/2018.
 */

public class Activity_descripcion extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.para_descripcion);
        int index = (int) getIntent().getSerializableExtra("argumento");

        RestauranteSidreria restu = new RestauranteSidreria();
        restu = GestoraRestaurantes.getInstance().get(index);

        TextView descrip = findViewById(R.id.Descripcion);
        //ImageView imagen = findViewById(R.id.imagenRestauranteDialog);

        descrip.setText(restu.getDescrip());
        //imagen.setImageDrawable(Drawable.createFromPath(restu.getIma()));




        super.onCreate(savedInstanceState);
    }
}
