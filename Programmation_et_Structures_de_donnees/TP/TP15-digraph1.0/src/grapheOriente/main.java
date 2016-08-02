package grapheOriente;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		GrapheOriente graphe1 = new GrapheOriente();
		
		try {
			graphe1.readGrapheInFile("exempleGraphe");
			graphe1.saveGrapheInFile("exempleGraphe2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		graphe1.afficheTab();
	}
}
