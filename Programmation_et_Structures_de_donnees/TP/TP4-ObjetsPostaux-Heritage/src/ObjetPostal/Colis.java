package ObjetPostal;

public class Colis extends ObjetPostal {


	private String declarationcontenu;
	private double valeurdeclaree;
	
	public Colis(String origine, String destination, int codepostal,
			double poids, double volume, int tauxrecom,
			String declarationcontenu, double valeurdeclaree) {
		super(origine, destination, codepostal, poids, volume, tauxrecom);
		this.declarationcontenu = declarationcontenu;
		this.valeurdeclaree = valeurdeclaree;
	}

	public String toString() {
		return "Colis [declarationcontenu=" + declarationcontenu
				+ ", valeurdeclaree=" + valeurdeclaree+"]" +super.toString();
	}
	
	public double tarifAffranchissement(){
		double tarifA=super.tarifAffranchissement()+1.5;
		if (getVolume()>1/8){
			tarifA=tarifA+3;
		}		
		return tarifA;
	}
	
	public double tarifRemboursement(){
		double tarifR=0;
		if (getTauxrecom()==1){
			tarifR=tarifR+0.1*valeurdeclaree;
		}
		if (getTauxrecom()==2){
			tarifR=tarifR+0.5*valeurdeclaree;
		}
		return tarifR;
	}
	
	public String getDeclarationcontenu() {
		return declarationcontenu;
	}

	public void setDeclarationcontenu(String declarationcontenu) {
		this.declarationcontenu = declarationcontenu;
	}

	public double getValeurdeclaree() {
		return valeurdeclaree;
	}

	public void setValeurdeclaree(double valeurdeclaree) {
		this.valeurdeclaree = valeurdeclaree;
	}

}
