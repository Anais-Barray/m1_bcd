package Caissiere;
import java.util.Scanner;
public class rendremonnaie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		int e, c, r, billet100, billet10, billet5, piece2, piece1;
		System.out.println("Quel est le montant en euros?");
		e = clavier.nextInt();
		System.out.println("Combien à donner le clien?");
		c = clavier.nextInt();
		r = c-e;
		billet100 = r/100;
		r = r%100;
		billet10 = r/10;
		r = r%10;
		billet5 = r/5;
		r = r%5;
		piece2 = r/2;
		r = r%2;
		piece1 = r/1;
		System.out.println("Vous rendez "+billet100+" billet de 100, "+billet10+" billet de 10, "+billet5+ " billet de 5, "+piece2+" piece de 2, "+piece1+" piece de 1.");
		clavier.close();
	}

}
