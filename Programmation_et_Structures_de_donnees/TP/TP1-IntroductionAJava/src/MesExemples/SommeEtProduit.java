package MesExemples;
import java.util.Scanner;
public class SommeEtProduit {

	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		double x, y;
		System.out.println("entrez deux réels");
		x = clavier.nextDouble();
		y = clavier.nextDouble();
		double somme = x+y;
		double produit = x*y;
		System.out.println("somme = "+somme+" produit = "+produit);
		clavier.close();

	}

}
