package esercizio1;

public class Main {

	public static void main(String[] args) {
		//Si potrebbe avere un'eccezione non gestita, quindi o gestirla o lasciarla al metodo chiamante(main() throws ...)
		A a=null;
		try {		
			a = new A(-2,9); 
		}catch(InputException e) {
			//e.printStackTrace(); //Evidenzia l'errore ma lo commentiamo.
			//Per lo sviluppatore( e.printStackTrace() ) - per l'utente (e.getMessage()) 
			System.err.println(e.getMessage()); //Prende il messaggio che abbiamo passato al costrutto InputException della classe A		
		}
		
		System.out.println("sono vivo");
		
		 // la "a" non esiste. è una variabile non definita
		//Tutto ciò dentro nel try, fuori non esiste -> Soluzione: Creare "A a" fuori il blocco try
		System.out.println(a.x); 
		
		
		
		
		
		
		
		
		
		
		
	}

}
