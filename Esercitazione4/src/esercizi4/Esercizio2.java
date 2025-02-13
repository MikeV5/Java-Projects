package esercizi4;

import java.util.Random;
import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) {
		Soluzione1();
	}

	public static void Soluzione1() {

		// lettura input
		Scanner sc = new Scanner(System.in);
		// Dimensione dell'array, 2 max numero
		System.out.println("Inserisci la dimensione dell'array: ");
		int DIM_ARRAY = sc.nextInt();
		if (DIM_ARRAY <= 0) {// controllo se non si passa un argomento
			System.err.println("Dimensione array non valida");
			sc.close();
			return;
		}
		System.out.println("Inserisci il valore massimo: ");
		int VAL_MAX = sc.nextInt();
		/**********************************************************/
		// inizializzazione del'array
		int[] myArray = new int[DIM_ARRAY];

		// Riempire l'array
		Random r = new Random();
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = r.nextInt(VAL_MAX + 1);
		}
		// Stampa array
		System.out.println("Array a: " + StampaArray(myArray));
		int[] temp = Reverse(myArray);
		// Stampa arrayReverse
		System.out.println("Reverse: " + StampaArray(temp));
		/********************************************************/
		// Array b
		int[] myArray2 = new int[DIM_ARRAY];
		for (int i = 0; i < myArray2.length; i++) {
			myArray2[i] = r.nextInt(VAL_MAX + 1);
		}
		System.out.println("Array b: " + StampaArray(myArray2));

		int[] maxA = MaxArray(myArray, myArray2);
		System.out.println("Max a e b: " + StampaArray(maxA));
		sc.close();
	}

	public static int[] Reverse(int[] a) {
		int[] arrayReverse = new int[a.length];
		int j = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			arrayReverse[j] = a[i];
			j++;
		}
		return arrayReverse;
	}

	public static String StampaArray(int[] myArray) {

		String s = "{ ";
		for (int i = 0; i < myArray.length; i++) {
			s += myArray[i] + (i < myArray.length - 1 ? " ," : "");
		}
		return s + "}";
	}

	public static int[] MaxArray(int[] a, int[] b) {
		int maxAr[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			maxAr[i] = (a[i] >= b[i]) ? a[i] : b[i];
			/*
			 * if(a[i]>=b[i]) { maxAr[i]=a[i]; }else { maxAr[i]=b[i]; }
			 */
		}
		return maxAr;
	}


	
}
