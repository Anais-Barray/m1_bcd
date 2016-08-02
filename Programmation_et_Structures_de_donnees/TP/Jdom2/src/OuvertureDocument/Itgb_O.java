package OuvertureDocument;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Itgb_O {

	public static void main(String[] args) throws IOException, JDOMException {
		SAXBuilder builder = new SAXBuilder();//grammaire
		Document doc = builder.build(new FileInputStream("itgb_human_mrna.xml"));//fichier de donnees Document
		Element root = doc.getRootElement();//recup racine Tseqset
		System.out.println(root.getName()); // renvoie SeqSet
		List<Element> list = root.getChildren();
	
		int sumLength= 0;
		int sizeTSEQSET = list.size();

		for (Element x : list) {
			String n = (x.getChildText("TSeq_length"));
			int length = Integer.parseInt(n);
			sumLength += length; 
		}
		System.out.println("La longueur moyenne des séquences est : " + sumLength/sizeTSEQSET + "pb");
	}

}