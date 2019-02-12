/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsesportelli;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author trezzi_luca
 */
public class ParseSportelli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        List sportello = null;
        Parser dom = new Parser();
        mioFile mioF = new mioFile();

        try {
            sportello = dom.parseDocument("sportelliDidattici.xml");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        String s = dom.toCSV(sportello);
        mioF.SalvaSuFile(s);
//
//        Iterator iterator = sportello.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }
    }

}
