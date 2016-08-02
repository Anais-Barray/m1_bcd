package digraph;

import java.io.IOException;
import java.text.DecimalFormat;

public class main {

	public static void main(String[] args) {
		DiGraph<String, String> graphe1 = new DiGraph<>();
		
		try {
			graphe1.readGraph("exempleGraphe");
			graphe1.writeGraph("exempleGraphe2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DecimalFormat df = new DecimalFormat("0.###");
		System.out.println(df.format(graphe1.density()));
		System.out.println(graphe1.linkedSommets(2, 5)); //T
		System.out.println(graphe1.linkedSommets(1, 4)); //F

//		System.out.println(graphe1.nbArc());
//		System.out.println(graphe1.nbMaxArc());
//		graphe1.afficheTab();
	}
}
