package ABR2;

public class main {

	public main() {
	}

	public static void main(String[] args) {
	/*	ABR<Integer> trois = new ABR<>(3);
		ABR<Integer> sept = new ABR<>(7);
		ABR<Integer> deux = new ABR<>(2);
		ABR<Integer> six = new ABR<>(6);
		ABR<Integer> neuf = new ABR<>(9);
		ABR<Integer> quatre = new ABR<>(deux,4,sept);
		ABR<Integer> cinq = new ABR<>(quatre,5, six);
		ABR<Integer> huit = new ABR<>(trois,8,neuf);
		System.out.println(cinq.rangeOrdreCroissant());
		//System.out.println(cinq.toStringDecalage(0));
*/

		ABR<Integer> a = new ABR<>();
		a = a.inserer(4).inserer(2).inserer(5).inserer(1).inserer(9);
		//a = a.inserer(2);
		//a = a.inserer(4);
		//ABR<String> a2 = new ABR<>();
		//a2.inserer("abc");
		System.out.println(a.toString());
		//System.out.println(a2);
		//System.out.println(a.toStringDecalage(0));
		
	}

}
