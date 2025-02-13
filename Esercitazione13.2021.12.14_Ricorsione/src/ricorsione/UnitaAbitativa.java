package ricorsione;

public abstract class UnitaAbitativa {
	double mq; // metri quadri
	double valore;

	public UnitaAbitativa(double mq, double valore) {
		super();
		this.mq = mq;
		this.valore = valore;
	}

	abstract double calcolaValore();

	abstract double calcolaMQ();

	@Override
	public String toString() {
		return this.getClass() + " [calcolaValore()=" + calcolaValore() + ", calcolaMQ()=" + calcolaMQ() + "]";
	}

}
