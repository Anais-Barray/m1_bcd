package ObjetPostal;

public class LettreUrgente extends Lettre {

	public LettreUrgente(String origine, String destination, int codepostal,
			double poids, double volume, int tauxrecom) {
		super(origine, destination, codepostal, poids, volume, tauxrecom);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString();
	}
	
	public double tarifAffranchissement(){
		double tarifA=super.tarifAffranchissement();
		tarifA=tarifA+0.3;
		return tarifA;
	}
}
