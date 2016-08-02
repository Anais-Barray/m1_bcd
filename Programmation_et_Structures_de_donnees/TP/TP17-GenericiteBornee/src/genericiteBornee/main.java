package genericiteBornee;

public class main {

	public static void main(String[] args) {
		FileAttenteSurInvitation<Enfant> f1 = new FileAttenteSurInvitation<Enfant>();
		FileAttenteSurInvitation<Adulte> f2 = new FileAttenteSurInvitation<Adulte>();
		FileAttenteSurInvitation<Personne> f3 = new FileAttenteSurInvitation<Personne>();

		f1.setNomFile("fileEnfant");
		f2.setNomFile("fileAdulte");
		f3.setNomFile("filePersonne");

		f1.entre(new Enfant("PrenomEnfant1","NomEnfant1",true));
		f2.entre(new Adulte("PrenomAdulte1","NomAdulte1",true));
		f3.entre(new Personne("PrenomPersonne1","NomPersonne1",true));
		f1.entre(new Enfant("PrenomEnfant2","NomEnfant2",true));
		f2.entre(new Adulte("PrenomAdulte2","NomAdulte2",true));
		f3.entre(new Personne("PrenomPersonne2","NomPersonne2",true));

		System.out.println("\n nombre entrées totales : " + FileAttenteSurInvitation.getNbElementsEntresTotal());//variable globale de toutes les FA de tous les types
		System.out.println(f1.getNomFile() + " : " + f1);
		System.out.println(f2.getNomFile() + " : " + f2);
		System.out.println(f3.getNomFile() + " : " + f3);

		f1.deplaceVers(f3);
		f2.deplaceVers(f3);
		
		System.out.println("\n Files après déplacement 1 : ");
		System.out.println(f1.getNomFile() + " : " + f1);
		System.out.println(f2.getNomFile() + " : " + f2);
		System.out.println(f3.getNomFile() + " : " + f3);


		
		f3.deplaceDepuis(f1);
		f3.deplaceDepuis(f2);

		System.out.println("\n Files après déplacement 2 : ");
		System.out.println(f1.getNomFile() + " : " + f1);
		System.out.println(f2.getNomFile() + " : " + f2);
		System.out.println(f3.getNomFile() + " : " + f3);
		
		//f1.deplaceDepuis(f3);
	}

}
