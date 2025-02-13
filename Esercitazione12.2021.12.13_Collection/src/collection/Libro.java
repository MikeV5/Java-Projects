package collection;

import java.util.Objects;

public class Libro implements Comparable {

	private String titolo;
	private String autore;
	private int annoPub;

	// questo è 0 se è un libro normale, un numero che indica il volume se è una
	// serie
	// ad esempio di fumetti, enciclopedie etc
	private int numero;

	public Libro(String titolo, String autore, int annoPub) {
		this(titolo, autore, annoPub, 0);
	}

	// costruttore per serie
	public Libro(String titolo, String autore, int annoPub, int numero) {

		this.titolo = titolo;
		this.autore = autore;
		this.annoPub = annoPub;
		this.numero = numero;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public int getNumero() {
		return numero;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getAnnoPub() {
		return annoPub;
	}

	public void setAnnoPub(int annoPub) {
		this.annoPub = annoPub;
	}

	@Override
	public String toString() {
		return "Libro [Titolo=" + titolo + ", Autore=" + autore + ", annoPub=" + annoPub + ", numero " + numero + "]";
	}

	@Override
	public int compareTo(Object altro) {
		if (altro == null)
			throw new NullPointerException();
		Libro altro2 = (Libro) altro;
		// ordina prima in base al titolo
		int val = titolo.compareTo(altro2.titolo);
		if (val != 0)
			return val;
		else {
			// poi in base all'autore
			if (autore.compareTo(altro2.autore) != 0)
				return autore.compareTo(altro2.autore);
			else {
				// ed infine in base all'anno
				if (annoPub == altro2.annoPub)
					return 0;
				else if (annoPub < altro2.annoPub)
					return -1;
				else
					return 1;
			}
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(annoPub, autore, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return annoPub == other.annoPub && Objects.equals(autore, other.autore) && Objects.equals(titolo, other.titolo);
	}

}
