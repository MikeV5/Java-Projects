package esercizi4;

import java.util.Random;
import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args) {

		// Soluzione1();

		int dim = 30, maxNum = 10;
		/********** Soluzione lab **********/
		dim = Integer.parseInt(args[0]); // Da int a stringa
		maxNum = Integer.parseInt(args[1]);

		if (dim <= 0)
			return;

		// inizializzazione dell'array
		int[] mioArray = new int[dim];
		// Riempire l'array
		Random r = new Random();
		for (int i = 0; i < mioArray.length; i++) {
			mioArray[i] = r.nextInt(maxNum + 1);
		}
		// stampa video
		for (int i = 0; i < mioArray.length; i++) {
			System.out.println("Posizione: " + i + " " + mioArray[i]);
		}

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

		System.out.println(DIM_ARRAY);
		System.out.println("Inserisci il valore massimo: ");
		int VAL_MAX = sc.nextInt();
		System.out.println(VAL_MAX);

		// inizializzazione del'array
		int[] myArray = new int[DIM_ARRAY];

		// Riempire l'array
		Random r = new Random();
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = r.nextInt(VAL_MAX + 1);
			// System.out.println(myArray[i]);
		}
		// Stampa array
		for (int tmp : myArray)
			System.out.println(tmp + " ");
		sc.close();
	}

}
