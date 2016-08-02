package CreationDocument;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.DocType;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;
import java.io.*;

public class Ex3_C {

   public static void main(String[] args) {
   
    Element racine = new Element("Seq_Set");	
  	      
    for (Integer i = 1; i <= 25; i++) {
      Element sequence = new Element("Sequence");
      sequence.setAttribute("num", String.valueOf(i));
      Integer num = i;
      sequence.setText("hs"+num.toString());
      racine.addContent(sequence);
    }

    // associe une dtd au document construit
    // sans evaluation de la validite
    DocType validType = new DocType("Seq_Set", "sequence.dtd");
    Document doc = new Document(racine, validType);
    // sauvegarde dans un fichier et affichage a l ecran 
    try {
      FileOutputStream out = new FileOutputStream("sequencesAvecDTD.xml");
      XMLOutputter serializer = new XMLOutputter(Format.getPrettyFormat());
      serializer.output(doc, out);
      serializer.output(doc, System.out);
      
      out.flush();	
      out.close();
    }
    catch (IOException e) {
      System.err.println(e);
    }

  }

}
