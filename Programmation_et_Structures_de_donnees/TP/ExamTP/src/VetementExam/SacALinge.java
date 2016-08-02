package VetementExam;

import java.util.ArrayList;


public class SacALinge  {

	private Vetement premier;
	private SacALinge sacALinge;

	public SacALinge() {}

	public SacALinge(Vetement prem, SacALinge sac) {
		this.premier=prem;
		this.sacALinge=sac;
	}
	
	//methodes


	public String toString() {
		return "SacALinge [premier=" + premier + ", sacDeLinge=" + sacALinge
				+ "]";
	}

	public SacALinge extraireLingeABouillir(){
		if (this.premier.getTypesEntretien().contains(TypeEntretien.lavage90degres)){
			return new SacALinge(this.premier, this.sacALinge.extraireLingeABouillir());
		}
		else {
			return this.sacALinge.extraireLingeABouillir();
		}
	}
	
	//autre meth
	//creer un sac vide dans mainpour appeler la methode
	public void extraireLingeABouillir2(SacALinge sac){
		if (this.premier.getTypesEntretien().contains(TypeEntretien.lavage90degres))
			sac = new SacALinge(this.premier, sac); 
		extraireLingeABouillir2(sac.sacALinge);

	}
	
}

