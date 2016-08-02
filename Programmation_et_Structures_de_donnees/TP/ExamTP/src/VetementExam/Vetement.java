package VetementExam;
import java.util.ArrayList;




public abstract class Vetement {
	private String denomination = "denomination inconnue";
	private String marque = "marque inconnue";
	private double pourcentageFibreNaturelle;


	private ArrayList <TypeEntretien> typesEntretien = new ArrayList<>();


	public Vetement() {}


	public Vetement(String denomination, String marque,
			double pourcentageFibreNaturelle, double pourcentageFibreSynthetique) {
		this.denomination = denomination;
		this.marque = marque;
		this.pourcentageFibreNaturelle = pourcentageFibreNaturelle;
		setPourcentageFibreSynthetique(pourcentageFibreSynthetique);
	}


	public boolean aLabelNaturel(){
		return this.pourcentageFibreNaturelle>= 95;
	}



	public String toString(){
		return " denomination :" + this.denomination+" marque : "+this.marque+", "+
				this.pourcentageFibreNaturelle +" % Fibres Naturelles "+
				this.getPourcentageFibreSynthetique()+" % Fibres Synthétiques "+
				"Type(s) d'entretien : "+ this.typesEntretien + ". Usage : " +usage();
	}




	public boolean affecteComposition(double fn, double fs){
		if (fs >=0 && fn >= 0 && fs+fn == 100){
			this.pourcentageFibreNaturelle = fn;
			setPourcentageFibreSynthetique(fs);
			return true;
		}

		else {
			System.out.println("erreur sur la composition");
			return false;}
	}




	//Q.3
	public void ajouteTE(TypeEntretien te){
		if(!typesEntretien.contains(te)){
			if (te==TypeEntretien.secheLingeInterdit)
				for (TypeEntretien te2 : this.typesEntretien){
					if (te2==TypeEntretien.lavage60degres||te2==TypeEntretien.lavage90degres){
						System.out.println("types d'entretien incompatibles");
						return;
					}
				}
			if (te==TypeEntretien.lavage60degres||te==TypeEntretien.lavage90degres)
				for (TypeEntretien te2 : this.typesEntretien){
					if (te2==TypeEntretien.secheLingeInterdit){
						System.out.println("types d'entretien incompatibles");
						return;
					}
				}
			typesEntretien.add(te);
		}
	}

	public void supprimeTE(TypeEntretien te){
		if(typesEntretien.contains(te)){
			typesEntretien.remove(te);
		}
	}

	//Q6
	public abstract String usage();
	//Il n'est pas possible d'implémenter une méthode abstraite dans une classe non abstraite
	//Si l'on change en classe abstraite, il n'est pas possible d'instancier une classe abstraite dans le 'main';
	//Les mettre en commentaire pour que le programme fonctionne, ou les redéfinir en VetementSport ou TenueTravail;
	
	//Accesseurs

	public String getDenomination() {
		return denomination;
	}


	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPourcentageFibreNaturelle() {
		return pourcentageFibreNaturelle;
	}


	public void setPourcentageFibreNaturelle(double pourcentageFibreNaturelle) {
		this.pourcentageFibreNaturelle = pourcentageFibreNaturelle;
	}


	public double getPourcentageFibreSynthetique() {
		return 100-pourcentageFibreNaturelle;
	}


	public void setPourcentageFibreSynthetique(double pourcentageFibreSynthetique) {
		if (pourcentageFibreSynthetique == 100-pourcentageFibreNaturelle){
			this.pourcentageFibreNaturelle=100-pourcentageFibreSynthetique;
		}
	}


	public ArrayList<TypeEntretien> getTypesEntretien() {
		return typesEntretien;
	}


	public void setTypesEntretien(ArrayList<TypeEntretien> typesEntretien) {
		this.typesEntretien = typesEntretien;
	}


}