package ADB;

public interface IADB<E> {
	boolean estVide();
	E getEtiquette();
	IADB<E> getSousArbreVrai();
	IADB<E> getSousArbreFaux();
}
