package genericiteBornee;

import java.util.ArrayList;

/**
 * @author abarray
 *
 * @param <T>
 */
public class FileAttenteSurInvitation<T extends IEstInvite> //alt shift R pour changer toutes les types qui sy rapportent
{
	private String nomFile;
	private static int nbElementsEntresTotal = 0;
	private ArrayList<T> contenu;

	public FileAttenteSurInvitation(){contenu=new ArrayList<>();}

	public void entre(T p){
		if (p.isInvited()){
			contenu.add(p); nbElementsEntresTotal++;
		}
		else System.out.println("non invite");
	}

	public T sort()
	{
		T p=null;
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
		for (T p:this.contenu)
			resultat += p + " ";
		return resultat;
	}

	public static int getNbPersonnesEntreesTotal()
	{
		return FileAttenteSurInvitation.nbElementsEntresTotal;
	}

	//	public static<T> boolean compareFile(FileAttenteSurInvitation<T> fa1, FileAttenteSurInvitation<T> fa2){ //comme méth statique, le param de généricité ne s'applique pas sur elle, donc on en introduit un nv.
	//		return ((fa1.getNomFile().equals(fa2.getNomFile())) && (fa1.getContenu().equals(fa2.getContenu())));
	//	}
	//est statique car prend deux FA en param, on applique pas cette fct a une FA

	public boolean compareFile2(FileAttenteSurInvitation<T> fa){
		return ((this.getNomFile().equals(fa.getNomFile())) && (this.getContenu().equals(fa.getContenu())));
	}

	public boolean compareLongueurFile(FileAttenteSurInvitation<T> fa){
		return (this.getContenu().size() == fa.getContenu().size()); //== car type primitif
	}


	public String getNomFile() {
		return nomFile;
	}

	public void setNomFile(String nomFile) {
		this.nomFile = nomFile;
	}

	public ArrayList<T> getContenu() {
		return contenu;
	}

	public static int getNbElementsEntresTotal() {
		return nbElementsEntresTotal;
	}

	public void setContenu(ArrayList<T> contenu) {
		this.contenu = contenu;
	}

	public void deplaceVers(FileAttenteSurInvitation<? super T> fasi){ // n'importe quoi dont T hérite. N'importe quoi tq que c'est un surtype de E.
		fasi.entre(this.sort());
	}

	public void deplaceDepuis(FileAttenteSurInvitation<? extends T> fasi){ 
		this.entre(fasi.sort());
	}

}
