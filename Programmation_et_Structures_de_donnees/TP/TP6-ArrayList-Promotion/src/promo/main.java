package promo;
import java.util.*;

import Etudiant.SituationFinanciere;

public class main {


	public static void main(String[] args) {
		//Création du premier étudiant
		Scanner s = new Scanner(System.in);
		Etudiant etudiant1 = new Etudiant("Jean",18,14,14,24,1,3,SituationFinanciere.salarie);
		Etudiant etudiant2 = new Etudiant("Abdoukhader",2,5,10,23,2,3,SituationFinanciere.boursier);
		Etudiant etudiant3 = new Etudiant("Astrid",4,14,10,26,1,2,SituationFinanciere.autre);
		Etudiant etudiant4 = new Etudiant("Paolo",15,14,10,27,1,2,SituationFinanciere.autre);
		Etudiant etudiant5 = new Etudiant("Jean",12,14,17,26,1,3,SituationFinanciere.autre);
		Etudiant etudiant6 = new Etudiant();
		etudiant3.setNoteprog(16);
		etudiant3.setNotesysteme(15);
		etudiant3.setNotestage(14);
		etudiant5.setNoteprog(18);
		etudiant5.setNotesysteme(12);
		etudiant5.setNotestage(15);
		//System.out.println(etudiant5.toString()+" la moyenne est de "+etudiant5.moyenne()+" "+etudiant5.mention()+" "+etudiant5.ligneResultats());
		//etudiant6.Saisie(s);
		//System.out.println(etudiant6.ligneResultats());
		//System.out.println(etudiant1.getSitfin());

		Promotion P1 = new Promotion(2014);
		P1.inscrire(etudiant1);
		P1.inscrire(etudiant2);
		P1.inscrire(etudiant3);
		P1.inscrire(etudiant4);
		P1.inscrire(etudiant5);
		//System.out.println(P1.toString());
		//P1.afficheResultats();
		//P1.moyenneGenerale();
		//System.out.println(P1.rechercheSansHomonyme("toto"));
		//System.out.println(P1.recherche("Jean"));
		//System.out.println("etudiants admis : " + P1.admis());
		//System.out.println(P1.nonfranco());
		//System.out.println("majors : " + P1.majors() + " note : "+ P1.maxNote());
		System.out.println(Arrays.toString(P1.histogramme1()));
		s.close();
	}

}
