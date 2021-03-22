/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Administrator
 */
public class ReadFilterAgeAndSalary extends DefaultHandler{

    String xmlString1 = "";
    String xmlString2 = "";
    int age = 0;
    int salary = 0;
    String nodeName = "";
    int quality = 0;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) throws SAXException {
        xmlString2 += "<" + qName;
        for (int i = 0; i < atrbts.getLength(); i++) {
            xmlString2 += " " + atrbts.getQName(i) + "='" + atrbts.getValue(i) + "'";
        }
        xmlString2 += ">";
        nodeName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        xmlString2 += "</" + qName + ">";
        if(qName.equals("Employee")) {
            if(age >= 20 && age <= 25 && salary > 4000) {
                xmlString1 += xmlString2;
                quality ++;
            }
            xmlString2 = "";
            age = 0;
        }
        if(qName.equals("Employees")) {
            xmlString1 += xmlString2;
            System.out.println("Co " + quality + " nhan vien tuoi tu 20 - 25 va luong lon hon 4000$");
            System.out.println(xmlString1);
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String data = new String(chars, start, length);
        xmlString2 += data;
        if(nodeName.equals("Age")) {
            age = Integer.parseInt(data);
        }
        if(nodeName.equals("Salary")) {
            salary = Integer.parseInt(data);
        }
        nodeName = "";
    }
    
}