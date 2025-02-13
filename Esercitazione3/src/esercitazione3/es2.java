package esercitazione3;

import java.util.Scanner;

public class es2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci a: ");
		int a = sc.nextInt();
		System.out.println("Inserisci b: ");
		int b = sc.nextInt();
		System.out.println("Inserisci c: ");
		int c = sc.nextInt();

		int delta = (b * b) - (4 * a * c);

		double x1 = ((-b) - Math.sqrt(delta)) / (2 * a);
		double x2 = ((-b) + Math.sqrt(delta)) / (2 * a);

		System.out.println("a: " + a + " b: " + b + " c: " + c + " delta:" + delta + " x1: " + x1 + " x2: " + x2);

	}

}
