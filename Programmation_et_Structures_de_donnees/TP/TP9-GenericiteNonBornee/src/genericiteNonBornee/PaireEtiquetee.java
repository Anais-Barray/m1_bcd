package genericiteNonBornee;

import java.util.ArrayList;

public class PaireEtiquetee<A, B, C> extends Paire<A,B> {

	private C etiquette;

	public PaireEtiquetee(){}
	public PaireEtiquetee(A f, B s, C e){
		super(f,s);
		this.setEtiquette(e);
	}

	public C getEtiquette() {
		return etiquette;
	}
	public void setEtiquette(C etiquette) {
		this.etiquette = etiquette;
	}
	public String toString(){return super.toString() + getEtiquette();}



	public static void main(String[] argv)
	{

		PaireEtiquetee<String, String, String> pe = new PaireEtiquetee<>("un", "deux", "trois");
		PaireEtiquetee<String, String, Integer> pe2 = new PaireEtiquetee<>("un", "deux", 3);
		System.out.println(pe);
		System.out.println(pe2);
		System.out.println(pe.getEtiquette());

	}
}