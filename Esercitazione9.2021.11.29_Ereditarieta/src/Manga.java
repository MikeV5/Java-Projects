
public class Manga extends Libro {

	// campi
	private String titoloOriginale;

	// costruttori
	public Manga(String descrizione, double prezzo, double sconto, String autore, String[] pagine, String tit) {
		super(descrizione, prezzo, sconto, autore, pagine);
		titoloOriginale = tit;
	}

	// metodi
	@Override
	public String sfoglia() {
		
		String s = "";
		for (int i = pagine.length-1; i >=0; i--) {
			if (pagine[i] != null)		//Se l'array non è vuoto
				s = s + pagine[i] + "\n";
		}
		return s;
		
	}

	@Override
	public String toString() {
		return "Manga: titolo originale " + titoloOriginale + "\n" + super.toString();
	}

}
