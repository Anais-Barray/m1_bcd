//Correction examen 2014 session 1
// Anna Delest, relu et complété par Marianne Huchard

//Question 1
public enum TypePrivilege {
	premium,affaire
}
//Question 2 
public interface IPassager {
	String getName();
	String getPlaceNumber();
}

public interface IPassagerPrivilege extends IPassager {
TypePrivilege getPrivilege();
}

//Question 3
public class Passager implements IPassager {
	private String Name;
	private String PlaceNumber;

	public String getName() {
		return Name;
	}

	public String getPlaceNumber() {
		return PlaceNumber;
	}

	public Passager(String name, String placeNumber) {
		Name = name;
		PlaceNumber = placeNumber;
	}
}

//Question 4 Il faut la méthode getPrivilege pour implémenter l'interface IPassagerPrivilege
public class PassagerPrivilege extends Passager implements IPassagerPrivilege {
	private TypePrivilege privilege=TypePrivilege.premium;

	public PassagerPrivilege(String name, String placeNumber,
			TypePrivilege privilege) {
		super(name, placeNumber);
		this.privilege = privilege;
	}
	public TypePrivilege getPrivilege() {
		return privilege;
	}
}

//Question 5 
import java.util.ArrayList;
import java.util.Iterator;

public class SalleAttente{

	private ArrayList<IPassagerPrivilege> salonPrivilege = new ArrayList<IPassagerPrivilege>();
	private ArrayList<IPassager> salonNormal = new ArrayList<IPassager>();
	
	public SalleAttente() {
	}
}

//Question 6 
public void entre (IPassager p){
		if (p instanceof IPassagerPrivilege)
		salonPrivilege.add((IPassagerPrivilege) p);// on doit caster vers le type attendu dans un salonPrivilege car c'est un sous-type de IPassager  
	else salonNormal.add(p);	
	}
	
//Question 7
public class NumeroIncorrectException extends Exception{
	private String numero;
	public NumeroIncorrectException(String message, String numero) {
		super(message); this.numero = numero;//super fait référence à la classe Exception qui a un constructeur attendant une String
	}	
}

//Question 8
//Pour la classe Passager
public void setPlaceNumber(String n) throws NumeroIncorrectException{
		if (n.length()>=8) 
			throw new NumeroIncorrectException("numero trop long ", this.getPlaceNumber());
		this.PlaceNumber = n;
	}
// il ne faut pas faire une simple affectation dans le constructeur
// mais appeler la méthode setPlaceNumber
public Passager(String name, String placeNumber) throws NumeroIncorrectException {
		Name = name;
		this.setPlaceNumber(placeNumber); // pour vérifier le numéro de place

//Pour la classe PassagerPrivilege
public void setNumeroPlace(String n) throws NumeroIncorrectException{
		if (Integer.valueOf(n) > 10 && privilege == TypePrivilege.affaire)
			throw new NumeroIncorrectException("numero impossible pour classe affaire ", this.getPlaceNumber());
		super.setPlaceNumber(n);
	}
public PassagerPrivilege(String name, String placeNumber,
			TypePrivilege privilege) throws NumeroIncorrectException{
		super(name, placeNumber);
		this.privilege = privilege;
	}
	
	
//Question 9
public class SalleAttente implements Iterable<IPassager>{
	…
	public Iterator<IPassager> iterator() {
		return new IterateurSalleParPrivilege(salonPrivilege, salonNormal);
	}
}

public class IterateurSalleParPrivilege implements Iterator<IPassager> {
	private ArrayList<IPassagerPrivilege> lp;
	private ArrayList<IPassager> ln;
	private boolean privilege = true;
	private int curseur=0;
	
	public IterateurSalleParPrivilege(ArrayList<IPassagerPrivilege> lp, ArrayList<IPassager> ln) {
		this.lp = lp; this.ln = ln;
	}

	@Override
	public boolean hasNext() {
		return (privilege || (!privilege && curseur < ln.size()));
	}

	@Override
	public IPassager next() {
		IPassager passagerCourant = null;
		if (privilege)
		{
			passagerCourant = lp.get(curseur);
			curseur = curseur + 1;
			if (curseur == lp.size())
			{privilege = false; curseur = 0;}
		 
		}
		else
		{
			passagerCourant = ln.get(curseur);	
			curseur = curseur + 1;			
		}
		return passagerCourant;
	}

	@Override
	public void remove() {
		System.out.println("non implemente");
	}

}

//Question 10

public String appelerPassagers(){
		String s="";
		Iterator<IPassager> t = this.iterator();
		while (t.hasNext())
			s+=t.next().getPlaceNumber()+" ";
		return s;
	}

// Question 11

public static void main(String[] args) throws NumeroIncorrectException {
		Passager jean = new Passager("34");
		Passager dominique = new PassagerPrivilege("12",TypePrivilege.premium);
		Passager camille = new PassagerPrivilege("2",TypePrivilege.affaire);
		
		SalleAttente petunia = new SalleAttente();
		petunia.entre(jean); petunia.entre(dominique); petunia.entre(camille); 	 
		System.out.println(petunia.appelerPassagers());
}

// Question 12
I1 compile et s'exécute bien
I2 compile et s'exécute bien: consiste à sous-typer la collection, mais sans changer le paramètre de généricité, 
c'est autorisé car toute opération d'un Vector s'applique à une Stack (en Java)
I3 consiste à sous-typer le paramètre de généricité. Ce n'est pas autorisé 
(erreur de compilation) car une opération comme add(IPassager) ne s'applique pas 
à un Vector de IPassagerPrivilege.
Par exemple, add(IPassager) pourrait admettre un passager non privilégié, qu'il 
ne faudrait pas mettre dans Vector de IPassagerPrivilege.




