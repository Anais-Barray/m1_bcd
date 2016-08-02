package ObjetPostal;

public class ProgrammeSacPostal {

	public static void main(String[] args) {
		Lettre LU1 = new LettreUrgente("France", "UK", 59000, 3500, 0.1, 2);
		Colis colis1 = new Colis("Miko", "France", 59000, 3500, 0.5, 2, "chocolat", 90);
		SacPostal sac1 = new SacPostal();
		SacPostal sac2 = new SacPostal();
		SacPostal sac3 = new SacPostal(0.8);
		System.out.println(sac1);System.out.println(sac2);System.out.println(sac3);
		sac1.ajouterObjet(LU1);
		sac2.ajouterObjet(LU1);
		sac2.ajouterObjet(colis1);
		sac3.ajouterObjet(LU1);
		sac3.ajouterObjet(colis1);	
		//System.out.println(sac1.toString());
		//System.out.println(sac2.toString());
		//System.out.println(sac3.toString());
		System.out.println(sac3.VolumeTotal());
		System.out.println(sac3.remboursementPerte());
		System.out.println(sac3.nouveauSacCode(59000));

	}

}
