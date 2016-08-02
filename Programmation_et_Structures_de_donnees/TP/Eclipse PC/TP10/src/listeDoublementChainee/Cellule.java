package listeDoublementChainee;
import java.util.List;

public class Cellule<E> 
{
	private Cellule<E> precedent;
	private E valeur;
	private Cellule<E> suivant;
	
	public Cellule() {
	}

	public Cellule(Cellule<E> prec, E valeur, Cellule<E> suiv)
	{
		this.precedent = prec;
		this.valeur = valeur;
		this.suivant = suiv;
	}
	
	public Cellule<E> getPrecedent() {
		return precedent;
	}


	public void setPrecedent(Cellule<E> precedent) {
		this.precedent = precedent;
	}

	public E getValeur() {
		return valeur;
	}

	public void setValeur(E valeur) {
		this.valeur = valeur;
	}

	public Cellule<E> getSuivant() {
		return suivant;
	}


	public void setSuivant(Cellule<E> suivant) {
		this.suivant = suivant;
	}


	public String toString()
	{return ""+this.valeur;}
}