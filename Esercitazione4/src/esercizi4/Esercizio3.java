package esercizi4;

import java.util.Random;
import java.util.Scanner;

import prog.io.ConsoleInputManager;

public class Esercizio3 {

	public static void main(String[] args) {

		ConsoleInputManager in = new ConsoleInputManager();
		// Scanner sc = new Scanner(System.in);
		int nRig, nCol;
		nRig = in.readInt("Inserisci il numero di righe: "); // Numero di array
		nCol = in.readInt("Inserisci il numero di colonne: "); // Dimensione dell'array
		// Inizializzazione delle matrici
		int[][] matrix = new int[nRig][nCol];
		int[][] matrix2 = new int[nRig][nCol];
		int[][] matrix3 = new int[nRig][nCol];
		
		// Riempire le matrice
		matrix = creaMatrix(nRig, nCol);
		matrix2 = creaMatrix(nRig, nCol);

		// Somma delle matrice
		matrix3 = sommaMatrix(matrix, matrix2);

		// Stampa matrici
		stampaMatrix(matrix);
		stampaMatrix(matrix2);
		stampaMatrix(matrix3);
		System.out.print(matrix3[0][0]);
	}

	public static int[][] creaMatrix(int rig, int col) {

		int[][] matrixTmp = new int[rig][col];
		int nR = 0;
		Random nRand = new Random();
		for (int i = 0; i < matrixTmp.length; i++) {
			for (int j = 0; j < matrixTmp[i].length; j++) {
				nR = nRand.nextInt(100);
				matrixTmp[i][j] = nR;
			}
		}
		return matrixTmp;
	}

	public static void stampaMatrix(int[][] matrix) {

		String s = "";
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrix[i].length; j++) {
				s = j < ((matrix[i].length) - 1) ? ", " : "";
				System.out.print(matrix[i][j] + s);
			}
			System.out.println("]");
		}
		System.out.println();
	}

	public static int[][] sommaMatrix(int[][] m1, int[][] m2) {
		
		int[][] m3 = new int[m1.length][m1[0].length];//m1[0]: lunghezza del primo array - int[][] m3 = new int[m1.length][m1[(m1.length)-1].length];
		
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				m3[i][j]=m1[i][j]+m2[i][j];
			}
		}

		return m3;
	}

}
