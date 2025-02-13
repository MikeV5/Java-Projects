package esercizio2;

public class ConfrontoArray {

	public static void main(String[] args) {
		int[] matrix1 = { 1, 2, 3, 4 };
		int[] matrix2 = { 3, 2, 1, 0 };

		int[] matrix3 = { 3, 5, 4, 6 };
		int[] matrix4 = { 4, 2, 3, 1 };
		System.out.println(confronto(matrix3, matrix4));

	}

	// Somma degli elementi in prima posizione è uguale a quella degli elementi
	// in seconda posizione, che è uguale alla somma degli elementi in terza
	// posizione e così via
	public static boolean confronto(int[] array1, int[] array2) {
		boolean controllo = false;

		int somma = array1[0] + array2[0];
		if (array1.length == array2.length) {
				
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] + array2[i] != somma) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	/*
	 * public static boolean confronto2(int[] array1, int[] array2) { boolean
	 * controllo = false; int cont = 0;
	 * 
	 * if (array1.length == array2.length) {
	 * 
	 * for (int i = 0; i < array1.length - 1; i++) { if (i != array1.length) { if
	 * (array1[i] + array2[i] == array1[i + 1] + array2[i + 1]) { cont++; } else {
	 * 
	 * return false; } } else {
	 * 
	 * // System.out.println(array1.length); } } } else { return false; } }
	 */
}
