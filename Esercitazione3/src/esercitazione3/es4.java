package esercitazione3;

import java.util.Scanner;

public class es4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String in = "";
		int countA = 0, countF = 0, countC = 0;

		do {

			System.out.println("Inserisci un nuovo libro: \n");
			System.out.println("A per Azione, F per Fantasy, C per " + Genere.COMMEDIA);
			in = sc.next(); // legge l'Ainput
			in = in.toLowerCase();
			if (in.equals("a"))
				countA++;
			if (in.equals("f"))
				countF++;
			if (in.equals("c"))
				countC++;
			System.out.println(countA + "\n" + countF + "\n" + countC);

		} while (!in.equals("END"));
		sc.close();

	}
}
