package promo;
import java.util.ArrayList;
import java.util.Scanner;

public class Promotion {
	//Attributs

	private int annee;
	private ArrayList<Etudiant> Promo;

	//Constructeurs

	public Promotion(int annee) {
		this.annee = annee;
		Promo = new ArrayList<Etudiant> ();
	}

	//Methode

	public void inscrire(Etudiant a){
		if (! Promo.contains(a)){
			Promo.add(a);
		}
	}

	public double moyenneTotale(){
		double moyenneTotale = 0;

		for(Etudiant a : this.Promo){
			moyenneTotale+=a.moyenne();
		}
		return moyenneTotale;
	}

	public double moyenneGenerale(){
		double moyenneGenerale = 0;
		moyenneGenerale = moyenneTotale()/Promo.size();
		return moyenneGenerale;
	}

	public void afficheResultats(){
		for(Etudiant a : this.Promo){
			//System.out.println(a.getNometudiant() + a.ligneResultats());a.moyenne();
			System.out.println(a.ligneResultats());

		}
	}

	public String toString() {
		return "Promotion [annee=" + annee + "\n Promo=" + Promo + "\n moyenne promo=" + moyenneGenerale() +"]";
	}

	
	public Etudiant rechercheSansHomonyme(String nom){
		int i = 0;
		Etudiant e=null;
		while (i<Promo.size()) {
				if (Promo.get(i).getNometudiant() == nom){
					e = Promo.get(i);
					return e;
					}	
				i+=1;
		}
		return e;
	}
	
	public ArrayList<Etudiant> recherche(String nom){
		ArrayList<Etudiant> recherche = new ArrayList<Etudiant> ();
		for (Etudiant a : this.Promo){
			if (a.getNometudiant() == nom){
				recherche.add(a);
			}	
		}
		return recherche;
	}
	
	public ArrayList<Etudiant> admis(){
		ArrayList<Etudiant> admis = new ArrayList<Etudiant> ();
		for (Etudiant a : this.Promo){
			if (a.moyenne()>=10){
				admis.add(a);
			}
		}
		return admis;
	}
	
	public ArrayList<Etudiant> nonfranco(){
		ArrayList<Etudiant> nonfranco = new ArrayList<Etudiant> ();
		for (Etudiant a : this.Promo){
			if (a.getCodepays()==2){
				nonfranco.add(a);
			}
		}
		return nonfranco;
	}

	public double maxNote(){
		double max = 0;
		int i=0;
		while (i<Promo.size()){
			if (Promo.get(i).moyenne()>=max){
				max=Promo.get(i).moyenne();
			}
		i++;
		}
		return max;
	}
	
	public ArrayList<Etudiant> majors(){
		ArrayList<Etudiant> majors = new ArrayList<Etudiant> ();
		double max = maxNote();
		for (Etudiant a : this.Promo){
			if (a.moyenne()==max){
				majors.add(a);
			}
		}
		return majors;	
	}
	

		public int[] histogramme1(){
			int contenu [] = new int[20];
			for (int i=0; i<Promo.size(); i++){			
					int indice = (int) Math.floor(Promo.get(i).moyenne());
					contenu[indice]+=1;
			}
			return contenu;
		}

/*
		public void affHisto1(){
			for (int i=0; i<20; i++){
				int j=i+1;
				System.out.println("[" +i + "-" +j +"["  );
				

			}
			
				System.out.println("[" +19 + "-" +20 +"]"  );
		}
*/
	//Accesseurs

	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}

	
	/*
	public ArrayList<Etudiant> getPromo() {
		return Promo;
	}


	public void setPromo(ArrayList<Etudiant> promo) {
		Promo = promo;
	}

	 */


}
