package ABR;

public interface IABR<E extends Comparable<E>> {
	boolean estVide();
	E getValeur();
	IABR<E> getSousArbreGauche();
	IABR<E> getSousArbreDroit();
}

