package Piles;

public class FullStackException extends RuntimeException {
	public FullStackException() {}
	@Override
	public String getMessage() {
		return "Erreur : Pile pleine.";
	}
}
