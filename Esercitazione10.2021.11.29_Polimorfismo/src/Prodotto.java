import java.util.Objects;

public class Prodotto {

	private double costo_base = 0;
	private double iva = 1;
	private String descrizione;

	public Prodotto(String descrizione, double costo_base, double iva) {
		super();
		setCosto_base(costo_base);
		setDescrizione(descrizione);
		setIva(iva);
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	double getCosto_base() {
		return costo_base;
	}

	void setCosto_base(double costo_base) {
		this.costo_base = costo_base;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {

		return getCosto_base() * getIva();
	}

	public Prodotto dividi() {
		return dividi(2);
	}
	
	public Prodotto dividi(int n) {
		return new Prodotto(descrizione, costo_base / n, iva);
	}

	public String toString() {
		return descrizione + " costo base " + costo_base + " Prezzo finale: " + getPrezzo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costo_base);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		temp = Double.doubleToLongBits(iva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Controllo che l'oggetto non sia lo stesso
			return true;
		if (obj == null)
			return false;
		/*
		 * Statico: Puntano a diversi spazi di memoria - Dinamico: Sono uguali in parole
		 * di contenuto
		 */
		if (getClass() != obj.getClass()) // Controlla che il tipo dinamico uguale
			return false;
		Prodotto other = (Prodotto) obj;
		if (Double.doubleToLongBits(costo_base) != Double.doubleToLongBits(other.costo_base))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equalsIgnoreCase(other.descrizione)) // Ignora maiuscole e minuscole
			return false;
		if (Double.doubleToLongBits(iva) != Double.doubleToLongBits(other.iva))
			return false;
		return true;
	}

}
