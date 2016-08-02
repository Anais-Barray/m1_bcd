package Quincaillerie;
import java.util.ArrayList;
import java.util.Collections;

public abstract class PieceComposite extends Piece {
	//attributs	
	private ArrayList <Piece> listeComposant = new ArrayList <Piece> (); 

	//constructeurs
	public PieceComposite() {}
	public PieceComposite(String s, String n) {
		super(s,n);
	}
	//methodes
	public String toString() {
		return "PieceComposite [" + super.toString() + "]";
	}

	public void ajoute(Piece p){
		listeComposant.add(p);
	}

	public double prix(){
		double s=0;
		for (Piece p : this.listeComposant){
			s+=p.prix();
		}
		return s;
	}

	public double dureeGarantie(){
		double min = listeComposant.get(0).dureeGarantie();
		for (Piece p : this.listeComposant){
			if (min>p.dureeGarantie()) {
				min=p.dureeGarantie();
			}
		}
		return min;		
	}

	public double dureeFabrication(){
		double max = 0;
		for (Piece p : this.listeComposant){
			if (max<p.dureeFabrication()) {
				max=p.dureeFabrication();
			}
		}
		return max;
	}


	public void afficheComposants(int n){
		System.out.println(this.tabule(n)+getNom() +" - " +reference());
		for (Piece p : this.getListeComposant()){
			p.affiche(n+1);
		}
	}


	public ArrayList<Piece> getListeComposant() {
		return listeComposant;
	}
}