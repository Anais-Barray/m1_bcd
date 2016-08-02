package Iterateurs;
import java.awt.Color;
import java.util.Iterator;

public class IteratorFeu implements Iterator {
	//private Iterator iterateur_color;
	private int pc = 0;
	private Color[] tab2;//pointeur vers feutri
	//faire nous meme les fonctions d'itération, pas en utilisant Iterator

	public IteratorFeu() {}

	public IteratorFeu(Color[] tab) {
		this.tab2 = tab;
	}

	@Override
	public boolean hasNext() {
		return pc < tab2.length;
		}

	@Override
	public Object next() {
		Color cCourante = tab2[pc];
		pc++;
		return cCourante;
	}

	@Override
	public void remove() {
		tab2[pc] = null;
		pc++;	}


}
