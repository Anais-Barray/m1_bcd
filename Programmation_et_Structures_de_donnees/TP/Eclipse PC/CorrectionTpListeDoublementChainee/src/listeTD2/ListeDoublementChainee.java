package listeTD2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Guillaume Artignan Date : 31 janv. 2012 15:31:47
 */

public class ListeDoublementChainee<E> implements List<E> {
	private Cellule<E> debut = null;
	private Cellule<E> fin = null;
	private int taille = 0;

	@Override
	public int size() {
		return taille;
	}

	@Override
	public boolean isEmpty() {
		return taille == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (isEmpty())
			return false;
		else {
			Cellule<E> courante = debut;
			boolean trouve = false;
			while (!trouve && courante != null) {
				if (courante.getVal().equals(o)) trouve = true;
				else courante = courante.getSuivant();
			}
			return trouve;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ListeDoublementChaineeIterator<E>(debut, fin);
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		Cellule<E> current = debut;
		int cpt = 0;
		while (current != null) {
			array[cpt] = current.getVal();
			current = current.getSuivant();
			cpt++;
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		T[] array = a;
		Cellule<E> current = debut;
		int cpt = 0;
		while (current != null) {
			array[cpt] = (T) current.getVal();
			current = current.getSuivant();
			cpt++;
		}
		return array;
	}

	@Override
	public boolean add(E e) {
		Cellule<E> newcell = new Cellule<E>(null, e, null);
		if (isEmpty()) {
			debut = newcell;
			fin = newcell;
		} else {
			fin.setSuivant(newcell);
			newcell.setPrecedent(fin);
			fin = newcell;
		}
		taille++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (isEmpty())
			return false;
		else {
			Cellule<E> courante = debut;
			boolean trouve = false;
			while (!trouve && courante != null) {
				if (courante.getVal().equals(o))
					trouve = true;
				else courante = courante.getSuivant();
			}
			if (trouve) {
				if (debut == courante) debut = courante.getSuivant();
				if (fin == courante) fin = courante.getPrecedent();
				if (courante.getPrecedent() != null)
					courante.getPrecedent().setSuivant(courante.getSuivant());
				if (courante.getSuivant() != null)
					courante.getSuivant().setPrecedent(courante.getPrecedent());
				courante.setSuivant(null);
				courante.setPrecedent(null);
				taille--;
			}
			return trouve;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator it = c.iterator();
		boolean contient = true;
		while (it.hasNext() && contient) {
			if (!this.contains(it.next()))
				contient = false;
		}
		return contient;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		debut = null;
		fin = null;
		taille = 0;
	}

	@Override
	public E get(int index) {
		if (index >= size() || index < 0)
			return null;
		else {
			Cellule<E> courante = debut;
			int compteur = 0;
			while (compteur != index) {
				courante = courante.getSuivant();
				compteur++;
			}
			return courante.getVal();
		}
	}

	@Override
	public E set(int index, E element) {
		if (index >= size() || index < 0)
			return null;
		else {
			Cellule<E> courante = debut;
			int compteur = 0;
			while (compteur != index) {
				courante = courante.getSuivant();
				compteur++;
			}
			E returntype = courante.getVal();
			courante.setVal(element);
			return returntype;
		}
	}

	@Override
	public void add(int index, E element) {
		if (index == size()) {
			add(element);
		} else if (index == 0) {
			Cellule<E> c = new Cellule<E>(null, element, debut);
			debut.setPrecedent(c);
			debut = c;
			taille++;
		} else if (index < size() && index > 0) {
			Cellule<E> courante = debut;
			int compteur = 0;
			while (compteur != index) {
				courante = courante.getSuivant();
				compteur++;
			}
			Cellule<E> precedente = courante.getPrecedent();
			Cellule<E> c = new Cellule<E>(precedente, element, courante);
			precedente.setSuivant(c);
			courante.setPrecedent(c);
			taille++;
		}
	}

	@Override
	public E remove(int index) {
		if (index >= size() || index < 0)
			return null;
		else {
			Cellule<E> courante = debut;
			int compteur = 0;
			while (compteur != index) {
				courante = courante.getSuivant();
				compteur++;
			}

			if (debut == courante)
				debut = courante.getSuivant();
			if (fin == courante)
				fin = courante.getPrecedent();
			if (courante.getPrecedent() != null)
				courante.getPrecedent().setSuivant(courante.getSuivant());
			if (courante.getSuivant() != null)
				courante.getSuivant().setPrecedent(courante.getPrecedent());

			courante.setSuivant(null);
			courante.setPrecedent(null);
			taille--;

			return courante.getVal();
		}
	}

/*	@Override
	public int indexOf(Object o) {
	    //à faire
	}

	/**
	 * Retourne le dernier indice de l'四士ent dans la liste Overriding Method
	 * Name : lastIndexOf
	 
	@Override
	public int lastIndexOf(Object o) {
	    //à faire
	}*/
	
	@Override
	public ListIterator<E> listIterator() {
		return new ListeDoublementChaineeIterator<E>(debut, fin);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new ListeDoublementChaineeIterator<E>(debut, fin);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	/**
	 * Donne une représentation sous forme de chaine de caract俊e de la liste
	 * Overriding Method Name : toString
	 * 
	 * @return
	 * @author Guillaume Artignan Date : 1 f思r. 2012 08:43:44
	 */
	public String toString() {
		Cellule<E> current = debut;
		String s = "[";
		while (current != null) {
			s += current.getVal().toString();
			current = current.getSuivant();
			if (current != null)
				s += ",";
		}
		s += "]";
		return s;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}