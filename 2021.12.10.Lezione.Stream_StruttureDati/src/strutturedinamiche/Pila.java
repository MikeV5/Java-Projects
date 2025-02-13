package strutturedinamiche;

import java.util.EmptyStackException;

import strutturedinamiche.Coda;


public class Pila<E> {

	private Nodo cima;

	public class Nodo {
		E dato;
		Nodo pros;
	}
	
	public Pila() {
		cima = null;
	}

	public boolean empty() {
		return cima == null;
	}

	public void push(E o) {
		Nodo t = new Nodo();
		t.dato = o;
		t.pros = cima;
		cima = t;
	}

	public E pop() {

		if (cima == null)
			throw new EmptyStackException();	
		else {
			E ris= cima.dato;
			cima=cima.pros;
			return ris;
		}
	}
	
	public String toString() {
		String s = "";
		for (Nodo nodo = cima; nodo != null; nodo = nodo.pros)
			s = s + nodo.dato.toString() + " ";
		return s;
	}

}
