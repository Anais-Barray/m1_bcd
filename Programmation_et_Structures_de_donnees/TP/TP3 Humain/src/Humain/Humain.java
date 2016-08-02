package Humain;

public class Humain {
	//humain avec conjoint
	public Humain(String nom1, int age1, char sexe) {
		//constructeurs
		this.nom1 = nom1;
		this.age1 = age1;
		this.setSexe(sexe); //restriction par le mutateur set

	}

	//attributs
	private int age1;
	private char sexe;
	private Humain conjoint;
	private String nom1;

	//methodes
	public String toString(){
		return "nom : "+this.nom1+"\nage : "+this.age1+ "\nsexe : "+this.sexe+"\nconjoint : "+conjoint.nom1+"\n"; 
		//conjoint.nom et pas this.conjoint sinon boucle infinie.
	}

	public boolean estMarrie(){
		return (conjoint!=null);
		//si conjoint différent de null, retourne oui

	}
	public boolean estMajeur(){
		return (this.age1>18);
	}

	public  boolean estMarriable(){
		return (!(estMarrie()) && (estMajeur())); //false et true
	}

	public void ajouterConjoint(Humain h){
		this.setConjoint(h);
	}

	public void seMarrier(Humain h){
		if (this.estMarriable() && h.estMarriable()){
			this.ajouterConjoint(h); 
			h.ajouterConjoint(this);
			System.out.println("On se marrie");
		} else {
			System.out.println("ne peut pas se marrier");
		}
	}	

	public void enleverConjoint(){
		this.setConjoint(null);
	}

	public void seSeparer(){
		//if (this.estMarrie() && h.estMarrie()){
		this.enleverConjoint();
		//h.enleverConjoint(this);
		/*		} else {
			System.out.println("n'est pas marrié");
		}*/
	}	

	//accesseurs & mutateurs
	public int getAge1() {
		return age1;
	}
	public void setAge1(int age1) {
		this.age1 = age1;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		if ((sexe=='F') || (sexe=='M')){
			this.sexe = sexe;
		} else
			System.out.println("sexe inconnu"); //pourquoi si sexe pas bon, saffiche en haut et pas dans sexe: dans le toString
	}
	public Humain getConjoint() {
		return conjoint;
	}
	public void setConjoint(Humain conjoint) {
		/*if (conjoint == null);
		}	else*/
		this.conjoint = conjoint;
	}

	public String getNom1() {
		return nom1;
	}
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}


}