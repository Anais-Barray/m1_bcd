package cc;

import java.util.ArrayList;

public class ProgVetement {

	public static void main(String[] args) {

		//Question 1
		Vetement v1 = new Vetement("veste en lin", "Ligne Sauvage", 95, 5);
		System.out.println(v1);
		System.out.println(v1.aLabelNaturel());
	
		VetementSport v2 = new VetementSport("short","Adidas",55, 45, Sports.athletisme);
		System.out.println(v2);
		
		Vetement v3 = new Vetement("jupe en lin", "Ligne Sauvage", 95, 5);
		System.out.println(v3);
		
		Armoire a = new Armoire();
		a.ajoute(v1);
		a.ajoute(v2);
		a.ajoute(v3);
		System.out.println(a);
		System.out.println("nb de vetements naturels "+ a.nbVetementsNaturels());
		ArrayList <Vetement> ee = a.rechercheMarque("Ligne Sauvage");
		System.out.println("vetements de la marque Ligne Sauvage");
		for (Vetement e: ee)
			System.out.println(e);
		
		
	}

}
