package javacourse;

public class Main {

	public static void main(String[] args) {
		
		
		
		//Array bidimensionale
		int [][] matrix = new int[2][10];//quadrata->righe e colonne hanno lo stesso valore
		System.out.println("Num righe > "+ matrix.length);
		System.out.println("Num colonne > "+ matrix[0].length);
	
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j]=i;	
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();	
		}
		

	
		
		/*System.out.println("Dimensione args > "+args.length);
		for(String tmp:args)
			System.out.println(tmp);
			*/
	}

}
