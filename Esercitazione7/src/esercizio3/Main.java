package esercizio3;

public class Main {

	public static void main(String[] args) {

		Lettera lettera = new Lettera();
		lettera.peso = 80;

		// Destinatario
		lettera.destinatario = new Persona();
		lettera.destinatario.nome = "Pippo";
		lettera.destinatario.indirizzo = "Roma";

		// Mittente
		lettera.mittente = new Persona();
		lettera.mittente.nome = "Pluto";
		lettera.mittente.indirizzo = "Milano";

		/*
		 * Create due lettere di risposta (mittente e destinatario invertiti!): come
		 * recuperate, e usate, mittente e destinatario? (ci son 2 modi, molto diversi,
		 * usateli entrambi)
		 */
		// METODO 1(uso le identita')
		Lettera lettRis1 = new Lettera();

		lettRis1.destinatario = lettera.mittente;
		lettRis1.mittente = lettera.destinatario;

		System.out.println("lettRis1: " + lettRis1.destinatario.nome);
		System.out.println("lettRis1: " + lettRis1.mittente.nome + "\n");

		// METODO 2(uso gli stati fra due oggetti diversi)
		Lettera lettRis2 = new Lettera();

		lettRis2.destinatario = new Persona();
		lettRis2.destinatario.nome = lettera.destinatario.nome;
		lettRis2.destinatario.nome = lettera.destinatario.nome;

		lettRis2.mittente = new Persona();
		lettRis2.mittente.nome = lettera.mittente.nome;
		lettRis2.mittente.nome = lettera.mittente.nome;

		System.out.println("lettRis2: " + lettRis2.destinatario.nome);
		System.out.println("lettRis2: " + lettRis2.mittente.nome + "\n");

		/*
		 * Cambiate nome del mittente di lettera, e ristampate le 2 lettere: cosa cambia
		 * in base ai 2 modi precedenti?
		 */

		lettera.mittente.nome = "Prova";

		System.out.println("lettRis1: " + lettRis1.destinatario.nome);
		System.out.println("lettRis1: " + lettRis1.mittente.nome + "\n");

	}

}
