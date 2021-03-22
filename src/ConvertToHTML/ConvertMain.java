/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConvertToHTML;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author chungld-hanam
 */
public class ConvertMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Bắt đầu load tài liệu DOM
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            
            DocumentBuilder builder=factory.newDocumentBuilder();
            
            Document doc= builder.parse("src/xml/Catalog.xml");
            //Load xong
            
            //Bắt đầu transform
            DOMSource source=new DOMSource(doc);
            
            TransformerFactory tranf=TransformerFactory.newInstance();
            
            Transformer tran=tranf.newTransformer(new StreamSource("src/xml/Catalog.xsl"));
            
            //out ra cửa sổ
           // StreamResult result= new StreamResult(System.out);
            
            //output ra têp jtin
            StreamResult result= new StreamResult(new File("src/xml/Catalog.html"));
            
            tran.transform(source, result);
            //Transform xong
            
            System.out.println("Thành công");
            
        } catch (ParserConfigurationException | SAXException | IOException | TransformerConfigurationException ex) {
            Logger.getLogger(ConvertMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ConvertMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
