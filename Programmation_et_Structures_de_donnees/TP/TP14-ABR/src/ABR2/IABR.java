package ABR2;

public interface IABR<E extends Comparable<E>> {
	boolean estFeuille();
	E getValeur();
	IABR<E> getSousArbreGauche();
	IABR<E> getSousArbreDroit();
}

