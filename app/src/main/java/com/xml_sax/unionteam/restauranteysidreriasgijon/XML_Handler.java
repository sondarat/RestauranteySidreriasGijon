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

        gestora= new GestoraRestaurantes();
    texto=new StringBuilder();

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
        String text=texto.toString();
        if(this.restauranteActual!=null){
            if(localName.equals("foto")){
                restauranteActual.setFoto(text);
            }else if(localName.equals("nombre")){
                restauranteActual.setNombre(text);
            }else if(localName.equals("telefono")) {
                restauranteActual.setTlf(text);
            }else if(localName.equals("correo-electronico")){
                restauranteActual.setCorreo(text);
            }else if(localName.equals("web")){
                restauranteActual.setWeb(text);
            }else if(localName.equals("horario")){
                restauranteActual.setHorario(text);
            }else if(localName.equals("direccion")){
                restauranteActual.setDireccion(text);
            }else if(localName.equals("localizacion")){
                restauranteActual.setCoods(text);
            }else if(localName.equals("descripcion")){
            restauranteActual.setDescripcion(text);
        }
            gestora.add(restauranteActual);
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
