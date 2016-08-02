package Etudiant;
import java.util.Scanner;
public class ProgrammeEtudiant {

	public static void main(String[] args) {
		//Création du premier étudiant
		Scanner s = new Scanner(System.in);
		Etudiant etudiant1 = new Etudiant("Jean",24,1,3,SituationFinanciere.salarie);
		Etudiant etudiant2 = new Etudiant("Abdoukhader",23,2,3,SituationFinanciere.boursier);
		Etudiant etudiant3 = new Etudiant("Astrid",26,1,2,SituationFinanciere.autre);
		Etudiant etudiant4 = new Etudiant("Paolo",27,1,2,SituationFinanciere.autre);
		Etudiant etudiant5 = new Etudiant("Zoé",12,14,17,26,1,3,SituationFinanciere.autre);
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
		System.out.println(etudiant1.getSitfin());

		
		s.close();
	}

}
