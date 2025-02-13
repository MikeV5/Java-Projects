package esercizio4;

public class ContoBancario {
	double saldo;

	public ContoBancario() {
		saldo = 0;
	}

	public ContoBancario(double saldo) {
		this.saldo = saldo;
	}

	public void versare(double sommaD) {
		if (sommaD < 0)
			throw new SommaNegativaException();

		saldo = saldo + sommaD;
	}

	public void prelevare(double sommaD) {
		if (sommaD < 0)
			throw new SommaNegativaException();
		if (((saldo - sommaD) < 0) || sommaD > saldo)
			throw new DenaroNonSufficienteException();
		else
			saldo = saldo - sommaD;
	}

	public void visualizzaSaldo() {
		System.out.println("ContoBancario [Saldo=" + saldo + "]");
	}

}
