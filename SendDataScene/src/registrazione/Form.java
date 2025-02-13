package registrazione;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import application.Prodotto;

public class Form {

	public static void main(String[] args) throws IOException {

		// Verifico se il file è già stato creato
		try {
			File fileUsers = new File("src/registrazione/users.txt");
			if (fileUsers.createNewFile()) { // crea il file soltanto se non esiste
				System.out.println("File creato");
			}

		} catch (IOException e) {
			System.out.println("Errore.");
			e.printStackTrace();
		}

		/*** MAIN MENU ***/
		int opzione;
		Scanner sc = new Scanner(System.in);
		ArrayList<Prodotto> persone = new ArrayList<Prodotto>();
		caricaUsers(persone);

		System.out.println("1. Registrati. ");
		System.out.println("2. Accedi. ");
		System.out.println("3. Controlla lista usuari. ");
		System.out.println("Scegli un numero");
		opzione = sc.nextInt();
		sc.nextLine();

		if (opzione == 1) {
			registrazione(persone);
		} else if (opzione == 2) { // Login
			login(persone);
		} else if (opzione == 3) {
			for (int i = 0; i < persone.size(); i++) {
				System.out.println(i + " : " + persone.get(i).toString());
			}
			System.out.println(persone.size());
		}
		sc.close();

	}

	public static void caricaUsers(ArrayList<Prodotto> persone) throws IOException {
		FileReader fr = null;
		String s;

		try {
			fr = new FileReader("src/registrazione/users.txt");
			BufferedReader br2 = new BufferedReader(fr);

			while ((s = br2.readLine()) != null) {
				String[] divideP = s.split(";");
				//persone.add(new Prodotto(divideP[0], divideP[1]));

			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
	}

	public static void registrazione(ArrayList<Prodotto> persone) throws IOException {
		Scanner sc = new Scanner(System.in);
		String user = "";
		String password = "";
		String confPassword = "";
		String userReg = "";
		boolean check = false;

		do {
			System.out.println("Inserisci un nome usuario: ");
			user = sc.nextLine();
			check = checkUser(user);
			if (check)
				System.out.println("Nome usuario già esistente!. Riprova.");
		} while (check); // Mentre ci siano user uguali

		do {
			System.out.println("Inserisci una password: ");
			password = sc.nextLine();
			System.out.println("Conferma la password: ");
			confPassword = sc.nextLine();

			if (!password.equals(confPassword))
				System.out.println("Password diverse!. Riprova.");
		} while (!password.equals(confPassword));

		scriviFile(persone, user, password);

		System.out.println("Registrato avvenuta con successo!");
		System.out.println("Ora puoi accedere");
		login(persone);
	}

	public static void login(ArrayList<Prodotto> persone) throws IOException {
		Scanner sc = new Scanner(System.in);
		String user = "";
		String password = "";

		String userLog = "";
		int opzione;
		boolean check2 = false;

		System.out.println("Inserisci il tuo nome usuario: ");
		user = sc.nextLine();

		System.out.println("Inserisci la tua password: ");
		password = sc.nextLine();

		userLog = user + ";" + password; // Crea stringa con il nome usuario e la password
		// System.out.println(userLog);
		check2 = checkLogin(userLog); // Se false: non si è trovato l'user

		if (check2 == false) { // se false
			System.out.println("Accesso non riuscito.");
			System.out.println("1. Registrati. ");
			System.out.println("2. Riprova ad accedere. ");
			System.out.println("Scegli un numero");
			opzione = sc.nextInt();
			sc.nextLine();

			if (opzione == 1) {
				registrazione(persone);
			} else if (opzione == 2) { // Login
				login(persone);

			} else {
				System.out.println("Scegli soltanto '1' o '2'.");
			}
			sc.close();

		} else if (check2 == true) {

			System.out.println("Login effettuato con successo");
			System.out.println("Benvenuto nell'App...");

		}

	}

	public static void scriviFile(ArrayList<Prodotto> persone, String user, String password) {

		try {
			File file = new File("src/registrazione/users.txt");
			FileWriter fw = new FileWriter(file, true);
		//	persone.add(new Prodotto(user, password));
			fw.write(user + ";" + password + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("Errore nella registrazione.");
			e.printStackTrace();
		}
	}

	public static boolean checkUser(String user) throws IOException {
		FileReader fr = null;
		String s;
		boolean check = false;
		try {
			fr = new FileReader("src/registrazione/users.txt");
			BufferedReader br2 = new BufferedReader(fr);
			int i = 0;
			while ((s = br2.readLine()) != null) {
				String[] divideUser = s.split(";");
				if (user.equals(divideUser[0]))
					check = true;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		return check;
	}

	public static boolean checkLogin(String nomeUser) throws IOException { // Verifico se già esiste un account uguale

		FileReader fr = null;
		String s = "";
		boolean check = false;
		try {
			fr = new FileReader("src/registrazione/users.txt");
			BufferedReader br2 = new BufferedReader(fr);

			while ((s = br2.readLine()) != null) {
				if (nomeUser.equals(s)) {
					// System.out.println(s);
					check = true;

					// String[] divideP = s.split(";");
					// persone.add(new Persona(divideP[0], divideP[1]));
					// System.out.println(s);
					// System.out.println(persone.get(i).toString());
					// i++;
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			// Lista persone del file txt
			// for (int i = 0; i < persone.size(); i++)
			// System.out.println(persone.get(i).toString());
			// System.out.println(persone.size());
			fr.close();
		}

		return check;
	}

}
