package genericiteNonBornee;

public class PaireHomogene<A> extends Paire<A, A>{ //homogene : un seul type

	public PaireHomogene() {}
	public PaireHomogene(A a, A b) {
		super(a,b);
	}
	
	public String toString(){return super.toString();}
	

	public static void main(String[] argv)
	{

		PaireHomogene<String> ph = new PaireHomogene<>("a", "b");
		//PaireHomogene<String> ph2 = new PaireHomogene<>("a", new Oeuf()); pas possible car pas type homogene.
		System.out.println(ph);
		//System.out.println(ph2);

	}

}
