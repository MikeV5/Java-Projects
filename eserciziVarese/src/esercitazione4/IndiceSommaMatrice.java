package esercitazione4;

import java.util.Scanner;

public class IndiceSommaMatrice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il numero di righe: ");
		int righe = sc.nextInt();
		System.out.println("Inserisci il numero di colonne: ");
		int colonne = sc.nextInt();

		int[][] matrix = creaMatrice(sc, righe, colonne);
		System.out.println(stampaMatrice(matrix));

		int sommaR = 0, sommaRigaMax = 0, rigaPosMax = 0;
		int sommaC = 0, sommaColonnaMax = 0, colonnaPosMax = 0;

		/********* MAX SOMMA RIGHE *****************/
		for (int i = 0; i < matrix.length; i++) { // righe
			for (int j = 0; j < matrix[0].length; j++) { // colonne
				sommaR += matrix[i][j];
			}
			if (sommaR > sommaRigaMax) {
				sommaRigaMax = sommaR;
				rigaPosMax = i+1;
			}
			sommaR = 0;
		}
		/**************** MAX SOMMA COLONNE **************************/
		for (int i = 0; i < matrix[0].length; i++) { // num colonne		
			for (int j = 0; j < matrix.length; j++) { // num righe
				sommaC += matrix[j][i];
			}
			if (sommaC > sommaColonnaMax) {
				sommaColonnaMax = sommaC;
				colonnaPosMax = i+1;
			}
			sommaC = 0;
		}

		System.out.println("La somma più alta è: " + sommaRigaMax + " in posizione " + rigaPosMax + " (Riga) ");
		System.out.println("La somma più alta è: " + sommaColonnaMax + " in posizione " + colonnaPosMax  + " (Colonna) ");
	}

	public static int[][] creaMatrice(Scanner sc, int rig, int col) {
		int[][] matrix = new int[rig][col];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println("Inserisci un numero: ");
				matrix[i][j] = sc.nextInt();
			}
		}
		return matrix;
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

}
