package ADB;

public class main {
	public static void main(String[] args) {
		//ADB Especes
		ADB<String> m = new ADB<>("mammifere");
		ADB<String> pr = new ADB<>("poisson/reptile");
		ADB<String> o = new ADB<>("oiseau");
		ADB<String> mo = new ADB<>("mollusque");
		ADB<String> a = new ADB<>("arthropode");
		ADB<String> po = new ADB<>("Poils ?",m,pr);
		ADB<String> pl = new ADB<>("Plumes ?",o,po);
		ADB<String> c = new ADB<>("Coquille ?",mo,a);
		ADB<String> v = new ADB<>("Vertebre ?",pl,c); //racine
		
		//ADB Annee bissextile
		ADB<String> nb1  = new ADB<>("non bissextile");
		ADB<String> nb2  = new ADB<>("non bissextile");
		ADB<String> b1  = new ADB<>("bissextile");
		ADB<String> b2  = new ADB<>("bissextile");
		ADB<String> m400  = new ADB<>("multiple de 400 ?",nb2,b2);
		ADB<String> m100  = new ADB<>("multiple de 100 ?",m400,b1);
		ADB<String> m4  = new ADB<>("multiple de 4 ?",m100,nb1); //racine
		
		//ADB Qui est-ce?
		ADB<String> p1  = new ADB<>("Edouard");
		ADB<String> p2  = new ADB<>("Gilles");
		ADB<String> p3  = new ADB<>("Alphonse");
		ADB<String> p4  = new ADB<>("Adrien");
		ADB<String> p5  = new ADB<>("Sophie");
		ADB<String> p6  = new ADB<>("Carine");
		ADB<String> p7  = new ADB<>("Elise");
		ADB<String> na  = new ADB<>("Nageur ?",p3,p4);
		ADB<String> ma  = new ADB<>("Maquillage ?",p6,p7);
		ADB<String> ro  = new ADB<>("Robe ?",p5,ma);
		ADB<String> br  = new ADB<>("Brun ?",p2,na);
		ADB<String> lu  = new ADB<>("Lunettes ?",br,p1);
		ADB<String> ho  = new ADB<>("Homme ?",lu,ro); //racine

		//Appels de méthodes :
		//Arbre 1
		System.out.println(v.toStringDecalage(0)+"\n");
		System.out.println("étiquette Plumes ? : " +v.existeEtiquette("Plumes ?")); //résultat attendu = true
		System.out.println("étiquette Chihuahua : " +v.existeEtiquette("Chihuahua")); //résultat attendu = false
		System.out.println("nombre de feuilles dans Arbre Especes = " + v.getNbFeuille()); //résultat attendu = 5
		System.out.println("nombre de noeuds dans Arbre Especes = " + v.getNbNoeud()); //résultat attendu = 4
		System.out.println("Plus longue branche dans Arbre Especes = " + v.getHauteur()); //résultat attendu = 4
		System.out.println();
		
		//Arbre2
		System.out.println(m4.toStringDecalage(0)+"\n");
		System.out.println("Plus longue branche dans Arbre Annee bissextile = " + m4.getHauteur()); //résultat attendu = 4
		System.out.println();
		
		//Arbre3
		System.out.println(ho.toStringDecalage(0)+"\n");
		System.out.println("Plus longue branche dans Arbre Qui est-ce ? = " + ho.getHauteur()); //résultat attendu = 5
		System.out.println();

	}

}
