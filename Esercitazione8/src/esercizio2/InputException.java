package esercizio2;

public class InputException extends Exception { //classe eccezione(InputException) sottoclasse di Exception
	//Di solito ha due costruttori -> quella di default e quella con il messaggio
	
	public InputException() {
		super();	//Invoca il costruttore della superclasse
	}
	
	public InputException(String message) {
		super(message);
	}
	
}
