package Temperature;
import java.util.Scanner;
public class convTemp {

	
	public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
		System.out.println("entrez une température en Celsius");
		double TempC, TempF;
		TempC = clavier.nextDouble();
		TempF = TempC*1.8+32;
		System.out.println("La température en Farenheit est "+TempF);
		clavier.close();
	}

}
