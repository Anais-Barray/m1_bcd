package Quincaillerie;

import java.text.DecimalFormat;

public class PieceCompositeAssemblee extends PieceComposite {
	//attributs
	private double prixMontage;
	private double dureeMontageAtelier;
	private double garantieAtelier=6;
	private static String prefixe = "02";
	//constructeurs
	public PieceCompositeAssemblee() {}

	public PieceCompositeAssemblee(String s, String n, double pm, double dma) {
		super(s,n);
		this.prixMontage=pm;
		this.dureeMontageAtelier=dma;
	}
	//methodes
	@Override
	public String toString() {
		return "PieceCompositeAssemblee [" + super.toString() + " prixMontage=" + prixMontage
				+ ", dureeMontage=" + dureeMontageAtelier + ", garantieAtelier="
				+ garantieAtelier  +  "]";
	}

	public String prefixe(){
		return PieceCompositeAssemblee.prefixe;
	}

	public double prix(){
		return super.prix()+this.prixMontage;
	}

	public double dureeGarantie(){
		return super.dureeGarantie()+6;
	}

	public double dureeFabrication(){
		return super.dureeFabrication() + dureeMontageAtelier;
	}


	public void affiche(int n){
		DecimalFormat df = new DecimalFormat("0.##");
		super.affiche(n);
		System.out.println("durée du montage atelier : "+Math.round(dureeMontageAtelier) +" jour(s)\nprix du montage : "+df.format(prixMontage)+ " €");
		if (this.getListeComposant()!= null){
			if (n==0){
			System.out.print("composants : \n");}
			this.afficheComposants(n);}
		System.out.println();
	}



	//accesseurs
	public double getPrixMontage() {
		return prixMontage;
	}

	public void setPrixMontage(double prixMontage) {
		this.prixMontage = prixMontage;
	}

	public double getDureeMontage() {
		return dureeMontageAtelier;
	}

	public void setDureeMontageAtelier(double dureeMontageAtelier) {
		this.dureeMontageAtelier = dureeMontageAtelier;
	}

	public double getGarantieAtelier() {
		return garantieAtelier;
	}

	public void setGarantieAtelier(double garantieAtelier) {
		this.garantieAtelier = garantieAtelier;
	}


}
