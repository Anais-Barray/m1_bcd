package OuvertureDocument;

import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;


public class Ex2_O {
public static void main(String[] args) throws IOException, JDOMException {
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(new FileInputStream("Exercice2.xml"));
Element root = doc.getRootElement();
System.out.println(root.getName()); // renvoie SeqSet
System.out.println(root.getAttributeValue("accNum")); 
System.out.println(root.getAttributeValue("provenance")); 
System.out.println(root.getChildren()); // java.util.List de sequences
	}

}