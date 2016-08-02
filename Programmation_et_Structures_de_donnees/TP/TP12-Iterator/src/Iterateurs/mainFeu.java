package Iterateurs;

import java.awt.Color;
import java.util.Iterator;

public class mainFeu {

	public static void main(String[] args) {
		FeuTricholore f1 = new FeuTricholore(Color.green, Color.orange, Color.red);
		Iterator it = f1.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}

}
