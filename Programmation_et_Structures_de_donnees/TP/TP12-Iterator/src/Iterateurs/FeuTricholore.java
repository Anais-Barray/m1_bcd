package Iterateurs;

import java.awt.Color;
import java.util.Iterator;


public class FeuTricholore implements Iterable {
	
	Color tab[] = new Color[3];
	
	
	public FeuTricholore() {}
	public FeuTricholore(Color c1, Color c2, Color c3) {
		tab[0] = c1;
		tab[1] = c2;
		tab[2] = c3;
	}

	

	@Override
	public Iterator iterator() {
		return new IteratorFeu(tab);
	}
	
}
