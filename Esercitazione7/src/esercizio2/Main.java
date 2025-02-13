package esercizio2;

public class Main {

	public static void main(String[] args) {

		Tesi tesi = new Tesi();
		tesi.titolo = "Visualizzatore di spazi";

		Laureando pippo = new Laureando();
		pippo.nome = "Pippo";
		pippo.matricola = 1234;

		// Docente relatore creato dalla classe docente
		Docente docente1 = new Docente();
		docente1.nome = "Rossi";
		pippo.relatore = docente1;

		// Docente correlatore creato direttamente dalla classe Laureando
		pippo.correlatore = new Docente();
		pippo.correlatore.nome = "Bianchi";

		// System.out.println("Correlatore di " + pippo.nome + " : " + pippo.correlatore.nome);
		
		/*********************************
		 * Create ora un altro laureando (Pluto), con gli stessi IDENTICI relatore e
		 * correlatore di pippo
		 *********************************/
		Tesi tesi2 = new Tesi();
		tesi.titolo = "Visualizzatore di spazi 2";

		Laureando pluto = new Laureando();
		pluto.nome = "Pluto";
		pluto.matricola = 2345;

		// Relatore
		pluto.relatore = docente1;
		// Correlatore
		pluto.correlatore = pippo.correlatore;
		// System.out.println("Correlatore di " + pluto.nome + " : " + pluto.correlatore.nome);
		
		/*********************************
		 * Cambiate il nome del correlatore di Pluto in Bianchissimo e stampate i dati
		 * per entrambi i laureandi
		 *********************************/
		pluto.correlatore.nome = "Bianchissimo";
		System.out.println("Correlatore di " + pluto.nome + " : " + pluto.correlatore.nome);
		System.out.println("Correlatore di " + pippo.nome + " : " + pippo.correlatore.nome);

		/*********************************
		 * Create un nuovo docente con lo stesso STATO del correlatore di Pippo, e assegnatelo come correlatore a Pluto
		 *********************************/
		
		Docente docente2 = new Docente();
		docente2.nome = pippo.correlatore.nome;
		pluto.correlatore=docente2;
		
		/*********************************
		 * Cambiate il nome del correlatore di Pluto, e ristampate i dati per entrambi i laureandi
		 *********************************/
			
		pluto.correlatore.nome="Prova";
		System.out.println("Correlatore di " + pluto.nome + " : " + pluto.correlatore.nome);
		System.out.println("Correlatore di " + pippo.nome + " : " + pippo.correlatore.nome);
		
		System.out.println(pippo.equals(pluto));
		
		
		
		
	}

}
