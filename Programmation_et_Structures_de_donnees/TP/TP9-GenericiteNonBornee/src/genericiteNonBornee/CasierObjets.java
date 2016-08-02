package genericiteNonBornee;



public class CasierObjets {
	
	private Object[] contenu;
	private static Object objetType;
	
	public CasierObjets(Object[] structure, Object objetType)
	{
		if (structure.length==6)
			{this.contenu = structure;CasierObjets.objetType=objetType;}
		else System.out.println("structure mal construite");
	}

	public void place(int indice, Object o)
	{
		if (indice >=0 && indice <6)
			if (contenu[indice] == null)
				if (o.getClass().equals(CasierObjets.objetType.getClass()))
					contenu[indice]=o;
				else System.out.println("objet qui n'est pas du type prevu "+ o.getClass().getName());
			else System.out.println("place occupee "+indice);
		else System.out.println("indice incorrect "+indice);};
		
	public String toString(){
		String s="";
		for (Object o:this.contenu) s+=o+" ";
		return s;
	}
	
	public Object get(int indice)
	{
		if (indice >=0 && indice <6)
			return contenu[indice];
		else System.out.println("indice incorrect");
		return null;
	}
	
	public static void main(String[] args) {
		
		/*   */
		CasierObjets boiteObjets1 = new CasierObjets(new Object[6], new Object());
		boiteObjets1.place(0, new Oeuf());
		boiteObjets1.place(0, new Bouteille());	
		for (Object o:boiteObjets1.contenu)
			if (o instanceof Oeuf)
				System.out.println(((Oeuf)o).taille());
			else if (o instanceof Bouteille)
				System.out.println(((Bouteille)o).getContenu());

		CasierObjets boiteObjets = new CasierObjets(new Oeuf[6], new Oeuf());
		System.out.println(boiteObjets);
		boiteObjets.place(0, new Oeuf());
		boiteObjets.place(7, new Oeuf());		
		boiteObjets.place(0, new Oeuf());		
		boiteObjets.place(1, new Oeuf());
		boiteObjets.place(2, new Oeuf());
		boiteObjets.place(5, new Oeuf());
		boiteObjets.place(3, new String());
		System.out.println(boiteObjets);
		System.out.println(((Oeuf)(boiteObjets.get(2))).taille());
	}
}
