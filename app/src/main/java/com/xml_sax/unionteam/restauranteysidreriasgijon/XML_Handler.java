package com.xml_sax.unionteam.restauranteysidreriasgijon;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class XML_Handler extends DefaultHandler {
    private RestauranteSidreria restauranteActual;
    private GestoraRestaurantes gestora;
    private StringBuilder texto;

    public GestoraRestaurantes getGestora() {
        return gestora;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        gestora = GestoraRestaurantes.getInstance();
        texto = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equals("directorio")) {
            restauranteActual = new RestauranteSidreria();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        String text=texto.toString().replace("<p>","");
        text = text.replace("</p>","");
        if(this.restauranteActual!=null){
            switch (localName) {
                case "foto": restauranteActual.setFoto(text); break;
                case "nombre": restauranteActual.setNombre(text); break;
                case "telefono": restauranteActual.setTlf(text); break;
                case "correo-electronico": restauranteActual.setCorreo(text); break;
                case "web": restauranteActual.setWeb(text); break;
                case "horario": restauranteActual.setHorario(text); break;
                case "direccion": restauranteActual.setDireccion(text); break;
                case "localizacion": restauranteActual.setCoods(text); break;
                case "descripcion": restauranteActual.setDescripcion(text); break;
            }
            texto.setLength(0);
            if (localName.equals("directorio"))gestora.add(restauranteActual);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(this.restauranteActual!=null){
            texto.append(ch,start,length);
        }
    }
}
