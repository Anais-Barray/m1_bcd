package Listes;

public class ListeTableauStatistiques extends ListeTableau{
	private int CompteurNbrElement=0;
	private int CompteurAdd=0;
	private int CompteurTabPlusGrand=0;
	private int CompteurContains=0;
	private int CompteurGet=0;
	private int CompteurSize=0;

	public ListeTableauStatistiques() {}

	public ListeTableauStatistiques(int nbrElements, int tailleInitiale,
			int incrementTaille) {
		super(nbrElements, tailleInitiale, incrementTaille);
	}

	public void setNbrElement() {
		CompteurNbrElement++;
		super.setNbrElement();
	}

	public void add(Object element) {
		CompteurAdd++;
		super.add(element);
	}

	public Object[] TabPlusGrand() {
		CompteurTabPlusGrand++;
		return super.TabPlusGrand();
	}

	public boolean contains(Object o) {
		CompteurContains++;
		return super.contains(o);
	}

	public Object get(int index) {
		CompteurGet++;
		return super.get(index);
	}

	public int size() {
		CompteurSize++;
		return super.size();
	}

	public boolean equals(ListeTableauStatistiques l2) {
		//System.out.println("equals de lts");
		boolean b = super.equals(l2);
		//System.out.println("print "+ b);
		return b && (	this.getCompteurNbrElement() == l2.getCompteurNbrElement()
						&& this.getCompteurAdd() == l2.getCompteurAdd()
						&& this.getCompteurContains() == l2
								.getCompteurContains()
						&& this.getCompteurGet() == l2.getCompteurGet()
						&& this.getCompteurSize() == l2.getCompteurSize() && this
						.getCompteurTabPlusGrand() == l2
						.getCompteurTabPlusGrand());
	}
	//important, equals appellé de super incrémente le .size() de this mais pas l2. 

	public int getCompteurNbrElement() {
		return CompteurNbrElement;
	}

	public int getCompteurAdd() {
		return CompteurAdd;
	}

	public int getCompteurTabPlusGrand() {
		return CompteurTabPlusGrand;
	}

	public int getCompteurContains() {
		return CompteurContains;
	}

	public int getCompteurGet() {
		return CompteurGet;
	}

	public int getCompteurSize() {
		return CompteurSize;
	}



}


