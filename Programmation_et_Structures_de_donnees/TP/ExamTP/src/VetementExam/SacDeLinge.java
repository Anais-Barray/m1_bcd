package VetementExam;

import java.util.ArrayList;


public class SacDeLinge {



	private ArrayList<Vetement> sacDeLinge= new ArrayList<>();


	public SacDeLinge() {}


	//methodes
	public void ajouteVet(Vetement v){
		if(!sacDeLinge.contains(v)){
			sacDeLinge.add(v);
		}
	}

	public String toString() {
		return "SacDeLinge [sacDeLinge=" + sacDeLinge + "]";
	}

	public boolean aApporterALaLaverie(){
		boolean laverie=true;
		for (Vetement v : this.sacDeLinge){
			if (!v.getTypesEntretien().contains(TypeEntretien.lavageSec)){
				laverie=false;
			}
		}
		return laverie;
	}

	public ArrayList<Vetement> extraireLingeABouillir(){
		ArrayList<Vetement> lingeB = new ArrayList<> ();
		for (Vetement v : this.sacDeLinge){
			if (v.getTypesEntretien().contains(TypeEntretien.lavage90degres)){
				lingeB.add(v);
			}
		}
		return lingeB;	
	}



}

