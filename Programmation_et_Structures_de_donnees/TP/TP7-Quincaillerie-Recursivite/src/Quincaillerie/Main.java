package Quincaillerie;

public class Main {

	public static void main(String[] args) {
		Piece p1 = new PieceDeBase("7152","vis",0.01,12,1);
		Piece p4 = new PieceDeBase("7256","pneu",15,12,2);
		PieceComposite p2 = new PieceCompositeKit("1512","roue de brouette en kit",15,"5480981");
		PieceComposite p3 = new PieceCompositeAssemblee("1512","roue de brouette",15,1);
		//note: p2 et p3 pas possible d'être des Piece, car ajoute() y existe pas. Si ajoute() existait dans Piece et que p2 & p3 étaient des Piece, elle irait chercher dans Piece, s'ils étaient des PieceComposite, elle irait chercher dans PieceComposite.
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		p2.ajoute(p1);
		p2.ajoute(p4);
		p3.ajoute(p1);
		p3.ajoute(p4);
		p3.ajoute(p2);
		System.out.println("le prix est " +p1.prix() +"€");
		System.out.println("le prix est " +p2.prix() +"€");
		System.out.println("le prix est " +p3.prix() +"€");
		System.out.println("la durée de fabrication est de " +p1.dureeFabrication() +"jours");
		System.out.println("la durée de fabrication est de " +p2.dureeFabrication() +"jours");
		System.out.println("la durée de fabrication est de " +p3.dureeFabrication() +"jours");
		System.out.println("la durée de garantie est de " +p1.dureeGarantie() +"mois");
		System.out.println("la durée de garantie est de " +p2.dureeGarantie() +"mois");
		System.out.println("la durée de garantie est de " +p3.dureeGarantie() +"mois");
		p1.affiche(0);
		p2.affiche(0);
		p3.affiche(0);


	}

}
