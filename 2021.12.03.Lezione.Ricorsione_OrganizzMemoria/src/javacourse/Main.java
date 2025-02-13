package javacourse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		// Domanda di esame: Zone di memoria in java
		// Definizioni di Heap- Stack(Pila) - Memoria statica
		// Printf: System.out.printf("Fattoriale di %d * (%d-1)",n,n-1)

		System.out.println(fibonacci(5));

		// f(7,7)= 3+f(8,5)=6+f(6,6)=
		// =6+3+f(7,4)=9+3+f(5,5)=
		//

		String prova = "ciao";
		String prova2 = "javajava"; // pref non è uguale a suff quindi l'equals e va in un loop infinito
		/*****************************************************************************************
		 ***** GLI STREAM *********************
		 ****************************************/
		FileReader fr = null;
		int c;
		String s;

		try {
			fr = new FileReader("file/prova.txt");

			BufferedReader br = new BufferedReader(fr);

			/*
			 * while(fr.read() != -1) { System.out.println((char)c); }
			 */
			// Con questi due metodi non verrà mai stampato questo nuovo while
			// perché lo stream è arrivato a fine file
			// per far stampare questo nuovo while dovremmo far ritornare lo stream
			// all'inizio
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}

	}

	/****************************************************
	 *** RICORSIONE ******************************
	 **************************************************/
	public static int f(String x) {
		int y = x.length();
		String pref = x.substring(0, y / 2);
		String suff = x.substring(y / 2);
		if (pref == suff)
			return 1234;
		else if (pref.equals(suff))
			return f(x + x);
		else
			return 5678;
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 0)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int f(int x, int y) {

		if (x + y <= 4)
			return y;
		else if (y > x)
			return 2 + f(x + 1, y + 2);
		else
			return 3 + f(y + 1, x - 2);
	}

}
