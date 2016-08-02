package ObjetPostal;

public abstract class Lettre extends ObjetPostal {

	
	public Lettre(String origine, String destination, int codepostal,
			double poids, double volume, int tauxrecom) {
		super(origine, destination, codepostal, poids, volume, tauxrecom);
		// TODO Auto-generated constructor stub
	}

	

	public String toString() {
		return "Lettre " + super.toString();
	}


	public double tarifRemboursement(){
		double tarifR=0;
		if (getTauxrecom()==1){
			tarifR=tarifR+1.5;
		}
		if (getTauxrecom()==2){
			tarifR=tarifR+15;
		}
		return tarifR;
	}
}
