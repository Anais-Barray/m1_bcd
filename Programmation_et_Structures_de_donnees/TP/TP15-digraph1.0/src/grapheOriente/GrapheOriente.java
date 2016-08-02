package grapheOriente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;

public class GrapheOriente<E,F> implements IGrapheOriente<E,F> {

	private boolean[][] graphe; // ex tab[0][5] colonne puis ligne. 0 vers 5
	private HashMap<Integer, E> etiquetteSommet;
	private HashMap<F, E[]> etiquetteArc; // plutot que <I,I>, facile d'utilisation pour l'utilisateur, alors qu'avec des Int, utile quand gros calculs.
	//à une étiquette de l'arc F, on associe un tableau de deux étiquettes qui sont les sommets qui sont reliés par l'arc.

	public GrapheOriente() {}

	public GrapheOriente(int nbSommet) {
		this.createGraphe(nbSommet);
	}

	@Override
	public void createGraphe(int nbSommet) {
		graphe = new boolean[nbSommet][nbSommet];
	}

	public void addArc(E etiquettePointe, E etiquetteRecoit) {
		this.graphe[this.getSommet(etiquettePointe)][this.getSommet(etiquetteRecoit)] = true;
	}


	private void addArc(int sommet1, int sommet2) {
		this.graphe[sommet1][sommet2] = true;
	}

	@Override
	public void setEtiquetteToSommet(E etiquette, int numSommet) {
		this.etiquetteSommet.put(numSommet,etiquette);
	}

	@Override
	public void setEtiquetteToArc(F etiquetteArc, E etiquetteSommet1, E etiquetteSommet2) {
	//	E[] e = (E[]) Array.newInstance(e.getClass(), 2);
		//e = new E[]{etiquetteSommet1,etiquetteSommet2};
		//this.etiquetteArc.put(etiquetteArc, e{etiquetteSommet1,etiquetteSommet2});
	}


	@Override
	public E getSommet(int numSommet) {
		return this.etiquetteSommet.get(numSommet);
	}

	private int getSommet(E etiquette) {
		for (Integer key : this.etiquetteSommet.keySet()){
			if (this.etiquetteSommet.get(key).equals(etiquette)){	
				return key;
			}
		}
		return -1;//retourne message d'erreur, tableau peut pas etre negatif
	}


	@Override
	public E getArc(E etiquette1, E etiquette2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readGrapheInFile(String fileName) throws IOException {
		{
			File fichier = new File(fileName +".dot");
			Scanner lecteur = new Scanner(fichier);
			System.out.println("type du graphe "+lecteur.next());// passer l’entête
			System.out.println("nom du graphe "+lecteur.next());// passer le nom du graphe
			System.out.println(lecteur.next()); // passer {
			// lire les sommets, lire deux zones
			String numSommet = lecteur.next();
			System.out.println("num sommet "+numSommet);
			String cars = lecteur.next(); // ; ou ->
			System.out.println("cars "+cars);
			int nbSommets = 0;
			while (!cars.equals("->")) {
				numSommet = lecteur.next();
				System.out.println("num sommet "+numSommet);
				cars = lecteur.next(); // ; ou ->
				System.out.println("cars "+cars);
				nbSommets++;
			}
			System.out.println("nombre de sommets = "+nbSommets);
			// le dernier numSommet est l’origine d’un arc -
			//lire les arcs et créer le graphe correspondant

			this.createGraphe(nbSommets);

			String numSommetDest="";
			while (!numSommet.equals("}")) {
				numSommetDest = lecteur.next();
				//System.out.println("num sommet dest "+numSommetDest);
				System.out.println("arc "+numSommet+ " "+ numSommetDest);
				cars = lecteur.next(); // ; ou
				//System.out.println("cars "+cars);
				this.addArc(Integer.parseInt(numSommet), Integer.parseInt(numSommetDest)); //convertit le String en int.
				numSommet = lecteur.next();
				//System.out.println("num sommet orig "+numSommet);
				if (!numSommet.equals("}")) cars = lecteur.next(); // ->
			}
			lecteur.close();
		}
	}

	@Override
	public void saveGrapheInFile(String fileName) throws IOException {
		PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(
				fileName + ".dot"))); // CTRL SHIFT O pour importer, ctrl shift C pour commenter plusieurs lignes.
		//		 automatiquement tout le necessaire.
		//		 Si on rajouter boolean true, permet
		//		 d'écrire a la suite du fichier, ici
		//		 ca le remplace s'il existe déjà
		//		 print remplace le system.out, ici ca
		//		 va écrire dans un fichier plutot
		//		 que la console.
		print.println("digraph" + fileName + "{");
		for (int i=0; i<this.graphe.length; i++){
			print.println(i +" ;");
		}
		for (int j=0; j<this.graphe.length; j++){
			for (int k=0; k<this.graphe.length; k++){ //alt shift r => rename partout cette variable
				if(this.graphe[j][k]){ //si l'intersection des deux est vrai (arc = true
					print.println(j + " -> " + k + " ;");
				}
			}
		}
		print.println("}");
		print.close();
	}

	public void afficheTab(){
		for (boolean[] boolTab : this.graphe){
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

