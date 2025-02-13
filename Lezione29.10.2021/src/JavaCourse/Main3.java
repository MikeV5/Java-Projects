package JavaCourse;

public class Main3 {

	public static void main(String[] args) {

		int x = 0;
		int y = 0;
		if (x <= y || (x = y++) > 0) // con solo una "|" obbliga a valutare le due condizioni, non c'è lazy
										// evaluation
			// con lazy evaluation x=0 perché non si valuta la seconda condizione
			x = y; // cocon solo un or (|) obbliga valutare la seconda condizione quindi y++ ->y=1
					// ->x=y=1
		System.out.println("x= " + x + ", y= " + y);
		/*****************************************/
		int x = 3;
		int y = 0;

		if (x <= y || (x = y++) > 0) // F || F -> non cambia niente con un solo or(|)
			x = y;
		/*****************************************/
		int x = 3;
		int y = 1;

		if (x <= y || (x = y++) > 0) // F || V nella seconda condizione si condera y =1 prima del incremento, poi
										// sarà incrementata
			x = y; // A x verrà assegnata il valore incrementato di y quindi x=2
		/*****************************************/
		int x = 3;
		int y = 3;

		if (x != y && (x = y++) > 0) // F con lazy evaluation (prima F) non si valuta la seconda
			x = y; // rimangono con gli stessi valori

		/*****************************************/
		int x = 3;
		int y = 3;

		if (x != y & (x = y++) > 0) // F con un solo "&" per forza si valuta la sec condiz->la x rimane uguale ma la
									// y increm dopo
			x = y; // non viene eseguita quest'istrzuione ma valori finali x=3 y=4
		/*****************************************/
		int x = 2;
		int y = 0;

		if (x != y && (x = y++) > 0) // V V
			x = y; // y viene incrementa quindi x =1

		/*****************************************/
		int x = 2;
		int y = 1;

		if (x != y && (x = y++) > 0) // V V
			x = y; // x=2 y =2

		/*****************************************/
		int x = 8;
		int y = 9;

		int z = ((x == y)) ? x++ : --y; //F quindi z assume il valore di y decrementato subito
		//x=8 - y=8 - z=8
		
		/*****************************************/
		int x = 8;
		int y = 9;

		int z = ((x == y)) ? x++ : y--; //F quindi z assume il valore di y prima del decremento
		//x=8 - y=8 - z=9
		
		/*****************************************/
		int x = 8;
		int y = 9;

		int z = ((x != y)) ? x++ : y--; //V quindi z assume il valore di x prima del incremento
		//x=9 - y=9 - z=8
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
