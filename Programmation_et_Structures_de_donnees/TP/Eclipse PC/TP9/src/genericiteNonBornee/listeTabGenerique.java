package genericiteNonBornee;
import java.util.ArrayList;

// ATTENTION CE CODE CONTIENT VOLONTAIREMENT DES ERREURS A ANALYSER

public class listeTabGenerique<E> {
	private int nbrElements=0;
	private int tailleInitiale=10;
	private E[] contenu;
	/*
	public listeTabGenerique()
	{this.contenu = new E[this.tailleInitiale];} //peut pas allouer de l'espace en mémoire pour créer un type E, car existe pas
	
	public listeImpTab(E[] c) {contenu = c;}
	dans main ListeImpTab<String> l = new ListeImpTab(new String[10]);
	
	public listeTabGenerique(int tailleInitiale)
	{
	      this.tailleInitiale=tailleInitiale;
	      this.contenu = new E[this.tailleInitiale];
	 }
	*/
	
	public static void main(String[] argv)
	{
		Object[] t = new Object[3];
		t[0] = "Alice";
		t[1] = new Personne();	
		t[2] = new Rectangle();
		
		t = new String[3];
		t[0] = "Alice";
		t[1] = new Personne();	
		t[2] = new Rectangle();
		
		ArrayList<Object> a = new ArrayList<Object>();
		a.add("Alice");
		a.add(new Personne());
		a.add(new Rectangle());
		
	//	a = new ArrayList<String>();
	}
}
