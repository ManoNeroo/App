package sax;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class SAXMain {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ReadAllFile());
            reader.parse(new InputSource("src/xml/employee.xml"));
            reader.setContentHandler(new ReadFilterAge());
            reader.parse(new InputSource("src/xml/employee.xml"));
            reader.setContentHandler(new ReadFilterAgeAndSalary());
            reader.parse(new InputSource("src/xml/employee.xml"));
            
        }catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(SAXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
