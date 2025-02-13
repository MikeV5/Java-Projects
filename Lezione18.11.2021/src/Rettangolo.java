
public class Rettangolo extends Figura {

	// CAMPI
	private double base;
	private double altezza;

	// COSTRUTTORI

	public Rettangolo(double b, double a) {
		// Si potrebbe ommettere this dato che non c'è ambiguità
		this.base = b;
		this.altezza = a;
	}

	public Rettangolo(int b, int a) {

		// this(b,a); -> loop infinito perché chiama sempre se stesso (ricorsione)
		// this((double)b, a; -> soluzione: - cast-> fare il cast della prima variabile
		// e automaticamente l'altro viene promosso
		// this((double)b, (double)a); uguale a prima ma non necessaria, fare il cast di
		// uno significa che l'altro sarà promosso autom
		this.base = b;
		this.altezza = a;
	}

	// METODI
	public double getBase() {
		return this.base;
	}

	public double getAltezza() {
		return this.altezza;
	}

	public void setBase(double base) {
		this.base=base;
	}
	
	public void setAltezza(double altezza) {
		this.altezza=altezza;
	}
	
	
	public double getPerimetro() {
		return base * 2 + altezza * 2;
	}

	public double getArea() {
		return base * altezza;
	}

	public boolean equals(Rettangolo r) {

		return this.base == r.base && this.altezza == r.altezza;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Rettangolo)// Verificare che o sia un'istanza di rettangolo
			return equals((Rettangolo) o);v//this.equals((Rettangolo)o)
		else
			return false;
	}

	@Override
	public String toString() {
		return "RETTANGOLO: base=" + base + ", altezza= " + altezza;
	}

}
