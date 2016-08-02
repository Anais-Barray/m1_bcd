package genericiteNonBornee;

public class EtiquetteBouteille {
	private double degre;
	private String nomP;
	private String adrs;
	private String desc;
	private int qte;
	
	public EtiquetteBouteille() {}


	public EtiquetteBouteille(double d, String n, String a, String de, int q){
		this.degre=d;
		this.nomP=n;
		this.adrs=a;
		this.desc=de;
		this.qte=q;
	}
	
	public String toString() {
		return "EtiquetteBouteille [degre=" + degre + ", nomP=" + nomP
				+ ", adrs=" + adrs + ", desc=" + desc + ", qte=" + qte + "]";
	}
	
}
