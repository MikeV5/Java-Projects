package prova;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int  value;      // to hold data entered by the user
	      int  sum = 0;    // initialize the sum
	      char choice;     // to hold 'y' or 'n'

	      // Create a Scanner object for keyboard input.
	      Scanner parola = new Scanner(System.in);
	      String s = "";
	      do
	      {
	    	  
	         // Get the value from the user.
	         System.out.println("Inserisci una parola: ");
	     	s = parola.next();
	    
	     	s=s+"gg";

	     	  System.out.println(s);
	    	  
	         System.out.println("Vuoi continuare?(si/no)");
	         choice = parola.next().charAt(0);
	      }
	      while ((choice == 's') || (choice == 'S'));


	   
		
		/*
		Scanner parola = new Scanner(System.in);
		
		char continua;
		do {
			System.out.println("Inserisci parola");
			s = parola.nextLine();
			String stringaGenerata = stringaRandom(s);
			System.out.println(stringaGenerata);
			System.out.println("Vuoi continuare?(si/no)"); 
		//	continua=parola.next().charAt(0);
			s = parola.nextLine();

		} while (!s.equals("no"));
		
		*/

		/*
		 * String a = "prova"; String b = "aropv";
		 * 
		 * char d = 'v'; int id = b.indexOf(d); //System.out.println(id);
		 * 
		 * for (int i = 0; i < a.length(); i++) { char c = a.charAt(i); int idx =
		 * b.indexOf(c); System.out.println("i > "+i+" idx > "+idx); b = b.substring(0,
		 * idx) + b.substring(idx + 1); System.out.println(b); }
		 */
		/*
		 * 
		 * int[] matrix = {-8,2,-3,-1,-4,1,256 }; int[] matrix2 =
		 * selezionaMultipliDi(2,matrix);
		 * 
		 * 
		 * for (int i = 0; i < matrix.length; i++) System.out.print(matrix[i]+", ");
		 * System.out.println();
		 * 
		 * for (int i = 0; i < matrix2.length; i++) System.out.print(matrix2[i]+", ");
		 * System.out.println();
		 */
		/*
		 * 
		 * int x = -1; int y = 1;
		 * 
		 * do { x = x + 2; y = y + 3; if (x == -y) x = y; System.out.println("x: "+x);
		 * System.out.println("y: "+y); } while (x != y);
		 * 
		 */

		/*
		 * Scanner parola= new Scanner(System.in); String s=""; char continua; do {
		 * System.out.println("Inserisci parola"); s= parola.nextLine(); String
		 * stringaGenerata= stringaRandom(s); System.out.println(stringaGenerata);
		 * System.out.println("Vuoi continuare?(si/no)"); // continua=
		 * parola.next().charAt(0); s= parola.nextLine();
		 * 
		 * 
		 * }while(!s.equals("no"));
		 * 
		 * 
		 */
		/*
		 * int[] matrix= {1,2,3,4,5}; int[] matrix2=copiaFinoA(matrix,5); for (int i =
		 * 0; i < matrix.length; i++) System.out.println(matrix[i]);
		 * System.out.println(); for (int i = 0; i < matrix2.length; i++)
		 * System.out.println(matrix2[i]);
		 * 
		 * 
		 * 
		 */
		/*
		 * int[][] matrix= new int[5][5]; int k=0; while(k<matrix.length) {
		 * matrix[0][k]=k+1; matrix[1][k]=k+3; matrix[2][k]=k+2; matrix[3][k]=k+3;
		 * matrix[4][k]=k+1; // matrix[5][k]=k+1; k++; }
		 * 
		 * 
		 * System.out.println(stampaMatrice(matrix)); boolean c=isPalindroma(matrix);
		 * System.out.println(c); /*
		 * 
		 * String tmp = ""; String[] rigaTot = new String[matrix.length];
		 * 
		 * for (int i = 0; i < matrix.length; i++) { for (int j = 0; j <
		 * matrix[0].length; j++) { tmp=tmp+matrix[i][j];
		 * 
		 * }
		 * 
		 * rigaTot[i]=tmp; tmp=""; }
		 * 
		 * int cont=0; for (int i = 0; i < rigaTot.length; i++)
		 * System.out.println(rigaTot[i]);
		 * 
		 */

		//
		// System.out.println(cont);
		/*
		 * 
		 * 
		 * for (int i = 0; i < rigaTot.length; i++) System.out.println(rigaTot[i]);
		 */

		// System.out.println(f(5, 6));

		/*
		 * int A = -1; int B; for ( B = 0; B <= 2; B++) if (B % 2 == 0) A++; else A +=
		 * B;
		 * 
		 *
		 */
		/*
		 * int cont = 0; Random r = new Random(); int[][] matrix = new int[5][3]; for
		 * (int i = 0; i < matrix.length; i++) { // righe for (int j = 0; j <
		 * matrix[0].length; j++) { // colonne matrix[i][j] = r.nextInt(8) + 2; ;
		 * 
		 * } }
		 * 
		 * boolean b = occorrenzeInteroMatrice2(matrix, 2, 2);
		 * System.out.println(stampaMatrice(matrix)); System.out.println(b);
		 */
	}

	public static boolean anagramma(String a, String b) {
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			int idx = b.indexOf(c);
			if (idx < 0)
				return false;
			b = b.substring(0, idx) + b.substring(idx + 1);
		}
		return true;
	}

	public static int[] selezionaMultipliDi(int num, int[] a) {
		if (a == null || a.length == 0)
			return null;
		int contMult = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % num == 0)
				contMult++;
		}
		if (contMult != 0) {
			int cont = 0;
			int[] b = new int[contMult];
			for (int i = 0; i < a.length; i++) {
				if (a[i] % num == 0) {
					b[cont] = a[i];
					cont++;
				}
			}
			return b;
		}
		return null;
	}

	public static String stringaRandom(String a) {
		return a + "aa";

	}

	public static int[] copiaFinoA(int[] a, int pos) {
		int[] b = new int[pos + 1];
		for (int i = 0; i <= pos; i++) {
			b[i] = a[i];

		}
		return b;
	}

	public static int[] reverse(int[] a) {
		if (a == null)
			return null;
		int[] b = new int[a.length];
		for (int i = a.length - 1, k = 0; i >= 0; i--, k++) {
			b[k] = a[i];

		}
		return b;

	}

	public static boolean isPalindroma(int[][] matrix) {

		String tmp = "";
		String[] rigaTot = new String[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				tmp = tmp + matrix[i][j];

			}

			rigaTot[i] = tmp;
			tmp = "";
		}
		for (int i = 0; i < (rigaTot.length) / 2; i++) {
			if (rigaTot[i] != rigaTot[rigaTot.length - (i + 1)])
				return false;
		}
		return true;

	}

	public static boolean isPalindroma2(int[][] matrix) {

		for (int i = 0; i < (matrix.length) / 2; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] != matrix[matrix.length - i - 1][j])
					return false;
		return true;

	}

	public static int f(int x, int y) {

		if (x <= 1 && y <= 3)
			return x + y;
		else
			return f(x - y, x - 1) - f(y - 2, x - 1);

	}

	public static boolean occorrenzeInteroMatrice(int[][] a, int k, int n) {

		int c = 0;
		for (int i = 0; i < a.length; i++) {
			c = 0;
			int j = 0;
			while (j < a[i].length && c < k) {
				if (a[i][j] > n) {
					c++;
				}
				j++;
			}
			if (c < k) {
				return false;
			}
		}
		return true;
	}

	public static String stampaMatrice(int[][] matrice) {
		String s = "";
		for (int i = 0; i < matrice.length; i++) {
			s += "[ ";
			for (int j = 0; j < matrice[0].length; j++) {
				s += String.valueOf(matrice[i][j]) + (j < ((matrice[0].length) - 1) ? ", " : "");
			}
			s += " ]\n";
		}
		return s;
	}

	public static boolean occorrenzeInteroMatrice2(int[][] a, int k, int n) {

		int numK = 0;
		int checkRiga = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] > n) {
					numK++;
				}
			}
			if (numK < k)
				return false;
			numK = 0;

		}
		/*
		 * if (checkRiga != a.length) return false;
		 */
		return true;

	}

}