package Etudiant;
import java.util.Scanner;
public class Etudiant {

		public Etudiant() {
		
		}
	
		public Etudiant(String nometudiant, int age, int codeinscription,
			int codepays, SituationFinanciere sitfin) {
		this.nometudiant = nometudiant;
		this.age = age;
		this.setCodeinscription(codeinscription);
		this.setCodepays(codepays);
		this.setSitfin(sitfin);
	}
		
		public Etudiant(String nometudiant, double noteprog, double notesysteme,
			double notestage, int age, int codeinscription, int codepays, SituationFinanciere sitfin) {
		this.nometudiant = nometudiant;
		this.setNoteprog(noteprog);
		this.setNotesysteme(notesysteme);
		this.setNotestage(notestage);
		this.age = age;
		this.setCodeinscription(codeinscription);
		this.setCodepays(codepays);
		this.setSitfin(sitfin);
	}
		private String nometudiant;
		private double noteprog;
		private double notesysteme;
		private double notestage;
		private int age;
		private int codeinscription;
		private int codepays;
		private SituationFinanciere sitfin;
		
		public String toString(){
			return "nom et age de l'étudiant : "+this.nometudiant+" "+this.age+"\n"; 
		}
		
		public double moyenne(){
			
			return (noteprog+notesysteme+notestage)/3.0;
			
		}
		
		public String mention(){
			double moyenne;
			moyenne = (noteprog+notesysteme+notestage)/3.0;
				if (moyenne>=10){
				
					if (moyenne>=12){
											 
						if (moyenne>=14){
												
							if (moyenne>=16){
								return "mention très bien \n";	
							} 
							return "mention bien \n";
						}
						return "mention assez bien \n";
					}
					return "mention passable \n";
				}
					else{
							return "ajourné \n";
					}
		}
					
				
		public String ligneResultats(){
			double moyenne;
			moyenne = this.moyenne(); //prend une case mémoire, évite de faire plusieurs fois le calcul
			
			String ligneResultats;
			ligneResultats = "nom : " +this.nometudiant+" ."+this.sitfin+". La moyenne est de "+moyenne()+" "+mention();
			if (moyenne<10){
				if (noteprog>=10){
					ligneResultats = ligneResultats+" Module de Programmation validé.";
				}
				if (notesysteme>=10){
					ligneResultats = ligneResultats+" Module de Systeme validé.";
				}
				if (notestage>=10){	
					ligneResultats = ligneResultats+" Module de Stage validé.";
				}
			}
			return ligneResultats;
		}
		
		public void Saisie(Scanner clavier) {
		
		
		System.out.println("nom de l'étudiant :");
		this.nometudiant = clavier.next();
		System.out.println("!nom "+this.nometudiant);
		
		System.out.println("age de l'étudiant :");
		this.age = clavier.nextInt();
		System.out.println("!age "+this.age);
		
		System.out.println("code inscription (1 si premiere inscription, 2 si reinscription) :");
		this.codeinscription = clavier.nextInt();
		System.out.println("!inscription "+this.codeinscription);
				
		System.out.println("code pays (1 si etudiant francais, 2 si etranger non francophone, 3 si etranger francophone) :");
		this.codepays = clavier.nextInt();
		System.out.println("!pays "+this.codepays);
		
		System.out.println("note de programmation :");
		this.setNoteprog(clavier.nextDouble())  ;
		System.out.println("!prog "+this.noteprog);
		
		System.out.println("note de systeme :");
		this.setNotesysteme(clavier.nextDouble());
		System.out.println("!system "+this.notesysteme);
		
		System.out.println("note de stage :");
		this.setNotestage(clavier.nextDouble());
		System.out.println("!stage "+this.notestage);
		
		System.out.println("Situation financiere (boursier, salarie, autre) :");
		SituationFinanciere v = SituationFinanciere.valueOf(clavier.next());
		this.setSitfin(v);
		System.out.println("!sitfin "+this.sitfin);
		
		clavier.close();
		
		}
		
		
		public String getNometudiant() {
			return nometudiant;
		}
		public void setNometudiant(String nometudiant) {
			this.nometudiant = nometudiant;
		}
		public double getNoteprog() {
			return noteprog;
		}
		public void setNoteprog(double noteprog) {
			if (noteprog>20 || noteprog<0) 
				System.out.println("note incorrecte");

			else 
				this.noteprog = noteprog;
		}
		public double getNotesysteme() {
			return notesysteme;
		}
		public void setNotesysteme(double notesysteme) {
			if (notesysteme>20 || notesysteme<0) {
				System.out.println("note incorrecte");
			}
			else 
				this.notesysteme = notesysteme;
		}
		public double getNotestage() {
			return notestage;
		}
		public void setNotestage(double notestage) {
			if (notestage>20 || notestage<0) 
				System.out.println("note incorrecte");

			else 
				this.notestage = notestage;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getCodeinscription() {
			return codeinscription;
		}
		public void setCodeinscription(int codeinscription) {
			if (codeinscription>2 || codeinscription<1) {
				System.out.println("erreur");
			}
			else 
				this.codeinscription = codeinscription;
		}
		public int getCodepays() {
			return codepays;
		}
		public void setCodepays(int codepays) {
			if (codepays>3 || codepays<1) {
				System.out.println("erreur");
			}
			else 
				this.codepays = codepays;
		}
	

		public void setSitfin(SituationFinanciere sitfin) {
			this.sitfin = sitfin;	
		}
		
		public SituationFinanciere getSitfin() {
			return sitfin;
		}

}