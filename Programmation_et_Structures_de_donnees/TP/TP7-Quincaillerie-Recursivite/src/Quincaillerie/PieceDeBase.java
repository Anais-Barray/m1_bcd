package Quincaillerie;

public class PieceDeBase extends Piece {
	//attributs
	private double prix;
	private double dureeGarantie;
	private double dureeFabrication;
	private static String prefixe = "00";
	//constructeurs
	public PieceDeBase() {}

	public PieceDeBase(String s, String n, double p, double dg, double df) {
		super(s,n);
		this.prix=p;
		this.dureeGarantie=dg;
		this.dureeFabrication=df;
	}

	//methodes
	@Override
	public String toString() {
		return "PieceDeBase [" + super.toString() + " prix=" + prix + ", dureeGarantie=" + dureeGarantie
				+ ", dureeFabrication=" + dureeFabrication + "]";
	}
	
	public String prefixe(){
		return PieceDeBase.prefixe;//PDB et pas this car prefixe partagé par tous les PDB (static).
	}
	
	public double prix(){
		return this.prix;
	}
	
	public double dureeGarantie(){
		return this.dureeGarantie;
	}
	
	public double dureeFabrication(){
		return this.dureeFabrication;
	}

	
	//accesseurs
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getDureeGarantie() {
		return dureeGarantie;
	}

	public void setDureeGarantie(double dureeGarantie) {
		this.dureeGarantie = dureeGarantie;
	}

	public double getDureeFabrication() {
		return dureeFabrication;
	}

	public void setDureeFabrication(double dureeFabrication) {
		this.dureeFabrication = dureeFabrication;
	}
	
	
	
}
