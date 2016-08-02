package cc;

public class Vetement {
private String denomination = "denomination inconnue";
private String marque = "marque inconnue";
private double pourcentageFibreNaturelle, pourcentageFibreSynthetique;
                                                                                                                                                                                 

	public Vetement() {}


	public Vetement(String denomination, String marque,
			double pourcentageFibreNaturelle, double pourcentageFibreSynthetique) {
		this.denomination = denomination;
		this.marque = marque;
		this.pourcentageFibreNaturelle = pourcentageFibreNaturelle;
		this.pourcentageFibreSynthetique = pourcentageFibreSynthetique;
	}
	
	
	public boolean aLabelNaturel(){
		return this.pourcentageFibreNaturelle>= 95;
	}

	
	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String toString(){
		return this.denomination+" - "+this.marque+", "+
	           this.pourcentageFibreNaturelle +" % Fibres Naturelles "+
			   this.pourcentageFibreSynthetique+" % Fibres Synthétiques";
	}
	
	
	// question 2
	public boolean affecteComposition(double fn, double fs){
		if (fs >=0 && fn >= 0 && fs+fn == 100){
		this.pourcentageFibreNaturelle = fn;
		this.pourcentageFibreSynthetique = fs;
		return true;
		}
		
		else {
			System.out.println("erreur sur la composition");
			return false;}
	}
}
