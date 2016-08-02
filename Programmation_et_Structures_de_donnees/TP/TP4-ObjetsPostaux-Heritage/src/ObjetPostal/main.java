package ObjetPostal;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lettre LU1 = new LettreUrgente("France", "UK", 59000, 3500, 0.5, 2);
		System.out.println(LU1.toString());
		Colis colis1 = new Colis("Miko", "France", 59000, 3500, 0.5, 2, "chocolat", 90);
		System.out.println(colis1.toString());

	}

}
