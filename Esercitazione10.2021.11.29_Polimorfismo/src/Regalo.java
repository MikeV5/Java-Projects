
public class Regalo {

	// campi
	private Object contenuto;

	// costruttori
	public Regalo(Object c) {
		contenuto = c;
	}

	// metodi

	public String scarta() {
		return contenuto.toString();
	}

	public double stampaPrezzo() {
		if (contenuto instanceof Prodotto)
			return ((Prodotto) contenuto).getPrezzo();
		else if (contenuto instanceof Regalo)
			return ((Regalo) contenuto).stampaPrezzo();
		else
			return 0;
	}

}
