package genericiteNonBornee;

public class BouteilleEtiquetee<A> extends Bouteille{

	private A etiquette;

	public BouteilleEtiquetee(){}
	public BouteilleEtiquetee(A e){
		this.setEtiquette(e);
	}


	public String toString(){return super.toString() +" : "+ this.getEtiquette();}


	public A getEtiquette() {
		return etiquette;
	}
	public void setEtiquette(A etiquette) {
		this.etiquette = etiquette;
	}

	
	
	public static void main(String[] args) {

		BouteilleEtiquetee be1 = new BouteilleEtiquetee("lait écrémé Mattel");
		be1.setContenu("lait");
		System.out.println(be1);
		EtiquetteBouteille eb1 = new EtiquetteBouteille(70, "dudu", "1rueblabla", "nomnom", 1);
		BouteilleEtiquetee be2 = new BouteilleEtiquetee(eb1);
		be2.setContenu("alcool à dudu");
		System.out.println(be2);
	}

}