package ricorsione;

import java.util.ArrayList;
import java.util.List;

public class Condominio extends UnitaAbitativa {

	List<UnitaAbitativa> elementi;

	public Condominio(double mq, double valore, List<UnitaAbitativa> elem) {
		super(mq, valore);
		elementi = elem;
	}

	@Override
	double calcolaValore() {
		return 0;
	}

	@Override
	double calcolaMQ() {
		double tot = 0;
		for (UnitaAbitativa ua : elementi)
			tot = tot + ua.calcolaMQ();
		return tot;
	}

}
