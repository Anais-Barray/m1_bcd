package Piles;
import java.util.Stack;

public class limitedStack <E> extends Stack<E> {
//sous classe : description additionnelle / différentielle de qqch
	private int nbMaxElem;
	
	public limitedStack() {
		this(3);//appelle le constructeur avec l'argument.
	}

	public limitedStack(int i) {
		nbMaxElem=i;
	}
	public limitedStack(E e) {
		nbMaxElem=10;
	}
	
	public E push(E e){
		if (this.size() < this.nbMaxElem) {
			super.push(e);
		} else {
			throw new FullStackException(); // Stack jamais plein. On crée une classe FSE pour un stack borné qui renvoi un msg.
		}
		//assert false; // rajouter -ea dans Run, Configuration, Argument => executer en mode "controle des assertions". Donc ici l'assertion arrete bien le programme. Par défaut, pas de verif des assertions.
		assert invariant();
		assert this.peek() == e;
		return this.peek();
	}

	
	private boolean invariant () {
		return (this.size() <= this.nbMaxElem);//si c'est faux, le programme s'arrete	
	}

	
	public static void main(String[] args) {
		
		Stack<Integer> ls1 = new limitedStack<>(2);
		Stack<Integer> ls2 = new limitedStack<>();
		Stack<String> ls3 = new limitedStack<>("");

		ls1.push(1);
		ls1.push(2);
		ls1.push(3);

		//ls2.push(1);
		//ls3.push("yolo");
		//ls2.pop();//EmptyStackException
		
		System.out.println(ls1);
		System.out.println(ls2);
		System.out.println(ls3);

	}

}
