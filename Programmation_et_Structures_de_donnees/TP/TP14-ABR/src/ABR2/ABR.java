package ABR2;
//Eclipse marketplace => color theme
public class ABR<E extends Comparable<E>> implements IABR<E> { 
	private E valeur;
	private ABR<E> sousArbreGauche, sousArbreDroit;

	public ABR() {
	}

	public ABR(E valeur) {
		this.valeur = valeur;
		sousArbreGauche = new ABR();
		sousArbreDroit = new ABR();
	}

	public ABR(ABR<E> sousArbreGauche, E valeur, ABR<E> sousArbreDroit) {
		this.valeur = valeur;
		this.sousArbreGauche = sousArbreGauche;
		this.sousArbreDroit = sousArbreDroit;
	}

	//	public boolean estVide() {
	//		return ((sousArbreGauche == null) && (sousArbreDroit == null));
	//	}

	public E getValeur() {
		return this.valeur;
	}

	public ABR<E> getSousArbreGauche() {
		return this.sousArbreGauche;
	}

	public ABR<E> getSousArbreDroit() {
		return this.sousArbreDroit;
	}

	public boolean estFeuille() {
		return this.sousArbreGauche == null && this.sousArbreDroit == null;
	}

	ABR<E> inserer(E n) { 
		if (this.estFeuille()) {
			return new ABR<E>(n);

		} else {

			int i = n.compareTo(this.getValeur());

			if (i < 0) { 
				return (new ABR<E>(sousArbreGauche.inserer(n), this.getValeur(), sousArbreDroit));}

			else {
				return (new ABR<E>(sousArbreGauche, this.getValeur(), sousArbreDroit.inserer(n)));} 
		}
	}

	public String toString() //affichage prefixe
	{
		if (this.estFeuille())
			return "";
		else {
			return this.getSousArbreGauche().toString() + " "
					+ this.getValeur().toString() + " "
					+ this.getSousArbreDroit().toString();
		}
	}

	public String tabule(int n){
		String st = "";
		for (int i=0; i<n; i++){
			st+="\t";
		}
		return st;
	}

	public String toStringDecalage(int n) //affichage prefixe
	{
		if (this.estFeuille())
			return ""+tabule(n)+this.getValeur();
		else {
			return ""+tabule(n)+this.getValeur() + "\n" 
					+ this.getSousArbreGauche().toStringDecalage(n+1) + "\n"
					+ this.getSousArbreDroit().toStringDecalage(n+1);
		}
	}

}
