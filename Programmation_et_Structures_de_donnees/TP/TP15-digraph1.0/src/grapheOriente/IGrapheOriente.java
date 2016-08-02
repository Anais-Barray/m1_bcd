package grapheOriente;

import java.io.IOException;

public interface IGrapheOriente<E,F> {
	
	void createGraphe(int nbSommet); 
	void addArc(E etiquetteSommet1, E etiquetteSommet2); // arc est une entite; changer pour <E,E> plus tard
	void setEtiquetteToArc(F etiquetteArc, E etiquetteSommet1,
			E etiquetteSommet2);
	void setEtiquetteToSommet(E etiquette, int numSommet);
	E getSommet(int numEtiquette); //retourne l'etiquette du noeud
	E getArc(E etiquette1, E etiquette2); //retourne l'etiquette de l'arc
	void readGrapheInFile(String fileName) throws IOException ; //lis le graphe dans un fichier
	void saveGrapheInFile(String fileName) throws IOException ; //sauvegarde le graphe dans un fichier


	
}
