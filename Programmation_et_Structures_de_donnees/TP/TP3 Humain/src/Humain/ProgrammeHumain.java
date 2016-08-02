package Humain;
import java.util.Scanner;
public class ProgrammeHumain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Humain h1 = new Humain("Sophie",22,'F');
		Humain h2 = new Humain("Albert",32,'M');
		Humain h3 = new Humain("Igor",66,'M');
		Humain h4 = new Humain("Lila",69,'F');


		//h1.estMarriable();
		//h1.seMarrier(h2);
		//System.out.println(h1.toString());
		//h1.seSeparer();
		//System.out.println(h1.toString());
		System.out.println(h1.estMajeur());
		s.close();
	}
}