package ricorsione;

public class Appartamento extends UnitaAbitativa {

	public Appartamento(double mq, double valore) {
		super(mq, valore);
	}

	@Override
	double calcolaValore() {
		return valore;
	}

	@Override
	double calcolaMQ() {
		return mq;
	}

}
