package listesTD1;

import java.util.*;

public class ListeTableau implements List {
	
	private int nbrElements=0;
	private int tailleInitiale=10;
	private int incrementTaille=10;
	private Object[] contenu;
	
	public ListeTableau(){
		this.contenu = new Object[this.tailleInitiale];}
	
	public ListeTableau(int tailleInitiale){
		this.tailleInitiale=tailleInitiale;
		this.contenu = new Object[this.tailleInitiale];}

	@Override
	public boolean add(Object arg0) {
		if (this.nbrElements==contenu.length)
			{  // garder une reference vers le contenu actuel
				Object[] actuel = this.contenu;
			   //agrandir le tableau
				this.contenu = new Object[this.contenu.length+this.incrementTaille];
			   //recopier les valeurs precedentes
				for (int i=0; i<actuel.length; i++)
					{this.contenu[i] = actuel[i];}
				System.out.println("copie "+this);
			}
		// maintenant il y a de la place
		this.contenu[this.nbrElements]=arg0;
		nbrElements++;			
		return true;
	}

	@Override
	public void add(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		for (int i=0; i<this.nbrElements; i++)
			if (this.contenu[i].equals(arg0))
				return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int arg0) {
		if (this.nbrElements==0)
		return null;
		if (arg0 >=0 && arg0 <this.nbrElements)
			return this.contenu[arg0];
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return this.nbrElements==0;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.nbrElements;
	}

	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString()
	{
		String s="[";
		for (int i=0; i<this.nbrElements; i++)
			s+=this.contenu[i].toString()+", ";
		return s+"]";
	}
	
	
	
	public static void main(String[] a)
	{
		ListeTableau t1 = new ListeTableau(3);
		System.out.println(t1);
		t1.add("le");
		System.out.println(t1);
		t1.add("chat");
		System.out.println(t1);
		t1.add("dort");
		System.out.println(t1);
		t1.add("au");
		System.out.println(t1);
		t1.add("soleil");
		System.out.println(t1);
		System.out.println(t1.contains("dort"));
		System.out.println(t1.contains("lune"));
	}

}



	