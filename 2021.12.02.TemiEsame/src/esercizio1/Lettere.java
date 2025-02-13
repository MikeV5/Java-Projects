package esercizio1;

public class Lettere {

	public static void main(String[] args) {
		String test = "23aabbbbbccc23";
		System.out.println(maxLettereConsecutive(test));

	}

	public static int maxLettereConsecutive(String s) {
		int maxL = 0;
		int cont = 0;
		char c;

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (Character.isLetter(c)) { // Controllo se c'è un carattere
				cont++;
				if (cont > maxL)
					maxL = cont;
			} else
				cont = 0;

		}
		return maxL;
	}

}
