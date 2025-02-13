package javaCourse;

import javaCourse.FrazioneCustom2;

public class FrazioneCustom2 {
	// ********** CAMPI
	private int num;
	private int den;

	// ********* COSTRUTTORI
	public FrazioneCustom2(int num, int den) {
		if (den == 0)
			/*throw new ArithmeticException("Denominatore uguale a zero.");// errore - Si deve costruire l'exception
																			// (throw new ...)*/
			//Implementazione della mia eccezione
		throw new FrazioneCustomException("Denominatore uguale a zero.");	
			
			
		// memorizzo il segno della frazione
		boolean negativa = (num < 0 && den > 0) || (num > 0 && den < 0);
		// tolgo eventuali segni da num e den
		if (num < 0)
			num = -num;
		if (den < 0)
			den = -den;
		// calcolo il MCD
		int m = mcd(num, den);
		// metto il segno al num se serve

		if (negativa)
			this.num = -num / m;
		else
			this.num = num / m;

		this.den = den / m;
	}

	public FrazioneCustom2(int num) {
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
	public FrazioneCustom2 per(FrazioneCustom2 f) {

		// calcolo numeratore
		int n = this.num * f.num;
		// calcolo denominatore
		int d = this.den * f.den;
		// costruzione nuova frazione
		FrazioneCustom2 ris = new FrazioneCustom2(n, d);

		// restituire risultato
		return ris;

	}

	public FrazioneCustom2 meno(FrazioneCustom2 f) {
		int n = (this.num * f.den)-(this.den * f.num);
		int d = this.den * f.den;
		FrazioneCustom2 ris = new FrazioneCustom2(n, d);
		return ris;

	}

	@Override
	public String toString() {
		return "num = " + num + ", den = " + den;
	}

	public boolean isMinore(FrazioneCustom2 f) {
		FrazioneCustom2 tmp = this.meno(f);
		return tmp.num < 0;
	}

	public boolean isMaggiore(FrazioneCustom2 f) {
		FrazioneCustom2 tmp = this.meno(f);
		return tmp.num > 0;
	}

	public boolean equals(FrazioneCustom2 f) {
		if (this.num == f.num && this.den == f.den)
			return true;
		return false;
	}

	/*
	 * // Overloading public boolean equals(FrazioneCustom2 f) {
	 * 
	 * FrazioneCustom2 tmp = this.meno(f); // manca creare il metodo meno // if
	 * (this.num == f.num && this.den == f.den) if (tmp.num == 0) return true;
	 * 
	 * return false; }
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof FrazioneCustom2)
			return this.equals((FrazioneCustom2) o);
		return false;
	}

	private int mcd(int a, int b) {
		int resto;
		do {
			resto = a % b;
			a = b;
			b = resto;
		} while (resto != 0);
		return a;
	}

}
