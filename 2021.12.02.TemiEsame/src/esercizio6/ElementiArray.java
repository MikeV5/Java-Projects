package esercizio6;

import java.util.LinkedList;

/*
Si scriva il codice del metodo
public static int[] diff(int[] a, int[] b)
che restituisce l'array che contiene tutti e soli gli elementi dell'array a che non sono presenti nell'array b. Si assuma
che il metodo venga sempre invocato con argomenti diversi da null. Alcuni esempi di esecuzione sono i seguenti (negli
esempi viene indicato con [] l'array vuoto, cioe' l'array di lunghezza zero):


a 				b 		  diff(a,b)
[1, 3, 5, 7, 9] [2, 4, 6] [1, 3, 5, 7, 9]
[1, 3, 5, 7, 9] [1, 5, 7] [3, 9]
[1, 1, 5, 7, 5] [1, 5] 	  [7]
[1, 1, 5, 5, 5] [1, 5, 7] []
[] 				[1, 5, 7] []
*/

public class ElementiArray {

	public static void main(String[] args) {
		int[] matrix1 = { 1, 3, 5, 7, 9 };
		int[] matrix2 = { 1, 5, 7 };

		int[] matrix3 = diff2(matrix1, matrix2);

		for (int i = 0; i < matrix3.length; i++) {
			System.out.print(matrix3[i] + ", ");
		}
	}

	/********************* METODI ****************************************/
	// SOLUZIONE FATTA DA ME
	public static int[] diff(int[] a, int[] b) {

		int[] arrayc = new int[a.length];
		int[] tmp = new int[a.length];

		int cont = 0, cont2 = 0;
		if (a != null && b != null) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (a[i] == b[j]) {
						arrayc[cont] = a[i];
						cont++;
					} else {
						tmp[cont2] = b[j];
						cont2++;
					}
				}
				cont = 0;
			}
		}
		return arrayc;
	}

	/*** SOLUZIONE DELLA PROF MANICARDI  ***/
	public static int[] diff2(int[] a, int[] b) {

		// Si crea una lista nella quale se inseriranno
		LinkedList<Integer> l = new LinkedList<Integer>();
		boolean isPresente = false;
		for (int i = 0; i < a.length; i++) {
			isPresente = false;
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) { // Verifica se ci sono elementi di "a" presenti nell'array "b"
					isPresente = true;
					break;
				}
			}
			// Se isPresente è false lo inserisci
			if (isPresente == false) { // (!isPresente)
				l.add(a[i]);
			}
		}
		// Array con gli elementi di "a" che non sono in "b"
		int[] diff = new int[l.size()]; // Si crea l'array con la dimensione della lista
		for (int k = 0; k < l.size(); k++) {
			diff[k] = l.get(k); // Si inseriscono gli elementi della lista nel nuovo array
		}
		return diff;

	}

	/*** SOLUZIONE DELLA PROF RIZZARDI ***/
	public static int[] diff3(int[] a, int[] b) {
		
		int conta = 0;
		//Array di boolean che ha la stessa dimensione di "a"
		//Quindi la posizione sarà true se presente elementi dell'array a in b
		boolean[] daEliminare = new boolean[a.length]; 
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b.length && !daEliminare[i]; j++)
				if (a[i] == b[j]) {
					daEliminare[i] = true;
					conta++;
				}
		int[] risultato = new int[a.length - conta]; 
		int k = 0;
		for (int i = 0; i < a.length; i++)
			if (!daEliminare[i]) //se daEliminare[i] è false lo inserisci nel nuovo array
				risultato[k++] = a[i];
		return risultato;
	}

}
