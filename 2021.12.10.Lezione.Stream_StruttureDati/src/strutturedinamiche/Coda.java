package strutturedinamiche;

import strutturedinamiche.Pila;

public class Coda<E> {

	private Nodo primo, ultimo;

	public class Nodo {
		E dato;
		Nodo pros;
	}

	public Coda() {
		primo = ultimo = null;
	}

	public boolean empty() {
		return primo == null;
	}

	public void aggiungi(E o) {

		Nodo t = new Nodo();
		t.dato = o;
		t.pros = null;
		// inserimento del nodo
		if (primo == null) // caso di coda inizialmente vuota
			primo = ultimo = t;
		else { // caso di coda non vuota
			ultimo.pros = t; // collega il nuovo nodo dopo l'ultimo
			ultimo = t; // aggiorna il riferimento ultimo
		}
	}

	public E preleva() {
		if (primo == null)
			throw new CodaVuotaException();
		else {
			E risultato = primo.dato;
			primo = primo.pros;
			if (primo == null) // caso in cui la coda sia rimasta vuota
				ultimo = null;
			return risultato;
		}
	}

	public String toString() {
		String s = "";
		for (Nodo nodo = primo; nodo != null; nodo = nodo.pros)
			s = s + nodo.dato.toString() + " ";
		return s;
	}
}
