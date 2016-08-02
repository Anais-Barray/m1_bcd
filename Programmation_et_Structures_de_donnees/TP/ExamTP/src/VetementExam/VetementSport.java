package VetementExam;


public class VetementSport extends Vetement {
// Question 4
	private Sports typeSport;

	public VetementSport(String denomination, String marque,
			double pourcentageFibreNaturelle, double pourcentageFibreSynthetique, Sports typeSport) {
		super(denomination,marque, pourcentageFibreNaturelle, pourcentageFibreSynthetique);
		this.typeSport = typeSport;
	}
	
	
	public String toString(){
		return super.toString()+" Sport : "+ typeSport;
	}


	public String usage() {
		return null;
	}
	
}