
public class List { // Generico List<Item>

	private Node first; // first punterà al primo elemento (first.item)
	private int N; // Lunghezza della lista

	private class Node {
		int item; // valriabile generico Item itemnext.item ci da il valore(data) - Item item
		Node next; // punta all'elemento successivo
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int length() {
		return N;
	}

	public void insert(int item, int i) { // Inserimento in posizione i
		Node pred = first;
		Node nuovo = new Node(); // crea un nuovo nodo
		nuovo.item = item; // carichiamo il dato(item) sul nodo
		if (i == 1) { // inseriamo il nodo in prima posizione
			first = nuovo;
			first.next = pred; // first.next (primo elemento) deve puntare a null (first-->|item|next|-->null)
		} else { // int j=1 while(j+1<i) j++;...
			for (int j = 1; j < i - 1; j++) { // esiste almeno un elemento
				pred = pred.next; // scorriamo saltando la lista
			}
			nuovo.next = pred.next;
			pred.next = nuovo; // |pred.next| . | --> null
		}
		N++;
	}

	public void insertTesta(int item) {
		Node pred = first;
		Node nuovo = new Node(); // crea il nuovo nodo
		nuovo.item = item; // carichiamo il dato(item) sul nodo
		if (first == null) { // se la lista è vuota
			first = nuovo; // il nuovo elemento diventa il primo
			first.next = pred; // facciamo puntare il nuovo elemento(first) a null(pred=first=null)
		} else {
			while (pred.next != null) { // Esiste almeno un elemento
				pred = pred.next; // scorriamo la lista
			}
			nuovo.next = pred.next; // pred (first).next =null ...quindi dobbiamo far puntare il nuovo nodo a null
			pred.next = nuovo; // dopodiché il pred (first) punta al nuovo nodo
		}
	}

	public boolean ricerca(int element) {

		Node attuale = first;
		if (first == null)
			return false; // se la lista non ha elementi
		while (attuale != null) { // scorriamo la lista
			if (attuale.item == element) { // prima occorrenza si ferma
				return true;
			}
			attuale = attuale.next; // continua ad scorrere la lista
		}
		return false; // se non trova l'emento ritorna false
	}

	public int read(int i) {
		if (first == null) // Non ci sono elementi
			return -1; // (return null) siccome è un metodo int se first è null esce dal metodo
		Node attuale = first;
		for (int j = 1; j < i; j++) { // Esiste almeno un elemento int j=1 while(j<i) j++;
			attuale = attuale.next;
		}
		return attuale.item;
	}

	/*** Elimina elemento in posizione i *****/
	public void delete(int i) {
		if (first == null)// siccome è un metodo void
			return; // se first è null esce dal metodo (return senza niente)
		Node pred = first;
		if (i == 1) {	//Primo elemento
			first = first.next;	//first punta a null e quindi non ci sono elementi(first-->null)
		} else {
			for (int j = 1; j < i - 1; j++) { //int j=1 while(j+1<i) j++; ..
				pred = pred.next;			//scorriamo la lista
			}
			pred.next = pred.next.next; // pred.next(elemento da eliminare) deve puntare a null
		}
	}

	public void deleteElement(int element) {
		if (first == null)
			return; // siccome è un metodo voi se first è null esce dal metodo
		Node attuale = first;
		Node pred = null;
		while (attuale != null && attuale.item != element) { //esiste almeno un elemento ed e diverso da element
			pred = attuale;
			attuale = attuale.next;
		}
		if (attuale != null) {
			if (attuale == first) {	//Esiste solo un elemento
				first = first.next;
			} else {
				pred.next = attuale.next;
			}
		}
	}

	public String stampaLista() {
		String dataList = "";
		Node attuale = first;
		while (attuale != null) {
			dataList = dataList + attuale.item + "-->";
			attuale = attuale.next;
		}
		return dataList;
	}
	
	
	public void merging() {
		int[] a = {1,2,3,4,5};
		int[] b = {6,7,8,9,10};
		int[] c = new int[a.length+b.length];
		int j=0;
		for(int i=0;i<c.length;i++) {
			if(i<a.length) {
				c[i]=a[i];			
			}else {
				c[i]=b[i-a.length];	
			}		
		}
		
		for(int i=0;i<c.length;i++) {
		System.out.println(c[i]+" ");
		}	
	}
}

