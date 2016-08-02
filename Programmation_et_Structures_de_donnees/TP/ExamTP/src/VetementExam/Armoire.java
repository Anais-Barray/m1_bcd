package VetementExam;

import java.util.ArrayList;

public class Armoire {
// question 5
	private ArrayList <Vetement> contenu ;

	public Armoire() {
		contenu = new ArrayList<Vetement>();
	}
	
	public void ajoute(Vetement v){
		if (! this.contenu.contains(v))
			this.contenu.add(v);	
	}
	
	public int nbVetementsNaturels(){
		int n = 0;
		for(Vetement v :this.contenu){
			if (v.aLabelNaturel())
				n++;}
			return n;
		}
		
	
	public ArrayList <Vetement> rechercheMarque(String m){
		ArrayList<Vetement> lv = new ArrayList<Vetement>();
		for (Vetement v : this.contenu){
			if (v.getMarque().equals(m))
				lv.add(v);	
		}
		return lv;
		}
	
	public String toString(){
		String st="Armoire : \n";
		for(Vetement v : this.contenu)
			st+= v.toString()+"\n";
		return st;
	}
	
	}
	