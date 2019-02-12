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
        int j = 0;

        Sportello sportello;
        boolean trovato = false;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "tr"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                String contenuto = element.getFirstChild().getTextContent();
                if (contenuto != null) {
                    if (contenuto.equals("N.B. Gli orari degli incontri potrebbero anche essere modificati in accordo con il docente/studente.")) {
                        trovato = false;
                    }
                    if (contenuto.equals("DISCIPLINA")) {
                        sportelli.add(element);
                        trovato = true;
                        j++;
                    } else if (element.getChildNodes().getLength() == 4 && trovato == true) {
                        sportelli.add(element);
                        j++;
                    }
                } else {
                    trovato = false;
                }
            }

        }
        return sportelli;
    }

    public String toCSV(List testo) {

        List lista1 = new ArrayList();

        lista1 = getText((NodeList) testo.get(0), "td");

        String stringa = "";

        stringa += lista1.get(0) + ";";
        stringa += lista1.get(1) + ";";
        stringa += lista1.get(2) + ";";
        stringa += lista1.get(3) + "\r\n";

        List lista2 = new ArrayList();
        for (int i = 1; i < testo.size() - 1; i = i + 2) {

            lista1 = getText((NodeList) testo.get(i), "td");
            lista2 = getText((NodeList) testo.get(i + 1), "td");

            stringa += lista1.get(0) + " " + lista2.get(0) + ";";
            stringa += lista1.get(1) + " " + lista2.get(1) + ";";
            stringa += lista1.get(2) + " " + lista2.get(2) + ";";
            stringa += lista1.get(3) + " " + lista2.get(3) + "\n";
        }

        return stringa;
    }

    public List getText(NodeList nodelist, String tag) {
        List testo = new ArrayList();

        if (nodelist != null && nodelist.getLength() > 0) {
            testo.add(nodelist.item(0).getTextContent());
            testo.add(nodelist.item(1).getTextContent());
            testo.add(nodelist.item(2).getTextContent());
            testo.add(nodelist.item(3).getTextContent());
        }
        return testo;
    }
}
