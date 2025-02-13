package esercitazione3;

import java.util.Scanner;
//import prog.io.ConsoleInputManager;

public class es3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci un numero: ");

		int in;
		in = sc.nextInt();
		if (in >= 0)
			System.out.println("Numero positivo");
		else
			System.out.println("Numero negativo");

		String inS = String.valueOf(Math.abs(in));
		int y = 0;
		for (int i = inS.length() - 1; i >= 0; i--) {

			if (inS.charAt(i) != '-')
				System.out.println("Cifra " + i + " " + inS.charAt(y));
			y++;

		}
		sc.close();

		// Con le classi Wrapper
		/*
		 * Integer mioInt=new Integer(sc.nexInt()); Ins=mioInt.toString();
		 */

	}

}
