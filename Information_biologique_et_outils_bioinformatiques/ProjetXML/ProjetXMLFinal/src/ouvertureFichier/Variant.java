package ouvertureFichier;

public class Variant {
	private String gene_name;

	public Variant(String gene_name) {
		this.gene_name = gene_name;
	}
	public String getName() {
		return gene_name;
	}
	public String toString() {
		return "variant : " + gene_name;
	}
}
