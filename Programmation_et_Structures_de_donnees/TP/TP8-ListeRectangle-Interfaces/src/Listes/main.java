package Listes;

import java.io.ObjectInputStream.GetField;

public class main {


	public static void main(String[] args) {
		ListeTableau l1 = new ListeTableauStatistiques();
		ListeTableau l2 = new ListeTableauStatistiques();
		ListeTableauStatistiques l3 = new ListeTableauStatistiques();
		ListeTableauStatistiques l4 = new ListeTableauStatistiques();
		l1.add("abc");
		l2.add("abc");
		l3.add("abc");
		l4.add("abc");	
		//System.out.println(l1.equals(l2));
		System.out.println(l3.equals(l4));
		System.out.println(l3.size());
		System.out.println(l3.getCompteurAdd());
		
		//tester
		
		
		/*String x= new String("ab");
		String y= new String("abc");
		System.out.println(x==y);
		System.out.println(x.equals(y));
		System.out.println(x);//=>ab
		String w="ab";
		String z="ab";
		System.out.println(w==z);
		System.out.println(w.equals(z));
		w="ac";
		System.out.println(w==z);
		System.out.println(w.equals(z));
		x=y;//x partage la case mémoire de y.
		System.out.println(x==y);
		System.out.println(x.equals(y));
		System.out.println(x);//=>abc
		y="abb";
		System.out.println(x);//=>abc et non abb.
		*/
	}


}
