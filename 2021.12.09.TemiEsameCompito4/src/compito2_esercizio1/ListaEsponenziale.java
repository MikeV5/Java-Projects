package compito2_esercizio1;

import java.util.LinkedList;

/*
Scrivere poi una classe ListaEsponenziale in grado di rappresentare insiemi di oggetti di tipo Esponenziale. 
Denire un costruttore vuoto e un costruttore che prenda in ingresso una lista di oggetti di tipo Esponenziale.
Denire i metodi per: 
(1) restituire la lista, 
(2) restituire la lista sotto-forma di array di tipo Esponenziale.
*/
public class ListaEsponenziale {

	private LinkedList<Esponenziale> lista;

	public ListaEsponenziale() {
		lista = new LinkedList<Esponenziale>();
	}

	public ListaEsponenziale(LinkedList<Esponenziale> l) {
		lista = l;
	}

	public LinkedList<Esponenziale> getLista() {
		return lista;
	}

	public Esponenziale[] arrayLista() {
		Esponenziale[] a = new Esponenziale[lista.size()];

		int i = 0;
		for (Esponenziale tmp : lista)
			a[i++] = tmp;
		return a;
	}
	
}
