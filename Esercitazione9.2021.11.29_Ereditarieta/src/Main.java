
public class Main {

	public static void main(String[] args) {

		Prodotto p = new Prodotto("prodotto1", 100, 10);
		System.out.println(p.toString());

		String[] pagine = { "pag1", "pag2", "pag3" };
		Libro l = new Libro("libro1", 100, 10, "Dante", pagine);
		System.out.println(l.toString());

		String[] pagine2 = new String[3];
		pagine2[0] = "muore malissimo";
		pagine2[1] = "diventa capo delle guardie";
		pagine2[2] = "Oscar nasce";

		Manga m = new Manga("Lady Oscar", 100, 10, "autoreProva", pagine2, "Versailes no bara");
		System.out.println(m.toString());
		System.out.println(m.sfoglia()); // Override(legge al contrario) del metodo sfoglia della super classe Libro

		/*********** POLIMORFISMO ****************************/ // Assegnare a un oggetto un'istanza della sottoclasse
																// di quello di sinistra
		Prodotto x = new Manga("Lady Oscar", 100, 10, "autoreProva", pagine2, "Versailes no bara");
		x = l;

		System.out.println(x.toString());
		/****** BINDING DINAMICO *****/ // Esegue il metodo di quello di Manga ma prima verifica che anche prodotto cè
										// l'abbia
		// System.out.println(x.sfoglia()); //Non compila perché x non ha il metodo
		// sfoglia nonostante sia implementato in Manga
		// Si controlla prima che quello di sinitra abbia quel metodo
		// soluzione:
		System.out.println(((Libro) x).sfoglia());
		System.out.println("/***************/");
		/*******************************************************/
		Prodotto[] prodotti = new Prodotto[3];
		prodotti[0] = p;
		prodotti[1] = l;
		prodotti[2] = m;

		for (int i = 0; i < prodotti.length; i++) {

			if (prodotti[i] instanceof Libro)
				System.out.println(((Libro) prodotti[i]).sfoglia());
			else {
				System.out.println(prodotti[i].toString());
			}
		}	
	}

}
