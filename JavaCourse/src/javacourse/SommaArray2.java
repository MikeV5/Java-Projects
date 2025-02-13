package javacourse;

import java.util.Scanner;

public class SommaArray2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		//stabilire dimensione array
		final int DIM_ARRAY = sc.nextInt();
		
		//leggere primo array
		int[] array1 = leggiArray(sc,DIM_ARRAY);
		
		//leggere secondo array
		int[] array2 = leggiArray(sc, DIM_ARRAY);
		
		//sommare i due array
		int[] somma = new int[DIM_ARRAY];
		for(int i=0; i< DIM_ARRAY;i++) {
				somma[i]=array1[i]+array2[i];
		}
		
		// stamparli tutti
		System.out.println(stampaArray(array1));
		System.out.println(stampaArray(array2));
		System.out.println(stampaArray(somma));
		

	}
	
	public static int[] leggiArray(Scanner sc, int dim) {
		int[] tmp= new int[dim];
		for(int i=0; i< tmp.length;i++) {
	//		System.out.print("Valore posizione " + i+" array> ");
			tmp[i]= sc.nextInt(); //Assegna i valori		
		}
		return tmp;
	}
	
	public static String stampaArray(int[] a) {
		/*String s="";
		for(int i=0; i< a.length;i++) {
			s+= a[i]+" ";
		}*/
		String s="[";
		for(int i=0; i< a.length;i++) {
			s+= a[i] + (i< a.length-1 ? " ":"");
		}
		
	return s+"]";
	}
	
}



