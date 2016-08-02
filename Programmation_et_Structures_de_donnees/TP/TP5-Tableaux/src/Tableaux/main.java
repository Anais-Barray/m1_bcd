package Tableaux;
import java.util.Scanner;

public class main {


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MonTableaudeCaracteres tab1 = new MonTableaudeCaracteres();
		
		
		tab1.saisirEtCreer(s);tab1.affTab();
		System.out.println(tab1.occurence('a'));
		
		tab1.inverse();
		tab1.affTab();
		s.close();
	}

}
