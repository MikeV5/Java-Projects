package esercizio6;

public class Main {

	public static void main(String[] args) {

		/********************************************
		 * In un main, creare un Libro con posto per 5 Pagine, inserire le prime 4
		 * Pagine con testo a scelta, e poi stampare il Libro
		 */

		Libro libro = new Libro();
		libro.titolo = "Titolo del libro";

		libro.pagine = new Pagina[5];

		for (int i = 0; i < 4; i++) {

			libro.pagine[i] = new Pagina();
			libro.pagine[i].testo = "Testo della pagina: " + String.valueOf(i + 1);

		}
		if (libro.pagine != null) {
			for (int i = 0; i < libro.pagine.length; i++) {
				if (libro.pagine[i] != null)
					System.out.println(libro.pagine[i].testo);
			}
		}
		System.out.println("****");
		/********************************************
		 * “Strappate” (eliminate) la seconda pagina, e ristampate il Libro
		 */
		libro.pagine[1] = null;

		if (libro.pagine != null) {
			for (int i = 0; i < libro.pagine.length; i++) {
				if (libro.pagine[i] != null)
					System.out.println(libro.pagine[i].testo);
			}
		}
		System.out.println("****");
		/********************************************
		 * Sostituite la seconda pagina strappata con una nuova
		 */
		libro.pagine[1] = new Pagina();
		libro.pagine[1].testo = "Testo della pagina nuova: 2";

		if (libro.pagine != null) {

			for (int i = 0; i < libro.pagine.length; i++) {
				if (libro.pagine[i] != null)
					System.out.println(libro.pagine[i].testo);
			}
		}

		/********************************************
		 * Se avete spazio nel libro (ultima pagina null), inserite un frontespizio
		 * (quindi, una nuova prima pagina, che sposta le altre avanti di un posto), e
		 * ristampatelo • Infine, create una Serie di 3 Libri con P
		 */
		System.out.println("****");
		if (libro.pagine != null && libro.pagine[libro.pagine.length - 1] == null) { // Controllo che l'ultima pagina
			for (int i = libro.pagine.length - 1; i > 0; i--) {
				libro.pagine[i] = libro.pagine[i - 1];
			}
			libro.pagine[0] = new Pagina();
			libro.pagine[0].testo = "Pagina 1: Frontespizio";
		}

		if (libro.pagine != null) {

			for (int i = 0; i < libro.pagine.length; i++) {
				if (libro.pagine[i] != null)
					System.out.println(libro.pagine[i].testo);
			}
		}

		/********************************************
		 * Create una Serie di 3 Libri con Pagine a vostra scelta
		 */

		System.out.println("****");
		System.out.println("Serie");
		// creiamo la serie
		Serie s = new Serie();
		s.libri = new Libro[3];
		s.libri[0] = libro;
		s.libri[1] = new Libro();
		s.libri[1].pagine = new Pagina[2];
		s.libri[1].pagine[0] = new Pagina();
		s.libri[1].pagine[0].testo = "p1";
		s.libri[1].pagine[1] = new Pagina();
		s.libri[1].pagine[1].testo = "p2";

		s.libri[2] = new Libro();
		s.libri[2].titolo = "Libro3";
		s.libri[2].pagine = new Pagina[2];
		s.libri[2].pagine[0] = new Pagina();
		s.libri[2].pagine[0].testo = "p11";
		s.libri[2].pagine[1] = new Pagina();
		s.libri[2].pagine[1].testo = "p22";

		// stampo la serie

		if (s != null && s.libri != null) {

			for (int i = 0; i < s.libri.length; i++) {
				if (s.libri[i] != null) {
					System.out.println("Libro " + s.libri[i].titolo);
					for (int j = 0; j < s.libri[i].pagine.length; j++) {
						if (s.libri[i].pagine[j] != null)
							System.out.println(s.libri[i].pagine[j].testo);
					}
				}
			}
		}

	}
}
