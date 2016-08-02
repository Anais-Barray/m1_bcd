package Iterateurs;

public class Personne {
	private String nom="", prenom="";

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public boolean equals(Object o){ //redifinir comme ca plus de probleme si on créer deux new personnes de même nom/prénom, return true, avant return false car compare adresse mémoire (était des Object et non Personne)
		if (!(o instanceof Personne)){
			return false;
		}
		else {
			Personne p = (Personne) o;
			return (p.getNom().equals(this.getNom()) && (p.getPrenom().equals(this.getPrenom())));
		}	
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString(){return nom+" "+ prenom;}
}
