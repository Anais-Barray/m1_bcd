package OuvertureDocument;
import java.io.*;
import java.util.*;

import org.jdom2.*;
import org.jdom2.input.*;



public class Ex4_O {
public static void main(String[] args) throws IOException, JDOMException {
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(new FileInputStream("seq1_tiny.xml"));
Element root = doc.getRootElement();
System.out.println(root.getName()); // renvoie SeqSet

List<Element> list = root.getChildren();
for (Element x : list) {
	System.out.println("---");
	System.out.println(x.getChild("TSeq_defline").getContent()); 
	System.out.println(x.getChild("TSeq_defline").getTextTrim()); 
	System.out.println("---");
}
}
}