package JavaCourse;

public class FrazioneCustom {

	// ********** CAMPI - Dichiarazione dello stato della classe
	// Visibile solo all'interno della classe
	private int num;
	private int den;

	// ********* COSTRUTTORI
	public FrazioneCustom(int num, int den) {
		// num = num -> non è possibile
		this.num = num; // this: pseudovariabile che rappresenta l'oggetto corrente
		this.den = den;
	}
	/*
	 * public FrazioneCustom(int n, int d) { num = n; den = d; }
	 */

	public FrazioneCustom(int num) {
		/*
		 * this.num = num; den = 1;
		 */
		this(num, 1); // Chiama il primo costruttore
	}

	// *********** METODI
	public int getNumeratore() {
		return num;
	}

	public int getDenominatore() {
		return den;
	}

	public void setNumeratore(int n) {
		this.num = n;
	}

	public void setDenominatore(int d) {
		this.den = d;
	}

	// Override - sovvrascrivere il metodo della superclasse Object
	public FrazioneCustom per(FrazioneCustom f) {

		// calcolo numeratore
		int n = this.num * f.num;
		// calcolo denominatore
		int d = this.den * f.den;
		// costruzione nuova frazione
		FrazioneCustom ris = new FrazioneCustom(n, d);

		// restituire risultato
		return ris;
		/*
		 * Domanda esame: parametri formali(espressioni dichiarate quando si crea un
		 * metodo o un costruttore - utili per l'esecuzione), variabili locali (variabili visibili solo
		 * all'interno di un metodo) e parametri attuali(Espressioni che vengono passate
		 * nel momento che si chiama un metodo o costruttore)
		 */
	}

	@Override
	public String toString() {
		return "num = " + num + ", den = " + den;
	}

	//Overloading
	public boolean equals(FrazioneCustom f) {
		FrazioneCustom tmp = this.meno(f); // manca creare il metodo meno
		// *******if (this.num == f.num && this.den == f.den)
		if (tmp.num == 0)
			return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof FrazioneCustom)
			return this.equals((FrazioneCustom) o);
		return false;
	}

}
