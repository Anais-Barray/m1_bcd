package digraph;

import java.io.BufferedWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DiGraph<S, A> implements InterDiGraph<S, A> {
	private boolean[][] graph;
	private boolean[] visited; //afin de stocker les sommets visités
	private int NbSommet;
	private HashMap<Integer, S> labelSom; // S = etiquette sommet
	private HashMap<String, A> labelArc; // A = verbe entre sommets, etiquette
	// de l'arc . String : affiche les
	// deux sommets relié, a titre
	// informatif


	@Override
	public void create(int nbSommet) {
		this.graph = new boolean[nbSommet][nbSommet];
		this.NbSommet = nbSommet;
	}

	@Override
	public void setLabelSom(int numSommet, S sommet) {
		this.labelSom.put(numSommet, sommet);
	}

	@Override
	public void setLabelArc(int numSommetDep, int numSommetFin, A arc) {
		this.labelArc.put(numSommetDep + "--" + numSommetFin, arc);
	}

	@Override
	public void addArc(int numSommetDep, int numSommetFin) {
		this.graph[numSommetDep][numSommetFin] = true;
	}

	// @Override
	// public void delArc(int numSommetDep, int numSommetFin) {
	// this.graph[numSommetDep][numSommetFin] = false;
	// }

	@Override
	public S getSom(int numSommet) {
		return this.labelSom.get(numSommet);
	}

	@Override
	public A getArc(int numSommetDep, int numSommetFin) {
		return this.labelArc.get(numSommetDep + "--" + numSommetFin); // get(clef)
		// retourne
		// valeur
	}

	@Override
	public void readGraph(String nameFile) throws IOException {
		File file = new File(nameFile + ".dot");
		Scanner scanner = new Scanner(file);

		scanner.nextLine();
		String numSommetDeb = scanner.next();
		String delimiter = scanner.next();
		int nbSommets = 0;
		while (!delimiter.equals("->")) {
			numSommetDeb = scanner.next();
			delimiter = scanner.next();
			nbSommets++;
		}
		System.out.println("nombre de sommets = " + nbSommets);
		this.create(nbSommets);
		String numSommetFin = "";
		while (!numSommetDeb.equals("}")) {
			numSommetFin = scanner.next();
			System.out.println("arc " + numSommetDeb + " " + numSommetFin);
			this.addArc(Integer.parseInt(numSommetDeb),
					Integer.parseInt(numSommetFin));
			delimiter = scanner.next();
			numSommetDeb = scanner.next();
			if (!numSommetDeb.equals("}"))
				delimiter = scanner.next();
		}
		scanner.close();
	}

	@Override
	public void writeGraph(String nameFile) throws IOException {
		PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(
				nameFile + ".dot")));
		print.println("digraph " + nameFile + " {");
		for (int i = 0; i < NbSommet; i++) {
			print.println(i + " ;");
		}

		for (int j = 0; j < NbSommet; j++) {
			for (int k = 0; k < NbSommet; k++) {
				if (this.graph[j][k]) {
					print.println(j + " -> " + k + " ;");
				}
			}
		}
		print.println("}");
		print.close();
	}

	public double nbMaxArc() {
		return (NbSommet) * (NbSommet) - NbSommet;
	}

	public double nbArc() {
		int cptArc = 0;
		for (int i = 0; i < NbSommet; i++) {
			for (int j = 0; j < NbSommet; j++) {
				if (this.graph[i][j] == true) {
					cptArc++;
				}
			}
		}
		return cptArc;
	}

	public double density() {
		return (this.nbArc() / this.nbMaxArc());
	}


	public boolean linkedSommets(int numSommetDep, int numSommetFin) {
		return this.graph[numSommetDep][numSommetFin];
	}

	public double moyenneNbVoisins() {
		double somme = 0;
		for (int i = 0; i < NbSommet; i++) {
			for (int j = 0; j < NbSommet; j++) {
				if (this.graph[i][j] == true) {
					somme++;
				}
			}
		}
		return somme/NbSommet;
	}

	public void parcours(int numSommet){
		this.parcoursRec(numSommet);
		this.visited = new boolean[NbSommet]; // réinitialise le tableau des sommets visités.
	}

	public void parcoursRec(int numSommet){ //parcours en profondeur recursif
		System.out.println(numSommet);
		this.visited[numSommet] = true;
		for (int i = 0 ; i<NbSommet; i++){
			if (this.graph[numSommet][i] && !this.visited[i]){
				this.parcoursRec(i);
			}
		}
	}


	public void afficheTab(){
		for (boolean[] boolTab : this.graph){
			for (boolean bool : boolTab){
				if (bool){
					System.out.print("O ");
				} else {
					System.out.print("X ");
				}
			} System.out.println();
		}
	}

}
