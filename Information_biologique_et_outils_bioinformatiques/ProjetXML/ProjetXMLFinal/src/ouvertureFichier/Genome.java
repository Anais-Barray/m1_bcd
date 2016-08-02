package ouvertureFichier;
import java.util.ArrayList;

public class Genome {
	private ArrayList<Chromosome> genome;

	public Genome() {
		genome = new ArrayList<Chromosome>();
	}

	public void add(Chromosome chr){
		if(!this.contains(chr.getName()))
			genome.add(chr);
	}
	
	public boolean contains(String nom) {
		for(Chromosome c : genome)
			if(c.getName().equals(nom))
				return true;
		return false;
	}
	
	public Chromosome getChromosome(String chr){
		for(Chromosome c: genome)
			if (c.getName().equals(chr))
				return c;
		return null;
	}
	
	public String toString() {
		String returnstring = "Genome : \n";
		for(Chromosome c : genome)
			returnstring += c.toString();
		return returnstring;	
	}

}
