
public class Quadrato extends Rettangolo {

	// CAMPI
	// ereditate da rettangolo

	// COSTRUTTORI
	public Quadrato(double lato) {
		super(lato, lato); // super() senza parametri da' errore quindi bisogna il chiamare il super
							// passandogli due volte il lato
	}

	public Quadrato(int lato) {
		// this((double) lato); //senza il cast chiama se stesso
		super(lato, lato);
	}

	// METODI
	public double getLato() {
		return getBase();
	}

	public void setLato(double lato) {
		super.setBase(lato); // senza super.setBase chiamarebbe sempre il metodo della stessa classe, quindi
						// un loop infinito fino all'overflow
		super.setAltezza(lato);
	}

	public void setBase(double base) {
		setLato(base);
	}

	public void setAltezza(double altezza) {
		setLato(altezza);
	}

	@Override
	public String toString() {
		return "LATO= " + this.getBase(); // con this lo eredità dalla superclasse, infatti bastava anche con
											// super.getBase() - oppure creare un altro metodo che chiami questa
											// variabile(lato)
	}

	public String getDescrizione1() {
		return this.toString(); // toString della sottoclasse ovvero quadrato

	}

	public String getDescrizione2() {
		return super.toString(); //// toString della superclasse ovvero rettangolo

	}

}
