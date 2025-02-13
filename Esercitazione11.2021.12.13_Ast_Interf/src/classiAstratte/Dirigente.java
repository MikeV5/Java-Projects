package classiAstratte;

public class Dirigente extends Dipendente { // Dirigente estende la classe astratta Dipendente e deve implementare i
											// suoi metodi

	double benefit;

	public Dirigente(String nomeCognome, int matricola, double stipendioMensile, double benefit) {
		super(nomeCognome, matricola, stipendioMensile);
		this.benefit = benefit;
	}

	@Override
	public double calcolaRal() {
		return 14 * stipendioMensile + benefit;
	}

}
