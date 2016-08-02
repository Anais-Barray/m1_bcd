package ABR;

public class ABR<E extends Comparable<E>> implements IABR<E> { // E ss entend le
	// extends
	// comparable
	// Comparable : interface predéfinie qui repere les types dotés d'une
	// relation d'ordre
	private E valeur;
	private ABR<E> sousArbreGauche, sousArbreDroit;

	public ABR() {
	}

	public ABR(E valeur) {
		this.valeur = valeur;
	}

	public ABR(ABR<E> sousArbreGauche, E valeur, ABR<E> sousArbreDroit) {
		this.valeur = valeur;
		this.sousArbreGauche = sousArbreGauche;
		this.sousArbreDroit = sousArbreDroit;
	}

	public boolean estVide() {
		return this.valeur == null;
	}

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

	ABR<E> inserer(E n) { // construit un nouvel arbre incluant les elements de
		// this + n
		if (this.estVide()) {
			return new ABR<E>(n);
		} else {
			int i = n.compareTo(this.getValeur());

			if (i < 0) { // n < this, changer le sousArbreGauche de this

				if (this.getSousArbreGauche() == null) {
					return (new ABR<E>(new ABR<E>(n), this.getValeur(),
							this.getSousArbreDroit()));
				}

				else
				{
					return (new ABR<E>(this.getSousArbreGauche().inserer(n),
							this.getValeur(), this.getSousArbreDroit()));
				}
			}

			else if (i > 0) { // n < this, changer le sousArbreDroit de this

				if (this.getSousArbreDroit() == null) {
					return (new ABR<E>(this.getSousArbreGauche(),
							this.getValeur(), new ABR<E>(n)));
				}

				else {
					return (new ABR<E>(this.getSousArbreGauche(),
							this.getValeur(), this.getSousArbreDroit().inserer(
									n)));
				}

			} else if (i == 0) { // n = this
				System.out.println("Même valeur");
			}
			return null;
		}
	}

	public String toMonString() {// affichage prefixe
		if (this.estFeuille()) {
			return "" + this.getValeur();
		} else if (this.getSousArbreDroit() == null) {
			return this.getSousArbreGauche().toMonString() + " < " + this.getValeur();
		} else if (this.getSousArbreGauche() == null) {
			return this.getValeur() + " < "  + this.getSousArbreDroit().toMonString();
		} else {
			return this.getSousArbreGauche().toMonString() + " < " + this.getValeur()
					+ " < " +this.getSousArbreDroit().toMonString();
		}
	}
}
