package ABRCorrection;

// Arbre binaire de recherche fonctionnel, sans effets de bord, autorise des calculs alg�rbiques
// Version 1, avec repr�sentation de l'abre vide comme une instance particuli�re de la classe ABR
// A faire une version 2, avec 2 classes diff�rentes ArbreVide et ArbreNonVide.

public class ABR<E extends Comparable<E>> {
	private static ABR arbreVide = new ABR(); // warning

	// variante 1
	// private static ABR<?> arbreVide = new ABR(); // warning
	// necessite d'�crire ensuite : this.sousArbreDroit = (ABR<E>) arbreVide;

	// variante 2
	// private static<X> ABR<X> arbreVide;
	// erreur X cannot be resolved to a type
	// puis Unchecked cast from ABR<capture#1-of ?> to ABR<E> quand on affecte

	private E etiquette;
	private ABR<E> sousArbreGauche, sousArbreDroit;

	private ABR() {
	}

	public ABR(E etiquette) {
		this.etiquette = etiquette;
		this.sousArbreGauche = arbreVide;
		this.sousArbreDroit = arbreVide;
	}

	public ABR(E etiquette, ABR<E> sousArbreGauche, ABR<E> sousArbreDroit) {
		this.etiquette = etiquette;
		this.sousArbreGauche = sousArbreGauche;
		this.sousArbreDroit = sousArbreDroit;
	}

	public boolean estVide() {
		return this == arbreVide;
	}

	public boolean estFeuille() {
		return (sousArbreGauche == null && sousArbreDroit == null && etiquette != null);
	}

	public E getEtiquette() {
		return etiquette;
	}

	public ABR<E> getSousArbreGauche() {
		return sousArbreGauche;
	}

	public ABR<E> getSousArbreDroit() {
		return sousArbreDroit;
	}

	ABR<E> insere(E e) {
		if (this.estVide())
			return new ABR<E>(e);
		else {
			int c = e.compareTo(etiquette);
			if (c == 0)
				return this;
			else if (c < 0)
				return new ABR<E>(etiquette, sousArbreGauche.insere(e),
						sousArbreDroit);
			else
				return new ABR<E>(etiquette, sousArbreGauche,
						sousArbreDroit.insere(e));
		}
	}

	public boolean search(E e) {
		if (this.estVide())
			return false;
		else {
			int c = e.compareTo(etiquette);
			if (c == 0)
				return true;
			else if (c < 0)
				return sousArbreGauche.search(e);
			else
				return sousArbreDroit.search(e);
		}
	}

	public String tabule(int n) {
		String st = "";
		for (int i = 0; i < n; i++) {
			st += "\t";
		}
		return st;
	}

	//
	// public String toStringIndente(int n) //affichage prefixe
	// {
	// if (this.estVide())
	// return "";
	// else {
	// return ""+ this.getSousArbreGauche().toStringIndente(n+1)
	// + tabule(n)+this.getEtiquette() + "\n"
	// + this.getSousArbreDroit().toStringIndente(n+1);
	// }
	// }
	//
	// public String toString() //affichage prefixe
	// {
	// if (this.estVide())
	// return "";
	// else {
	// return this.getSousArbreGauche().toString() + " "
	// + this.getEtiquette().toString() + " "
	// + this.getSousArbreDroit().toString();
	// }
	// }
	//
	//	public static int factorielle(int n){
	//		if (n==0)
	//			return 1;
	//		else return n*factorielle(n-1);
	//	}

	public String toString() {
		if (this.estVide())
			return "()";
		else
			return ("(" + etiquette + sousArbreGauche + sousArbreDroit + ")");
	}

	public String toStringIndente(int n) // affichage prefixe
	{
		String s = "";
		if (!this.estVide()) {
			s = tabule(n) + "(" + this.getEtiquette() + ")" + "\n"
					+ sousArbreGauche.toStringIndente(n + 1) 
					+ sousArbreDroit.toStringIndente(n + 1) ;
		}
		return s;
	}

	public static void main(String[] args) {
		ABR<Integer> a = new ABR<Integer>(7);
		System.out.println(a);
		ABR<Integer> b = a.insere(4).insere(10).insere(2).insere(3).insere(5)
				.insere(8).insere(9).insere(12);
		System.out.println(b);
		// System.out.println(b.toStringProf()); // fonctionne pas avec le
		// nouveu toString redéfinit
		System.out.println("7 dans a : " + a.search(7));
		System.out.println("0 dans a : " + a.search(0));
		System.out.println("8 dans a : " + b.search(8));
		System.out.println("0 dans a : " + b.search(0));
		System.out.println(b.toStringIndente(0));

	}
}