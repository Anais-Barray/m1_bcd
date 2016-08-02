package Listes;

public class ListeTableau implements Listeuh {

	protected int nbrElements=0;
	protected int tailleInitiale=5;
	protected int incrementTaille=5;
	protected Object[] contenu = new Object[tailleInitiale];

	public void setNbrElement(){
		int n=0;
		for (Object o : this.contenu){
			n++;
		}
		nbrElements=n;
	}

	public ListeTableau() {	}
	public ListeTableau(int nbrElements, int tailleInitiale,
			int incrementTaille) {
		this.nbrElements = nbrElements;
		this.tailleInitiale = tailleInitiale;
		this.incrementTaille = incrementTaille;
	}

	public void add(Object element) {
		if (nbrElements==tailleInitiale){
			contenu=this.TabPlusGrand();
			tailleInitiale+=incrementTaille;
		}
		contenu[nbrElements]=element;
		nbrElements++;
	}

	public Object[] TabPlusGrand(){
		Object[] t2 = new ListeTableau[this.nbrElements+this.incrementTaille];
		for (int i=0; i<this.nbrElements; i++){
			t2[i]=this.contenu[i];	
		}
		return t2;
	}

	public boolean contains(Object o) {
		int i=0;
		while (i<nbrElements){
			if (contenu[i].equals(o)){
				return true;
			}
			i++;
		}
		return false;
	}

	public Object get(int index) {
		if (index>=0 && index<nbrElements){
			return contenu[index];
		}
		else 
			return null;
	}

	public int size() { //pas length car fait appelle a du calcul pour l'ordi, pas besoin car on a l'info
		return nbrElements;
	}


	public boolean equals(ListeTableau l2){
		System.out.println("print de lt");
		if (this.size()!=l2.size()){
			return false;
		}
		else{
			for (int i=0; i<this.nbrElements; i++){
				if (!(this.get(i).equals(l2.get(i)))){
					return false;
				}
			}
			return true;
		}
	}

}
