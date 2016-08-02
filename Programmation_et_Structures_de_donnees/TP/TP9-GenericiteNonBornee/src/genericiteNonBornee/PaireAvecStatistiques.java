package genericiteNonBornee;

public class PaireAvecStatistiques<A,B> extends Paire<A,B>{

	private static int cptL1=0, cptL2=0, cptE1=0, cptE2=0;

	public PaireAvecStatistiques() {}
	public PaireAvecStatistiques(A a, B b) {
		super(a, b);
	}
	
	// ---------------- FONCTIONS ---------------- 
	public String toString(){return super.toString();}
	public void stat(){
		System.out.println(" ctpE1 : " + getCptE1() + " ctpE2 : " + getCptE2() + " ctpL1 : " +getCptL1() + " ctpL2 : " + getCptL2());
	
	}
	
	
	
	//  ----------------  SETTERS AND GETTER ---------------- 
	public A getFst(){
		cptL1++;
		return fst;}
	public B getSnd(){
		cptL2++;
		return snd;}
	public void setFst(A a){
		cptE1++;
		fst=a;}
	public void setSnd(B b){
		cptE2++;
		snd=b;}
	public static int getCptL1() {
		return cptL1;
	}
	public static int getCptL2() {
		return cptL2;
	}
	public static int getCptE1() {
		return cptE1;
	}
	public static int getCptE2() {
		return cptE2;
	}
	
	// ---------------- MAIN ---------------- 
	public static void main(String[] argv)
	{

		PaireAvecStatistiques<String, String> ph = new PaireAvecStatistiques<>("a", "b");
		PaireAvecStatistiques<String, String> ph2 = new PaireAvecStatistiques<>("a", "b");
		System.out.println("ph : " + ph);
		System.out.println("ph : " + ph2);
		ph.stat();
		ph.setFst("c");
		ph.setSnd("d");
		ph.setSnd("e");
		System.out.println("ph : " + ph);
		ph.stat();

	}

}
