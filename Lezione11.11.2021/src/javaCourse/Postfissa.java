package javaCourse;

import java.util.Scanner;
import java.util.Stack;

public class Postfissa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// creare la pila vuota
		Stack<Integer> pila = new Stack<Integer>();

		// Inserimento e valutazione dell'espressione
		System.out.println("Inserire l'espressione da analizzare ( = per terminare )");
		String exp = sc.nextLine();

		while (!exp.equals("=")) {
			// valutazione dell'espressione
			Integer sx, dx, ris=0;
			char selettore = exp.charAt(0);
			if (Character.isDigit(selettore))
				ris = Integer.parseInt(exp); // per gestire numerco con più cifr

			switch (selettore) {
			case '+':
			case '-':
			case '*':
			case '/':

				// Estrarre due numeri dalla pila
				dx = pila.pop();
				sx = pila.pop();
				// eseguire loperazione
				ris = calcola(sx, dx, selettore);
				// inserire il risultato nella pila

				pila.push(ris);

			default:
				// inserire il numero nella pila
				pila.push(ris);

			}

			// lettura dell'espressione
			exp = sc.nextLine();
			try {
			// stampa del risultato
			//System.out.println("Risultato" + pila.pop());
			int ris=pila.pop();
			if(pila.empty())
				System.out.println("Risultato "+ris);
			else System.err.println("Errore 1: pila non vuota al termine");
à				/* Esame: Eccezioni da sapere: empty, arithmetic, Stringout, outofBound, NumberFormatException(col parseint)... */
			}catch(ArithmeticException e){
				System.err.println("Errore 2: Divisione per zero);
				
				
			}catch(NumberFormatException e){
				System.err.println("Errore 3: Formato dati input errato);
				
				
			}catch(EmptyStackException e){
				System.err.println("Errore 4: espressione errata > );
				
				
			}
		}

	}

	private static int calcola(int sx, int dx, char op) {

		intr ris = 0;
		switch (op) {
		case '+':
			ris = sx + dx;
			break;
		case '-':
			ris = sx - sx;
			break;
		case '*':
			ris = sx * dx;
			break;
		case '/':
			ris = sx / dx;
			break;
		}

		return ris;
	}

}
