/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpath;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Administrator
 */
public class ReadAllFile {

    public static void display() {
        try {
            String expression = "//Employee";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/xml/employee.xml");
            XPath xp = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xp.compile(expression)
            .evaluate(document, XPathConstants.NODESET);
            
            System.out.println("Doc toan bo file xml:");
            System.out.println("<Employees>");
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String id = xp.compile("./@id").evaluate(node);
                String name = xp.compile("./Name").evaluate(node);
                String age = xp.compile("./Age").evaluate(node);
                String salary = xp.compile("./Salary").evaluate(node);
                System.out.printf("  <Employee id='%s'>\n", id);
                System.out.printf("    <Name>%s</Name>\n", name);
                System.out.printf("    <Age>%s</Age>\n", age);
                System.out.printf("    <Salary>%s</Salary>\n", salary);
                System.out.println("  </Employee>");
            }
            System.out.println("</Employees>");
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            Logger.getLogger(ReadAllFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
