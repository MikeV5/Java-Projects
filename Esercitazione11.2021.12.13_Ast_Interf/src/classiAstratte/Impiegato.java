package classiAstratte;

public class Impiegato extends Dipendente {

	public Impiegato(String nomeCognome, int matricola, double stipendioMensile) {
		super(nomeCognome, matricola, stipendioMensile);
	}

	@Override
	public double calcolaRal() {
		return 13*stipendioMensile;
	}

	public double getStipendio() {
		return stipendioMensile;
	}
	
}
