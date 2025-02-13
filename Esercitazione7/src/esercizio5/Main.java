package esercizio5;

public class Main {

	public static void main(String[] args) {

		Partita partita = new Partita();
		partita.stadio = "Meazza";

		Arbitro arbitro = new Arbitro();
		arbitro.nome = "Tagliavento";
		arbitro.numeroTesserino = 12345;
		partita.arbitro = arbitro;
		
		Squadra squadra1 = new Squadra();
		squadra1.nome = "Inter";
		partita.squadraDiCasa = squadra1;
		
		Squadra squadra2 = new Squadra();
		squadra2.nome = "Sampdonia";
		partita.squadraOspite = squadra2;

		System.out.println("Squadra di casa: " + partita.squadraDiCasa.nome);
		System.out.println("Squadra ospite: " + partita.squadraOspite.nome);

		/***********************************************
		 * Stampate i dati relativi alla partita: da che istanza partite? Cambiate il
		 * nome di squadra2 e ristampate: vi torna quello che vedete?
		 */

		partita.squadraOspite.nome = "Prova";
		System.out.println("Squadra di casa: " + partita.squadraDiCasa.nome);
		System.out.println("Squadra ospite: " + partita.squadraOspite.nome);

	}

}
