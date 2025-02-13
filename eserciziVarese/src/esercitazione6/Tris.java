package esercitazione6;

public class Tris {

	public static void main(String[] args) {
		char[][] matrice = new char[3][3];
		stampaTavolo2(matrice);
	}

	public static void stampaTavolo(char[][] matrice) {
		int righe = 12, colonne = 12;

		for (int x = 0; x < 7; x++) {
			// System.out.print("|");
			for (int y = 0; y < 12; y++) { // stampa

				if (x % 2 == 0) {
					if (y % 4 == 0)
						System.out.print("|");
					else
						System.out.print("-");
				} else if (y % 4 == 0) {

					System.out.print("|");
				} else {
					if (y % 4 == 2) {
						System.out.print("X");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.print("|");
			System.out.println();

		}

	}

	public static void stampaTavolo2(char[][] matrice) {

		int righe = 12, colonne = 12;

		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 3; y++) { // stampa
				System.out.print("|");
				for (int k = 0; k < 3; k++) {

					if (x % 2 == 0) {
						System.out.print("-");
					} else {
						if (k % 3 == 1)
							System.out.print("o");
						else
							System.out.print(" ");
					}
				}
			}
			System.out.print("|");
			System.out.println();

		}

	}

}