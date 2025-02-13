
public class Libro extends Prodotto {

	// campi
	private String autore; //immutabile:Non si potra modificare, quindi non ci sarà un set, ma sì un get)
	protected String[] pagine;

	// costruttori

	public Libro(String descrizione, double prezzo, double sconto, String autore, String[] pagine) {
		// Prima si dichiara il super(costruttore della superclasse, dato che ha un
		// costruttore)
		// Se Prodotto non avessi un costruttore gli verrebbe assegnato quello di
		// default che
		// a sua volta verrebbe ereditato da Libro (super()-siccome è un costruttore di
		// default non è necessario scriverlo)
		// Libro eredita in automatico quello di default di Prodotto(costruttore vuoto)
		super(descrizione, prezzo, sconto);
		this.autore = autore;
		this.pagine = pagine;
		// if(pagine == null) throw new Exception();

	}

	// metodi
	public String getAutore() {
		return autore;
	}

	public int numPagine() {
		return pagine.length;
	}

	public String sfoglia() {
		String s = "";
		for (int i = 0; i < pagine.length; i++) {
			if (pagine[i] != null)		
				s = s + pagine[i] + "\n";
		}
		return s;
	}

	@Override
	public String toString() {
		return "Libro: " + super.toString() + ", Autore: " + autore + ", Num pagine: " + pagine.length;
		// *return "nome: " + getNome() + ", prezzo: " + getPrezzo() + ", sconto: " +
		// getSconto() + ", autore: " + autore
		// + ", num pagine: " + pagine.length;
	}

}
