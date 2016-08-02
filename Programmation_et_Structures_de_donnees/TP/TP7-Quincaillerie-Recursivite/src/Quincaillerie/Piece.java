package Quincaillerie;
import java.text.DecimalFormat;

public abstract class Piece {
	//Attributs
	private String suffixe;
	private String nom;

	//Constructeurs
	public Piece() {}

	public Piece(String s, String n){
		this.suffixe=s;
		this.nom=n;
	}

	//Methodes
	@Override
	public String toString() {
		return "Piece [reference=" + reference() + ", nom=" + nom + "]";
	}

	public abstract double prix();
	public abstract double dureeGarantie();
	public abstract double dureeFabrication();
	public abstract String prefixe();

	public String reference(){
		return this.prefixe()+this.suffixe;
	}

	public String tabule(int n){
		String st = "";
		for (int i=0; i<n; i++){
			st+="\t";
		}
		return st;
	}
	public void affiche(int n){
		if (n==0){
			DecimalFormat df = new DecimalFormat("0.##");
			System.out.println("nom : " +nom+ "\nréférence : " +reference()+ "\nprix : "+df.format(prix())+ " € \ngarantie : "+Math.round(dureeGarantie())+ " mois \ndurée de fabrication : " +Math.round(dureeFabrication()) +" jour(s)");
		}
		else {
			System.out.print(this.tabule(n)+nom +" - " +reference()+"\n");
		}
	}

	//Accesseurs
	public String getSuffixe() {
		return suffixe;
	}

	public void setSuffixe(String suffixe) {
		this.suffixe = suffixe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
