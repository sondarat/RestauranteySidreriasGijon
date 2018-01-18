package com.xml_sax.unionteam.restauranteysidreriasgijon;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by DamLocal on 15/01/2018.
 */

public class RestauranteSaxParse{

    private URL UrlRestaurantes;

    public RestauranteSaxParse(String urlRestaurantes) {
        try{
            this.UrlRestaurantes = new URL(urlRestaurantes);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public GestoraRestaurantes parse(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = factory.newSAXParser();
            XML_Handler handler = new XML_Handler();
            parser.parse(this.getInputStream(), handler);
            return handler.getGestora();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getInputStream(){
       try
       {
           return UrlRestaurantes.openConnection().getInputStream();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
