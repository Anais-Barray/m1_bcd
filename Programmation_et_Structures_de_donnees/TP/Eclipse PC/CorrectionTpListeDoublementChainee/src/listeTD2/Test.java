package listeTD2;
import java.util.List;
import java.util.ListIterator;
import java.lang.String;


public class Test {

	/**
	 * COMMENT TODO
	 * Method Name : main
	 * @param args
	 * @author Guillaume Artignan
	 * Date : 1 fvr. 2012 08:26:21
	 */
	public static void main(String[] args) 
	{
		Personne p1 = new Personne("Marianne", "Huchard",18);
		Personne p2 = new Personne("Artignan", "Guillaume",18);
		Personne p3 = new Personne("Hascoet", "Mountaz",18);
		
		List<Personne> li = new ListeDoublementChainee<Personne>();
		
		li.add(0,p1);
		li.add(1,p2);
		li.add(2,p1);
		li.add(3,p3);
		
		for(Personne p : li){
			System.out.println(p);	
		}
		
		
		ListePersonne<Personne> l = new ListePersonne<Personne>();
		
		ListIterator<Personne> p = li.listIterator();
	
//		System.out.println(p.hasNext());
//		System.out.println(p.next());
//		System.out.println(p.next());
//		System.out.println(p.next());
//		System.out.println(p.next());
//		System.out.println(p.next());
//		System.out.println(p.previous());
//		System.out.println(p.previous());
//		System.out.println(p.previous());
//		System.out.println(p.previous());
//		System.out.println(p.previous());
//		System.out.println("--------");
//		System.out.println(p.next());
//		System.out.println(p.next());
//		System.out.println(p.nextIndex());
//		System.out.println(p.nextIndex());
//		System.out.println(p.nextIndex());
//		System.out.println(p.nextIndex());
//
//		System.out.println(p.previousIndex());
//		System.out.println(p.previousIndex());
//		System.out.println(p.previousIndex());
//		System.out.println(p.previousIndex());
//		System.out.println(p.previousIndex());
		
	}

}