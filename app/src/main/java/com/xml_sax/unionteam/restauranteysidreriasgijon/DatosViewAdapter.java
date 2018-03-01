package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.graphics.Color;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DatosViewAdapter implements SimpleAdapter.ViewBinder {


    @Override
    public boolean setViewValue(View view, Object o, String s) {
        if (view.getId() == R.id.Web){
            TextView vieww = (TextView) view;
            try{
                if(o==null) vieww.setText("");
                else vieww.setText("Web");
                vieww.setTextColor(Color.BLUE);
            }catch (Exception e){
                vieww.setText("N/D");
            }
            return true;
        }
        if (view.getId() == R.id.Email){
            TextView vieww = (TextView) view;
            try{
                if(((String)o).equalsIgnoreCase("")) vieww.setText("");
                else vieww.setText("Correo");
                vieww.setTextColor(Color.GREEN);
            }catch (Exception e){
                vieww.setText("N/D");
            }
            return true;
        }
        return false;
    }
}