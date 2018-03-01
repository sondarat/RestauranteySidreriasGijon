package com.xml_sax.unionteam.restauranteysidreriasgijon;

import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DatosViewAdapter implements SimpleAdapter.ViewBinder {


    @Override
    public boolean setViewValue(View view, Object o, String s) {
        if(o instanceof Spanned){
            TextView vieww = (TextView) view;
            try{
                //vieww.setText((Spanned) o);
                //vieww.setMovementMethod(LinkMovementMethod.getInstance());
            }catch (Exception e){
                vieww.setText("N/D");
            }
            return true;
        }
        return false;
    }
}