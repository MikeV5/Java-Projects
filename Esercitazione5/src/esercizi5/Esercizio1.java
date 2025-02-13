package esercizi5;

import java.util.Random;

/****************************************************************************************************/
/**** SOLUZIONE CLASSE ****/

public class Esercizio1 {
	static int righe = 4, colonne = 3, maxNum = 10;

	public static void main(String[] args) {
		
		// int righe = Integer.parseInt(args[0]);// Trasforma l'argomento passato da
		// input ad un intero
		// int colonne = Integer.parseInt(args[1]);
		// int maxNum = Integer.parseInt(args[2]);

		if (righe <= 0 || colonne <= 0 || maxNum <= 0)
			return; // Controlla se una delle tre condiziona non rispetta la condizione

		// inizializzazione della matrice
		/*int[][] matrice = new int[righe][colonne];
		
		creaMatrice(matrice);
		//System.out.println(stampa(matrice));
		System.out.println(stampa(matrice, " ", "\n"));
		
		int[][] t = trasponi(matrice);
		System.out.println(stampa(t));
		
		*/
		
		String[][] ms1 = new String[righe][colonne];
		creaMatrice(ms1);
		System.out.println(stampa(ms1));
		
		String[][] ms2 = new String[righe][colonne];
		creaMatrice(ms2);
		System.out.println(stampa(ms2));
		System.out.println(stampa(sommaMatrice(ms1,ms2)));
	}

	public static void creaMatrice(int[][] m) {
		Random r = new Random();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = r.nextInt(Esercizio1.maxNum); // Stiamo dando a cercare un atributo andando alla
														// classe.atribu
			}
		}
	}

	public static void creaMatrice(String[][] m) {
		String s="";
		Random r = new Random();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				//m[i][j]=s+s.valueOf(r.nextInt(26)+37);
				m[i][j] = (char) (r.nextInt(26)+37)+"";// cast a un intero ma con "" si concatena una stringa
			}
		}
	
	}
	
	public static String[][] sommaMatrice(String[][] m1, String[][] m2) {
		//aggiungere un controllo
		String[][] mSomma =new String[m1.length][m1[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				mSomma[i][j]=m1[i][j]+m2[i][j];
			}
		}
		return mSomma;
	}
	
	public static String stampa(String[][] m) {
		String s = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (j == m[0].length - 1)
					s = s + m[i][j];
				else
					s = s + m[i][j]+" ";
			}
			s = s + "\n";
		}
		return s;
		
	}
	
	public static String stampa(int[][] m) {
		return stampa(m, " ", "\n");
		/*
		 * String s = ""; for (int i = 0; i < m.length; i++) { for (int j = 0; j <
		 * m[0].length; j++) { s = s + m[i][j] + " "; } s = s + "\n"; } return s;
		 */
	}

	public static String stampa(int[][] m, String delimColonne, String delimRighe ) {
		String s = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (j == m[0].length - 1)
					s = s + m[i][j];
				else
					s = s + m[i][j]+ delimColonne;
			}
			s = s + delimRighe;
		}
		return s;
	}
	
	public static int[][] trasponi(int[][] m){
		
		int[][] t = new int[m[0].length][m.length];
		//il num di righe diventa il num di colonne e viceversa
		for (int i = 0; i < m[0].length; i++) {
			for (int j = 0; j < m.length; j++) {
				t[i][j]=m[j][i];	
			}
		}
		return t;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
