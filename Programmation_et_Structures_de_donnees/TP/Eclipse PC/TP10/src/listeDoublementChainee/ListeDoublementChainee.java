package listeDoublementChainee;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



//TODO auto generated method stub : sq/noyau/amorce basique, ncssr de le completer

public class ListeDoublementChainee<E> implements List<E>{//eclipse : meth par defaut conforme a l'interface, écrite de façon minimale, besoin d'impléter les List
	//override : redéfinition, différent de surcharge (meme nom de fct avec nb param/types différents) = Même nom qu'une autre def° sur une sous classe qui remplace la meth héritée pour l'instance de cette sous classe.
	//liaison dynamique, meth invoquée correspond a celle du type dynamique du receveur.
	//pour redef une fct : pas changer la signature (meme nb/type de param), si autre => surcharge
	//la liaison dynamique ne fct qu'avec les redif, pas avec les surcharges.
	private Cellule<E> debut = null, fin =null;
	private int taille = 0;

	public ListeDoublementChainee() {}


	public String toString() {
		return "debut : " + this.getDebut() + " - fin : " + this.getFin() + " - taille : " + this.getTaille();
	}




	// -------------------- Methodes de l'interface List --------------------


	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return taille == 0 ;
	}

	/*
	public boolean contains(Object o) {
		for (E e : this){
			if (e.equals(o)){
				return true; // dès qu'il trouve qqch d'équivalent, fait le return => sort de la fct.
			}	
		}
		return false;
	}
	 */
	/*
	public boolean contains(Object o) {
		Cellule<E> res = debut;
		do {
			if (res.getValeur().equals(o))
			{return true;}
			res = res.getSuivant();
		} while (res != fin);

		return false;
	}
	 */

	public boolean contains(Object o) {
		Cellule<E> res = debut;
		while (res !=null){
			if (res.getValeur().equals(o)) {return true;}
			res = res.getSuivant();
		}
		return false;
	}



	public Iterator<E> iterator() {
		return null;
	}

	public Object[] toArray() {
		return null;
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

	public boolean remove(Object o) {
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		return false;
	}



	public void sort(Comparator<? super E> c) {
		throw new UnsupportedOperationException();
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public E get(int index) {
		if (index >= this.getTaille() || index < 0 || this.isEmpty()){
			return null;
		} else {
			Cellule<E> res = debut; // cell en pos 0
			for (int i = 1; i <= index; i++){
				res = res.getSuivant();
			}
			return res.getValeur();
		}
	}

	public Cellule<E> getCell(int index) {
		if (index >= this.getTaille() || index < 0 || this.isEmpty()){
			return null;
		} else {
			Cellule<E> res = debut; // cell en pos 0
			for (int i = 1; i <= index; i++){
				res = res.getSuivant();
			}
			return res;
		}
	}

	public E set(int index, E element) {
		return null;
	}

	public void add(int index, E e) {
		//boucle qui parcours la liste avec compteur, prendre en compte cas ou deb, fin, milieu.
		if (index == this.getTaille()){
			this.add(e);
		} else if (index >=0 && index < this.getTaille()){
			Cellule<E> cell = new Cellule<>();
			Cellule<E> actuelle = this.getCell(index);

			cell.setValeur(e);
			cell.setSuivant(actuelle);

			if (index == 0){
				this.debut=cell;
			} else {
				cell.setPrecedent(actuelle.getPrecedent());
				actuelle.getPrecedent().setSuivant(cell);
			} actuelle.setPrecedent(cell);
		} taille++;
	}

	public boolean add(E e){
		if (this.isEmpty()) {
			Cellule<E> newCell = new Cellule<>(null, e, null);
			debut = newCell;
			fin = newCell;

		} else {
			Cellule<E> newCell = new Cellule<>(fin, e, null);
			this.getFin().setSuivant(newCell);
			fin = newCell;
		}

		taille++;
		return true;
	}

	public E remove(int index) {
		if (index >= this.getTaille() || index < 0 || this.isEmpty()){
			System.out.println("Opération impossible");
			return null;
		} else {
			this.getCell(index).getSuivant().setPrecedent(this.getCell(index).getPrecedent());
			this.getCell(index).getPrecedent().setSuivant(this.getCell(index).getSuivant());
		}	
		taille--;
		return this.getCell(index).getValeur();
	}

	public int indexOf(Object o) {
		return 0;
	}

	public int lastIndexOf(Object o) {
		return 0;
	}

	public ListIterator<E> listIterator() {
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}



	// -------------------- Getters and Setters --------------------

	public Cellule<E> getDebut() {
		return debut;
	}

	public void setDebut(Cellule<E> debut) {
		this.debut = debut;
	}

	public Cellule<E> getFin() {
		return fin;
	}

	public void setFin(Cellule<E> fin) {
		this.fin = fin;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}



}
