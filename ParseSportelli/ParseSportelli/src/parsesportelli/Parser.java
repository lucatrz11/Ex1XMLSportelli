/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsesportelli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 *
 * @author trezzi_luca
 */
public class Parser {

    private List sportelli;

    public Parser() {
        sportelli = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        NodeList listnode;
        int conta = 0;
        Sportello sportello;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "tr"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                listnode = root.getElementsByTagName("td");
                if (listnode.getLength() == 4) {
                    if (conta == 0) {
                        conta++;
                    } else if (conta != 0) {
                        for (int j = 0; j < listnode.getLength(); j++) {
                            element = (Element) listnode.item(i);
                            if (getTextValue(element, "td") == "DISCIPLINA") {
                                
                            }
                        }
                    }
                }

                //sportello = getLink(element);
                //sportelli.add(sportello);
            }
        }
        return sportelli;
    }

//    private Link getLink(Element element) {
//        Link link;
//        String l=element.getAttribute("href");
//        
//        String t = element.getFirstChild().getNodeValue();
//        /*String titolo = getTextValue(element, "titolo");
//        String autore = getTextValue(element, "autore");
//        float prezzo = getFloatValue(element, "prezzo");*/
//        link = new Link(t,l);
//        return link;
//    }
    private String getTextValue(Element element, String tag) {
        String value = null;
        NodeList node;

        node = element.getElementsByTagName(tag);
        if (node != null && node.getLength() > 0) {
            value = node.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }

    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }
}
