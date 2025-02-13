package compito2_esercizio1;

/*
Scrivere una classe Esponenziale in grado di rappresentare numeri esponenziali, caratterizzati da una base e un esponente.
Denire un costruttore vuoto e un costruttore che abbia come argomenti la base e l'esponente. 
Denire i metodi per: (1) restituire il risultato della potenza in formato double, 
(2) restituire il risultato della potenza successiva in formato double. Utilizzare il metodo statico pow della classe Math.
Deve esseresollevata l'eccezione non controllata EsponenzialeNonValidoException nel caso in cui 
la base e l'esponente siano entrambi uguali a zero. 
Fornire, inoltre, un'implementazione minimale della classe EsponenzialeNonValidoException. 

Scrivere poi una classe ListaEsponenziale in grado di rappresentare insiemi di oggetti di tipo Esponenziale. 
Denire un costruttore vuoto e un costruttore che prenda in ingresso una lista di oggetti di tipo Esponenziale.
 Denire i metodi per: (1) restituire la lista, (2) restituire la lista sotto-forma di array di tipo Esponenziale.
*/

public class Esponenziale {

	private double base;
	private double esponente;

	public Esponenziale() {
		this(1, 1);
	}

	public Esponenziale(double base, double esponente) throws EsponenzialeNonValidoException {

		if (base == 0 && ((esponente == 0) || (esponente + 1) == 0))
			throw new EsponenzialeNonValidoException();
		this.base = base;
		this.esponente = esponente;
	}

	public double risultatoPotenza() throws EsponenzialeNonValidoException {
		if (base == 0 && esponente == 0)
			throw new EsponenzialeNonValidoException();
		return Math.pow(base, esponente);
	}

	public double risultatoPotenzaSuccessiva() throws EsponenzialeNonValidoException {
		if (base == 0 && (esponente + 1) == 0)
			throw new EsponenzialeNonValidoException();
		return Math.pow(base, esponente + 1);
	}

}
