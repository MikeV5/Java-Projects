package prova;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws IOException {
		/*
		 * System.out.println("Inserire due numeri"); Scanner sc = new
		 * Scanner(System.in);
		 * 
		 * //String num = sc.nextLine(); double num1 =
		 * Double.parseDouble(sc.nextLine());
		 * 
		 * System.out.println(num1);
		
		 *for (int i = 0; i <= (text.length() - parola.length()); i++) {
				if (text.substring(i, i + parola.length()).equals(parola))
					result++;
			}
			text = br.readLine();
		 *
		 */
		
		/*
		FileReader fr = new FileReader("interi.txt");
		// System.out.println("Inserire due numeri > ");
		//InputStreamReader in = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(in);
		 BufferedReader br = new BufferedReader(fr);
		String text= br.readLine();
		String parola = "bb";
		// System.out.println(text);
		int result = 0;
		while (text != null) {
			System.out.println(text);
		}
		fr.close();
		System.out.println(result);*/
		
		
		//System.out.println(isPalindroma("ingnengni"));
	/*	
		int[] numeri = {9,7,5,20,10,12};
		int tmp=0;
		for (int i = 0; i < numeri.length; i++) {
			if(numeri[i]>tmp)
				tmp=numeri[i];
		}
		System.out.println(tmp);

		System.out.println("parola".substring(2,4));
		
		*/
		
		//metodo();
		int x=-7,y=2;
		do {
			x = x + 2;
			y = y + 3;
			if (x == -y)
			x = y;
			System.out.println("javajava");
			} while (x != y);
		//System.out.println("javajava");

	}
	
	public static boolean isPalindroma(String parola) {
		for (int i = 0; i < parola.length()/2; i++) {
			if(parola.charAt(i)!=parola.charAt(parola.length()-i-1))
				return false;
		}
		return true;
	}
	
	public static int f(String x) {
			int y = x.length();
			String pref = x.substring(0, y/2);
			String suff = x.substring(y/2);
			if (pref.equals(suff))
			return 1234;
			else return 2234;
			}

	
	
	
	
	
	
}
