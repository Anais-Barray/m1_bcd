package listesTD1;

import java.util.AbstractList;


public class ListeTableau2<E> extends AbstractList<E>{
	
	private int nbElem=0;
	private int initSize=10;
	private int incrSize=10;
	private E[] content;
	
	public ListeTableau2(){
		content = (E[]) new Object[initSize];}
	
	public ListeTableau2(int n){
		this.initSize=n;
		this.content = (E[]) new Object[initSize];}

	@Override
	public E get(int arg0) {
		if (nbElem==0)
			return null;
			if (arg0 >=0 && arg0 <nbElem)
				return content[arg0];
			return null;
	}

	@Override
	public int size() {
		return nbElem;
	}
	
	@Override
	public E set(int arg0, E arg1) {
		
			if (arg0 >=0 && arg0 <nbElem){
				E temp = content[arg0];
				content[arg0]=arg1;
				return temp;}
			throw new IndexOutOfBoundsException();	}
	
	public static void main(String[] a)
	{
		ListeTableau2<String> t1 = new ListeTableau2<String>(3);
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