package ouvertureFichier;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class main {


	public static void main(String[] args) throws IOException, JDOMException {

		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new FileInputStream("gene_result(3).xml"));
		Element root = doc.getRootElement();
		System.out.println(root.getName()); // renvoie SeqSet

		List<Element> list = root.getChildren();
		Genome genome1 = new Genome();
		Chromosome cTmp = null;
		String currentChromosome = "";
		Variant vTmp = null;
		String s = null;

		for (Element g : list){
			List<Element> list2 = g.getChildren();
			for (Element h : list2){
				List<Element> list3 = h.getChildren();
				for (Element i : list3){
					List<Element> list4 = i.getChildren();
					for (Element j : list4){
						List<Element> list5 = j.getChildren();
						for (Element l : list5){
							List<Element> list6 = l.getChildren();
							for (Element m : list6){
								if (m.getName()=="SubSource_name"){
									currentChromosome = m.getText();
								}
							}
						}
						if(currentChromosome != ""){
							if(!genome1.contains(currentChromosome))
								genome1.add(new Chromosome(currentChromosome));
								if (j.getName() == "Gene-ref_locus"){
									s = j.getText();
									genome1.getChromosome(currentChromosome).add(new Variant(s));
								}
						}
					}
				}
			}
		}
		System.out.println(genome1);
	}
}