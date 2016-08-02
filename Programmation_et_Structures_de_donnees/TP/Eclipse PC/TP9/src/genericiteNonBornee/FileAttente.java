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

	public static<Z> boolean compareFile(FileAttente<Z> fa1, FileAttente<Z> fa2){ //comme méth statique, le param de généricité ne s'applique pas sur elle, donc on en introduit un nv.
		return ((fa1.getNomFile().equals(fa2.getNomFile())) && (fa1.getContenu().equals(fa2.getContenu())));
	}
//est statique car prend deux FA en param, on applique pas cette fct a une FA
	
	public boolean compareFile2(FileAttente<E> fa){
		return ((this.getNomFile().equals(fa.getNomFile())) && (this.getContenu().equals(fa.getContenu())));
	}

	public<Y> boolean compareLongueurFile(FileAttente<Y> fa){
		return (this.getContenu().size() == fa.getContenu().size()); //== car type primitif
	}

	
	public String getNomFile() {
		return nomFile;
	}

	public void setNomFile(String nomFile) {
		this.nomFile = nomFile;
	}

	public ArrayList<E> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<E> contenu) {
		this.contenu = contenu;
	}

	public static void main(String[] args) {
		FileAttente<Personne> fp = new FileAttente<>();
		fp.entre(new Personne("Jeanne","Larivière"));
		FileAttente<Rectangle> fr = new FileAttente<>();
		fr.entre(new Rectangle(15,18));
		fp.setNomFile("fp");
		fr.setNomFile("fr");
		System.out.println(FileAttente.compareFile(fp, fp));
		System.out.println(fr.compareFile2(fr));
		System.out.println(fr.compareLongueurFile(fp));
		System.out.println(FileAttente.nbElementsEntresTotal);//variable globale de toutes les FA de tous les types
	}

}
