package genericiteNonBornee;
import java.util.ArrayList;

public class FileAttente<E>
	{
		private String nomFile;
		private static int nbElementsEntresTotal = 0;
		private ArrayList<E> contenu;
		
		public FileAttente(){contenu=new ArrayList<E>();}
		
		public void entre(E p){contenu.add(p); nbElementsEntresTotal++;}
		
		public E sort()
			{
				E p=null;
				if (!contenu.isEmpty())
				{p=contenu.get(contenu.size()-1);      
	                   contenu.remove(contenu.size()-1);}
				return p;
			}
		
		public boolean estVide(){return contenu.isEmpty();}
		
		public String toString(){return ""+descriptionContenu();}
		
		private String descriptionContenu()
		{
			String resultat = "";
			for (E p:this.contenu)
				resultat += p + " ";
			return resultat;
		}
		
		public static int getNbPersonnesEntreesTotal()
		{
			return FileAttente.nbElementsEntresTotal;
		}
	
	public static void main(String[] args) {
		FileAttente<Personne> fp = new FileAttente<>();
		fp.entre(new Personne("Jeanne","Larivière"));
		FileAttente<Rectangle> fr = new FileAttente<>();
		fr.entre(new Rectangle(15,18));
	}

}
