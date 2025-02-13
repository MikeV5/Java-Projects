package compito6_esercizio2;

import java.util.LinkedList;

/*
Scrivere il codice della classe SIM, che simula il funzionamento di una scheda telefonica.
Una SIM e' rappresentata da: 1) numero di telefono a cui e' associata la carta SIM stessa; 2) credito disponibile in
euro (una chiamata costa 25 cent/min); 3) lista delle ultime 10 telefonate effettuate. Ogni telefonata effettuata e' rap-
presentata tramite la sua durata in minuti e il numero verso cui la chiamata stessa e' stata effettuata. Implementare
la classe con i relativi campi, il costruttore e denire i metodi specificati di seguito:
*/

public class SIM {

	private String numero;
	private float credito; // ogni chiamata costa 25 cent/min
	private LinkedList<Chiamata> chiamate;

	/*
	 * - Il costruttore parametrizzato crea una SIM, associando numero di telefono,
	 * credito e lista delle telefonate vuota
	 */
	public SIM(String n, float c) {
		numero = n;
		credito = c;
		chiamate = new LinkedList<Chiamata>();
	}

	/*
	 * - Un metodo per l'inserimento di una telefonata effettuata nella lista
	 */
	public void inserimentoChiamataEffettuata(String num, int tempo) {
		// Conteggio denaro
		credito = credito - tempo / 4;// (tempo*0.25)
		// Inserimento vero e proprio
		Chiamata c = new Chiamata(num, tempo);
		chiamate.addLast(c);

		if (chiamate.size() > 10) {
			chiamate.removeFirst(); // Rimuove il primo elemento della lista(chiamata meno recente)
		}
	}

	/*
	 * - Un metodo per il calcolo dei minuti totali di conversazione effettuati
	 */
	public int durataTotaleChiamate() { // Minuti totali delle chiamate della lista
		// Se non ci fossero chiamate nella lista
		if (chiamate.size() == 0)
			return 0;

		int totale = 0;
		for (int i = 0; i < chiamate.size(); i++) {
			totale = totale + chiamate.get(i).getd();
		}
		return totale;
	}

	/*
	 * - Un metodo per il calcolo delle telefonate effettuate verso un certo numero
	 */
	public int contaChiamateNumero(String n) {

		if (chiamate.size() == 0)
			return 0;

		int contaChiamate = 0;
		for (int i = 0; i < chiamate.size(); i++) {
			if (chiamate.get(i).getn().equals(n)) { // Metodo Equals con le stringhe
				contaChiamate++;
			}
		}
		return contaChiamate;
	}

	/*
	 * - Un metodo che restituisce una stringa contenente i dati della SIM e
	 * l'elenco delle telefonate
	 */
	public String toString() {

		String dati;
		dati = "Numero della SIM: " + this.numero + "Credito: " + this.credito + "\n";
		if (chiamate.size() == 0)
			return dati + " 0 telefonate.";
		for (int i = 0; i < chiamate.size(); i++) {
			dati = dati + " Chiamata: " + i + " Numero: " + chiamate.get(i).getn() + " Durata: "
					+ chiamate.get(i).getd() + "\n";
		}

		return dati;

	}
}
