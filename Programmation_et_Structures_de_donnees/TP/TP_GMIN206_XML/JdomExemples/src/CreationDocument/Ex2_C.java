package CreationDocument;
import java.io.*; 
import org.jdom2.*; 
import org.jdom2.output.*; 


public class Ex2_C { 
	
	 static Element racine = new Element("SeqSet");
	 static Document document = new Document(racine);
	 
	 static void affiche()
	 {
	    try
	    {
	    	 XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	         sortie.output(document, System.out);
	      }
	      catch (java.io.IOException e){}
	   }
	 
	 static void enregistre(String fichier)
	 {
	    try
	    {
	       //On utilise ici un affichage classique avec getPrettyFormat()
	       XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	       //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
	       //avec en argument le nom du fichier pour effectuer la sérialisation.
	       sortie.output(document, new FileOutputStream(fichier));
	    }
	    catch (java.io.IOException e){}
	 } 
	 public static void main(String[] args)
	   {
		 Element sequence = new Element("sequence");
	      racine.addContent(sequence);
	      // accNum == access Number
	      Attribute accNum = new Attribute("accNum","BC074923");
	      Attribute provenance = new Attribute("provenance","GENBANK");
	      sequence.setAttribute(accNum);
	      sequence.setAttribute(provenance);
	      Element organism = new Element("organism");
	      organism.setText("Homo sapiens");
	      Element geneName = new Element("geneName");
	      geneName.setText("SRY");
	      Element biomol = new Element("biomol");
	      biomol.setText("MRNA");
	      Element seqNuc = new Element("seqNuc");
	      seqNuc.setText("cacctttcaattttgtcgca");
	      sequence.addContent(organism);
	      sequence.addContent(geneName);
	      sequence.addContent(biomol);
	      sequence.addContent(seqNuc);
	     
	      affiche();
	      enregistre("Exercice2.xml");
	   }

}
