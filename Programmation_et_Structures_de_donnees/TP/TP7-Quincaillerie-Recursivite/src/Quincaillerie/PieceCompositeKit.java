package Quincaillerie;

import java.text.DecimalFormat;

public class PieceCompositeKit extends PieceComposite {
	//attributs
	private double dureeMontage;
	private String notice;
	private static String prefixe = "01";
	//constructeurs
	public PieceCompositeKit() {}

	public PieceCompositeKit(String s, String n, double dm, String no){
		super(s,n);
		this.dureeMontage=dm;
		this.notice=no;
	}
	//methodes
	@Override
	public String toString() {
		return "PieceCompositeKit [" + super.toString() + " dureeMontage=" + dureeMontage + ", notice="
				+ notice + super.toString() + "]";
	}

	public String prefixe(){
		return PieceCompositeKit.prefixe;
	}

	public double dureeGarantie(){
		return super.dureeGarantie()/2;
	}


	public void affiche(int n){
		if (n==0){
			super.affiche(n);
			System.out.println("durée de montage particulier : "+Math.round(dureeMontage)+" mn");
		}
		if (this.getListeComposant()!= null){
			if (n==0){
				System.out.print("composants : \n");}
			this.afficheComposants(n);}
		System.out.println();
	}

	//accesseurs
	public double getDureeMontage() {
		return dureeMontage;
	}

	public void setDureeMontage(double dureeMontage) {
		this.dureeMontage = dureeMontage;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

}
