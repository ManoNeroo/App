/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadAllFile extends DefaultHandler{

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nEnd Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        System.out.print("<" + qName );
        for (int i = 0; i < atrbts.getLength(); i++) {
            System.out.print(" " + atrbts.getQName(i) + "='" + atrbts.getValue(i) + "'");
        }
        System.out.print(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</" + qName + ">" );
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String data = new String(chars, start, length);
        System.out.print(data);
    }
    
    
    
}
