package classiAstratte;

public class Main {

	public static void main(String[] args) {

		Dirigente dir = new Dirigente("dir1", 1, 1000, 500);
		System.out.println(dir.toString());

		Impiegato imp = new Impiegato("imp1", 2, 1000);
		System.out.println(imp.toString());
		Dipendente imp2 = new Impiegato("imp2", 3, 1000);
		System.out.println(imp2.toString());

		((Impiegato) imp2).getStipendio();

		Dipendente[] dipendenti = new Dipendente[10];
		dipendenti[0] = dir;
		dipendenti[1] = imp2;
		dipendenti[2] = new Impiegato("imp3", 4, 1000);

		double tot = 0;
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] !=null)
				tot = tot + dipendenti[i].calcolaRal();

		}

		System.out.println("tot ral: " + tot);
	}

}
