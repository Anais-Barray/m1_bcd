package digraph;

import java.io.IOException;

public interface InterDiGraph<S, A> {
	void create(int nbSommet);

	void setLabelSom(int numSommet, S sommet);

	void setLabelArc(int numSommetDep, int numSommetFin, A arc);

	void addArc(int numSommetDep, int numSommetFin);

//	void delArc(int numSommetDep, int numSommetFin);

	S getSom(int numSommet);

	A getArc(int numSommetDep, int numSommetFin);

	void readGraph(String nameFile) throws IOException;

	void writeGraph(String nameFile) throws IOException;
}
