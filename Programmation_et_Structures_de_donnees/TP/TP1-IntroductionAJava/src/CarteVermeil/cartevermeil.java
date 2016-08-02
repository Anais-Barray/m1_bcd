package CarteVermeil;
import java.util.Scanner;
public class cartevermeil {

	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		int age;
		char sex;
		System.out.println("Quel est votre age?");
		age = clavier.nextInt();
		System.out.println("Quel est votre sexe?");
		sex = clavier.next().charAt(0);
		System.out.println("Avez vous le droit à la carte Vermeil?");
		System.out.println((age>65 && sex=='M') || (age>60 && sex=='F'));
		clavier.close();

	}

}
