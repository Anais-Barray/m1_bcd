package OuvertureDocument;

import java.io.*;
import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;


public class Ex3_O {
public static void main(String[] args) throws IOException, JDOMException {
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(new FileInputStream("Exercice2.xml"));
Element root = doc.getRootElement();
System.out.println(root.getName()); // renvoie SeqSet

List<Element> list = root.getChildren();
for (Element x : list) {
	System.out.println(x.getAttributeValue("accNum")); 
	System.out.println(x.getAttributeValue("provenance")); 
}
}
}