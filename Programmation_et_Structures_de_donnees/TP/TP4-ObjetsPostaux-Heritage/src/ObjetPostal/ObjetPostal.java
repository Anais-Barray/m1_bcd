package ObjetPostal;

public abstract class ObjetPostal {

	private String origine;
	private String destination;
	private int codepostal;
	private double poids;
	private double volume;
	private int tauxrecom;



	public ObjetPostal(String origine, String destination, int codepostal,
			double poids, double volume, int tauxrecom) {

		this.origine = origine;
		this.destination = destination;
		this.codepostal = codepostal;
		this.poids = poids;
		this.volume = volume;
		this.setTauxrecom(tauxrecom);
	}



	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public int getTauxrecom() {
		return tauxrecom;
	}

	public void setTauxrecom(int tauxrecom) {
		if (tauxrecom>3 || tauxrecom<1) {
			System.out.println("erreur");
		}
		else 
			this.tauxrecom = tauxrecom;	}

	
	public String toString() {
		return "ObjetPostal [origine=" + origine + ", destination="
				+ destination + ", codepostal=" + codepostal + ", poids="
				+ poids + ", volume=" + volume + ", tauxrecom=" + tauxrecom
				+ ", taux affranchissement=" + tarifAffranchissement() + ", taux remboursement=" + tarifRemboursement() +"]";
	}

	public double tarifAffranchissement(){
		double tarifA=0.5;
		if (tauxrecom==1){
			tarifA=tarifA+0.5;
		}

		if (tauxrecom==2){
			tarifA=tarifA+1.5;
		}
		return tarifA;
	}
	public abstract double tarifRemboursement();
	
}
