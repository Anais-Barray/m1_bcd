package adb;


public class ADB<E> implements IADB<E> {
	private E etiquette;
	private ADB<E> sousArbreVrai, sousArbreFaux;

	public ADB() {}
	public ADB(E etiquette) {this.etiquette = etiquette;}
	public ADB(E etiquette, ADB<E>sousArbreVrai, ADB<E> sousArbreFaux) {
		this.etiquette = etiquette;
		this.sousArbreVrai = sousArbreVrai;
		this.sousArbreFaux = sousArbreFaux;
	}


	@Override
	public boolean estVide() {
		return this.etiquette == null;
	}

	@Override
	public E getEtiquette() {
		return this.etiquette;
	}

	@Override
	public ADB<E> getSousArbreVrai() {
		return this.sousArbreVrai;
	}

	@Override
	public ADB<E> getSousArbreFaux() {
		return this.sousArbreFaux;
	}

	public boolean estFeuille() {
		return this.sousArbreVrai == null && this.sousArbreFaux == null;
	}

	public String toString() //affichage prefixe
	{
		if (this.estFeuille())
			return ""+this.getEtiquette();
		else
			return this.getEtiquette() + "\n" //ctrl shift f
					+ this.getSousArbreVrai().toString() + "\n"
					+ this.getSousArbreFaux().toString();
	}

	//Q2
	public String tabule(int n){
		String st = "";
		for (int i=0; i<n; i++){
			st+="\t";
		}
		return st;
	}
	
	public String toStringDecalage(int n) //affichage prefixe
	{
		if (this.estFeuille())
			return ""+tabule(n)+this.getEtiquette();
		else {
			return ""+tabule(n)+this.getEtiquette() + "\n" 
					+ this.getSousArbreVrai().toStringDecalage(n+1) + "\n"
					+ this.getSousArbreFaux().toStringDecalage(n+1);
		}
	}

	//Q3
	public boolean existeEtiquette(String e){
		if (this.etiquette.equals(e)){
			return true;
		} 
		if (this.estFeuille() && !this.etiquette.equals(e)){
			return false;
		}
		else {
			return (this.getSousArbreFaux().existeEtiquette(e) || this.getSousArbreVrai().existeEtiquette(e));
		}
	}

	//Q4
	public int getNbFeuille(){
		if (this.estFeuille()){
			return 1;
		}
		else {
			return (this.getSousArbreFaux().getNbFeuille() +  this.getSousArbreVrai().getNbFeuille());
		} 
	}

	//Q5
	public int getNbNoeud(){
		if (!this.estFeuille()){
			return (1 + this.getSousArbreFaux().getNbNoeud() + this.getSousArbreVrai().getNbNoeud());
		}
		else {
			return 0;
		}
	}

	//Q projet : Retourner la hauteur d'un ADB (longueur d'une plus longue branche)
	public int getHauteur(){
		if (!this.estFeuille()){ //profondeur d'un noeud
			return (1+Math.max(this.getSousArbreFaux().getHauteur(),this.getSousArbreVrai().getHauteur())); //retourne la longueur maximale entre deux sous-arbres +1 
		}
		else { //profondeur d'une feuille
			return 1;
		}
	}

}

