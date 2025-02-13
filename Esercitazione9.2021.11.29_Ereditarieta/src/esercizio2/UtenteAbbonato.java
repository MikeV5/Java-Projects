package esercizio2;

import java.util.Arrays;

public class UtenteAbbonato extends UtenteBiblioteca {

	// campi
	private int numLibri;

	// costruttori
	public UtenteAbbonato(String nome, int maxPagine, int numLibri) {
		super(nome, maxPagine);
		this.numLibri = numLibri;
		this.libriInPrestito = new Libro[this.numLibri];

	}

	public UtenteAbbonato(String nome, int maxPagine) {
		super(nome, maxPagine);
		this.numLibri = 10;
	}

	// metodi
	@Override
	public int contaPagineInPrestito() {
		int conteggio = 0;
		for (int i = 0; i < libriInPrestito.length; i++) {
			if (libriInPrestito[i] != null && (libriInPrestito[i].isNarrativa())) // Se il libro è di narrativa
																					// conta le pagine
				conteggio += libriInPrestito[i].getNumeroPagine();
		}
		return conteggio; // Numero di pagine totale dei libri che sono di narrativa
	}

	public int pagNonNarrative() {
		int totalePag = 0;
		for (int i = 0; i < libriInPrestito.length; i++) {
			if (libriInPrestito[i] != null)
				totalePag += libriInPrestito[i].getNumeroPagine();
		}
		return totalePag - contaPagineInPrestito();
	}

	@Override
	public boolean prendiInPrestito(Libro libro) {

		if (libro == null)
			return false;
		if (!libro.isNarrativa()) {
			if (pagNonNarrative() + libro.getNumeroPagine() <= maxPagine) {
				return aggiungiLibroInPrestito(libro);
			} else {
				return false;
			}
		} else {
			return aggiungiLibroInPrestito(libro);
		}

	}

	@Override
	public String toString() {
		String dati = "";
		for (int i = 0; i < libriInPrestito.length; i++) {
			if (libriInPrestito[i] != null)
				dati += "Libro: " + i + ", Narrativa: " + libriInPrestito[i].isNarrativa() + ", Num Pagine: "
						+ libriInPrestito[i].getNumeroPagine() + "\n";
		}

		return "UtenteAbbonato [nome=" + getNome() + ", maxPagine=" + maxPagine + ", libriInPrestito=" + numLibri
				+ " ]\n" + dati;
	}

}
