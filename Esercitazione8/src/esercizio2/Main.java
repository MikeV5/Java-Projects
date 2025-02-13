package esercizio2;

public class Main {

	public static void main(String[] args) {

		Azienda az0 = new Azienda();
		System.out.println(az0.toString());

		Azienda az = new Azienda("Azienda1", 3);
		System.out.println(az.toString());

		az.assumi(new Dipendente("pippo"));
		az.assumi(new Dipendente("paperone", 20000));

		System.out.println(az.toString());

		az.licenzia(1);
		System.out.println(az.toString());
		az.licenzia(az.getDipendente(2));
		System.out.println(az.toString());

	}

}
