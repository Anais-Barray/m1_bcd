package listeTD2;
import java.util.Iterator;
import java.util.ListIterator;


public class ListeDoublementChaineeIterator<E> implements Iterator<E>, ListIterator<E>
{
	private Cellule<E> cell;
	private Cellule<E> debut;
	private Cellule<E> fin;
	private int index = 0;
	private boolean end = false;
	private boolean begin = true;
	

	public ListeDoublementChaineeIterator(Cellule<E> cell,Cellule<E> fin)
	{
		this.cell = cell;
		this.debut = cell;
		this.fin = fin;
	}
	
	@Override
	public boolean hasNext() 
	{
		return !end;
	}

	@Override
	public E next() 
	{
		E result = null;
		if (!end)
		{
			result = cell.getVal();
			if (cell.getSuivant()==null) end = true;
			else 
			{
				cell = cell.getSuivant();
				index++;
				begin = false;
			}

		}
		
		return result;
		
	}

	@Override
	public void remove(){}
	@Override
	public boolean hasPrevious() 
	{
		return cell.getPrecedent()!=null;
	}

	@Override
	public E previous() 
	{
		
		if (cell.getPrecedent()==null) return null;
		{
			cell = cell.getPrecedent();
			index--;
			end = false;
			if (cell.getPrecedent()==null) begin = true;
			return cell.getVal();	
		}		
	}

	@Override
	public int nextIndex() 
	{
		next();
		return index;
	}

	@Override
	public int previousIndex() 
	{
		previous();
		return index;
	}

	@Override
	public void set(E e) {
	}

	@Override
	public void add(E e) {
	}

}