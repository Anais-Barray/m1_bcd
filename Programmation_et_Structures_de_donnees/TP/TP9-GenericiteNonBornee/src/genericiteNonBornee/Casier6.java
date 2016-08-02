package genericiteNonBornee;


public class Casier6 {
	
	private Oeuf[] contenu;
	
	public Casier6(Oeuf[] structure)
	{
		if (structure.length==6)
			this.contenu = structure;
		else System.out.println("structure mal construite");
	}

	public void place(int indice, Oeuf oeuf)
	{
		if (indice >=0 && indice <6)
			if (contenu[indice] == null)
				contenu[indice]=oeuf;
			else System.out.println("place occupee");
		else System.out.println("indice incorrect");};
		
	public String toString(){
		String s="";
		for (Oeuf o:this.contenu) s+=o+" ";
		return s;
	}
	

	
	public static void main(String[] args) {
		Casier6 boiteOeufs = new Casier6(new Oeuf[6]);
		System.out.println(boiteOeufs);
		boiteOeufs.place(0, new Oeuf());
		boiteOeufs.place(7, new Oeuf());		
		boiteOeufs.place(0, new Oeuf());		
		boiteOeufs.place(1, new Oeuf());
		boiteOeufs.place(2, new Oeuf());
		boiteOeufs.place(5, new Oeuf());
		System.out.println(boiteOeufs);
	}
}