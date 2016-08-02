package Tableaux;
import java.util.Scanner;

public class MonTableaudeCaracteres {

	private char contenu[];

	/*public MonTableaudeCaracteres(char[] contenu) {
		this.contenu = contenu;
	}
	*/
	public MonTableaudeCaracteres() {
		
	}

	public void affTab() {
		if (contenu==null){
			System.out.println("Tableau vide");
		}
		else{
			for (int i=0; i<this.contenu.length; i++)
				System.out.println("case = "+i+" valeur = "+this.contenu[i]+"\n");
		}
	}

	public void saisirEtCreer(Scanner c){
		System.out.println("taille du tableau :");
		int taille = c.nextInt();
		this.contenu = new char[taille];
		for (int i=0; i<taille; i++){
			System.out.println("contenu de la case "+i);
			contenu[i] = c.next().charAt(0);
		}
	}
	
	
	
	public int occurence(char x){
		int y=0;
		for (int i=0; i<this.contenu.length; i++){
			if (x==this.contenu[i]){
				y=y+1;
			}		
		}
		return y;
	}
		
	public void inverse(){	
		int n = this.contenu.length;
		char w;
		for (int i=0; i<n/2; i++){
			w=contenu[i];
			contenu[i]=contenu[n-1-i];
			contenu[n-1-i]=w;
		}
	}
		
	
	public char[] getContenu() {
		return contenu;
	}


	public void setContenu(char[] contenu) {
		this.contenu = contenu;
	}


}		