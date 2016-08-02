package DureeSeconde;
import java.util.Scanner;
public class DureeSeconde {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrer un temps en secondes");
		int h, m, s;
		s = clavier.nextInt();
		h = s/3600;
		m = s%3600/60;
		s = s%60;
		System.out.println("Cela fait "+h+" HH "+m+" mm "+s+" ss.");
		clavier.close();
	}

}
