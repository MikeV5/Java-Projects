package javaCourse;

//Lezione 10-11-2021
//Eccezione non controllata(estende RunTimeException) della classe Frazione
public class FrazioneCustomException extends RuntimeException { 
	//In realta' dovrebbe estendere Arithmetic Exception, ma in questo modo FrazioneCustomException diventa sottoclasse di Arithmetic

	// CAMPI
	private String errore;

	// COSTRUTTORI
	public FrazioneCustomException(String s) {
		// Quandi si lancia l'eccezione verrà eseguita con il messagio
		this.errore = s;
	}

	// METODI
	@Override
	public String getMessage() {
		return errore;
	}

}
