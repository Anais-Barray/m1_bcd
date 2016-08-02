package VetementExam;
import java.util.ArrayList;

public class TenueTravail extends Vetement {



	private String nomTenue="nom inconnu";
	private boolean obligation=false;
	private ArrayList<String> metiersRecommandes = new ArrayList<>();


	public TenueTravail() {	}

	public TenueTravail(String d, String m,
			double pFN, double pFS, String nomTenue, boolean obligation) {	
		super(d,m,pFN,pFS);
		this.nomTenue=nomTenue;
		this.obligation=obligation;
		
	}

	public String toString() {
		return "TenueTravail [nomTenue=" + nomTenue + ", obligation="
				+ obligation + ", metiersRecommandes=" + metiersRecommandes
				+ ", aLabelNaturel()=" + aLabelNaturel() +" "
				+ super.toString() + "]";
	}

	public String usage() {
		return "usage professionnel";
	}
}
