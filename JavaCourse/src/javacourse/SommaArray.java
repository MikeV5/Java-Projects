package javacourse;

import java.util.Scanner;

public class SommaArray {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		//stabilire dimensione array
		final int DIM_ARRAY = sc.nextInt();
		
		//leggere primo array
		int[] array1 = new int[DIM_ARRAY];
		for(int i=0; i< array1.length;i++) {
			System.out.print("Valore posizione " + i+" array1> ");
			array1[i]= sc.nextInt(); //Assegna i valori		
		}
		
		//leggere secondo array
		int[] array2 = new int[DIM_ARRAY];
		for(int i=0; i< array2.length;i++) {
			System.out.print("Valore posizione " + i+" array2 > ");
			array2[i]= sc.nextInt(); //Assegna i valori		
		}
		
		//sommare i due array
		int[] somma = new int[DIM_ARRAY];
		for(int i=0; i< DIM_ARRAY;i++) {
				somma[i]=array1[i]+array2[i];
		}
		
		// stamparli tutti
		for(int i=0; i< DIM_ARRAY;i++) {
	}
		for(int i=0; i< DIM_ARRAY;i++) {
	}
		for(int i=0; i< DIM_ARRAY;i++) {
	
	}
		
		sc.close();
	}

}
