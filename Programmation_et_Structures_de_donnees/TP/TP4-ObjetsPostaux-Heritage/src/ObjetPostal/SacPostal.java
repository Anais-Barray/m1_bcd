package ObjetPostal;
import java.util.ArrayList;

public class SacPostal {

	//attributs

	private ArrayList<ObjetPostal> sacPostal;
	private double capaciteMax=0.5; 

	//constructeurs

	public SacPostal() {
		sacPostal = new ArrayList<>();
	}

	public SacPostal(double capaciteMax) {
		sacPostal = new ArrayList<>();
		this.setCapaciteMax(capaciteMax);
	}

	//methodes

	public void ajouterObjet(ObjetPostal objet){
		double capacite = 0.0;
		for (ObjetPostal o : this.sacPostal){
			capacite+=o.getVolume(); 
		} 
		if ((capacite+objet.getVolume()) <= this.capaciteMax){
			sacPostal.add(objet);
		} else {
			System.out.println(capacite + " : over capacite, max="+this.capaciteMax);
		}
	}

	public double VolumeTotal(){
		double VT = 0.005, capacite=0;
		for (ObjetPostal o : this.sacPostal){
			capacite+=o.getVolume();
		} 
		VT=VT+capacite;
		return VT;
	}

	public double remboursementPerte(){
		double RP =0;
		for (ObjetPostal o : this.sacPostal){
			RP+=o.tarifRemboursement();
		}
		return RP;
	}

	public ArrayList<ObjetPostal> nouveauSacCode(int codePostal){
		ArrayList<ObjetPostal> nvSac = new ArrayList<ObjetPostal>();
		for (ObjetPostal o : this.sacPostal){
			if (o.getCodepostal()==codePostal){
				nvSac.add(o);
			}
		}
		return nvSac;
	}
	

	public String toString() {
		return "SacPostal [sacPostal=" + sacPostal + ", capaciteMax="
				+ capaciteMax + "]";
	}

	//accesseurs et mutateurs

	public ArrayList<ObjetPostal> getSacPostal() {
		return sacPostal;
	}

	public void setSacPostal(ArrayList<ObjetPostal> sacPostal) {
		this.sacPostal = sacPostal;
	}

	public double getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(double capaciteMax){
		this.capaciteMax=capaciteMax;
	}

}

