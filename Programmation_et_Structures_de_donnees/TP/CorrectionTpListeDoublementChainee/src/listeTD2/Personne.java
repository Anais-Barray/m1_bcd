package listeTD2;

public class Personne 
{
	private String nom = null;
	private String prenom = null;
	private int age = 0;
	
	public Personne(String nom, String prenom, int age)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Personne)
		{
			Personne other = (Personne) o;
			return other.nom.equals(nom) && other.prenom.equals(prenom) && other.age==age;
		}
		return false;
	}
	
	public String toString()
	{
		return ""+nom+" "+prenom+" "+age;
	}
}