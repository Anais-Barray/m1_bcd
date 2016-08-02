package VetementExam;

public class main {

	public main() {	}

	public static void main(String[] args) {
		/*Vetement v1 = new Vetement("pull en laine", "Merinos", 80, 20);
		System.out.println(v1.aLabelNaturel());
		v1.ajouteTE(TypeEntretien.lavageSec);
		System.out.println(v1);
		v1.ajouteTE(TypeEntretien.secheLingeInterdit);
		System.out.println(v1);
		v1.ajouteTE(TypeEntretien.lavage90degres);
		System.out.println(v1);
		v1.supprimeTE(TypeEntretien.secheLingeInterdit);
		System.out.println(v1);	
		v1.ajouteTE(TypeEntretien.lavage90degres);
		System.out.println(v1);
		*/
		TenueTravail v2 = new TenueTravail("salopette", "Sacha", 60, 40, "yoho", true);
		System.out.println(v2);	
		
		SacDeLinge s1 = new SacDeLinge();
		//s1.ajouteVet(v1);
		s1.ajouteVet(v2);
		v2.ajouteTE(TypeEntretien.lavageSec);
		v2.ajouteTE(TypeEntretien.lavage40degres);
		//System.out.println(s1);
		System.out.println("laverie?" +s1.aApporterALaLaverie());

		
	}

}
