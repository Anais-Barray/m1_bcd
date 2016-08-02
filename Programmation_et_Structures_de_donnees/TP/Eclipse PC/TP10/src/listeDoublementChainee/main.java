package listeDoublementChainee;


	public class main {

		public static <E> void main(String[] args) {
			/*Cellule<Integer> c1 = new Cellule<>(null, 1 , null);
			Cellule<String> c2 = new Cellule<>(null, "deux", null);
			Cellule<Integer> c3 = new Cellule<>(null, 3 , null);
			Cellule<String> c4 = new Cellule<>(null, "quatre", null);*/
			ListeDoublementChainee<Integer> ldc1 = new ListeDoublementChainee<>();
			ldc1.add(1);
			ldc1.add(2);
			ldc1.add(3);
			ListeDoublementChainee<String> ldc2 = new ListeDoublementChainee<>();
			ldc2.add("un");
			ldc2.add("deux");
			ldc2.add("trois");
			System.out.println(ldc1);
			System.out.println(ldc2);
			System.out.println("liste contient 1? " +ldc1.contains(1));
			System.out.println("liste contient 1? " +ldc2.contains(1));
			System.out.println("element a la position 1? " + ldc1.get(1));
			//System.out.println(ldc2.get(1));
			System.out.println("element à la position 1 suite à la suppression : "+ldc1.remove(1));
			//ldc2.remove(1);
			System.out.println("element a la position 1? " + ldc1.get(1));
			//System.out.println(ldc2.get(1));


		}

	}
