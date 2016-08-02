package ouvertureFichier;
import java.util.ArrayList;

public class Chromosome {
	private String name;
	
	private ArrayList<Variant> ListeVariants;
	
	public Chromosome(String name) {
		this.name = name;
		ListeVariants = new ArrayList<Variant>();
	}

	public String getName() {
		return name;
	}
	
	public boolean contains(String name){
		for(Variant v: ListeVariants)
			if(v.getName() == name)
				return true;
		return false;
	}
	
	public ArrayList<Variant> getListeVariants() {
		return ListeVariants;
	}
	
	public String toString() {
		String returnstring = "Chromosome " +name +" :\n";
		for(Variant v: ListeVariants){
			returnstring += "\t"+v.toString()+"\n";
		}
		return returnstring;
	}

	public void add(Variant vTmp) {
		if(!ListeVariants.contains(vTmp))
			ListeVariants.add(vTmp);
	}
}
