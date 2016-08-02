package listeTD2;

/**
 * @author Guillaume Artignan Date : 31 janv. 2012 15:30:05
 */

public class Cellule<E> {
	private Cellule<E> precedant;
	private E val;
	private Cellule<E> suivant;

	public Cellule(Cellule<E> prec, E val, Cellule<E> suiv) {
		this.precedant = prec;
		this.val = val;
		this.suivant = suiv;
	}

	public Cellule<E> getPrecedent() {
		return precedant;
	}

	public Cellule<E> getSuivant() {
		return suivant;
	}

	public E getVal() {
		return val;
	}

	public void setVal(E val) {
		this.val = val;
	}

	public void setSuivant(Cellule<E> suiv) {
		this.suivant = suiv;
	}

	public void setPrecedent(Cellule<E> prec) {
		this.precedant = prec;
	}
}