package genericiteNonBornee;
import java.util.Date;

public class EntreeAgenda<TypeEvt> extends Paire<Date,TypeEvt>{ //introduction d'un seul nouveau type, Date étant déjà connu

	public EntreeAgenda() {
	}
	public EntreeAgenda(Date d, TypeEvt s){
		super(d,s);
	}

	public String toString(){return super.toString();}

	public static void main(String[] argv)
	{
		EntreeAgenda<String> ea1 = new EntreeAgenda<>(new Date(), " : mourante "); //pas besoin de préciser le type Date, seulement le type inconnu.
		System.out.println(ea1);

	}
}