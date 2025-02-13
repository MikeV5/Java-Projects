package javacourse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Date;
import java.time.DayOfWeek;

public class Main {

	public static void main(String[] args) throws IOException {

		// Standard input - alternativa a Scanner
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br2 = new BufferedReader(isr); // E' come lo scanner ma non legge variabili di tipo primitivo
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in)); // Questo sostituisce Scanner sc =
																					// ...

		PrintStream out2 = System.out;
		out2.println("Scrivi qualcosa > ");
		out2.println("Hai scritto > " + br3.readLine());

		FileReader fr = null;
		int c;
		String s;

		String sep = File.separator;
		String seppath = File.pathSeparator;
		System.out.println("Separatore > " + sep);
		System.out.println("Separatore > " + seppath);
		File file = new File("files"); // File("files" + sep + "prova.txt") - File("src/javacourse")
		System.out.println("name > " + file.getName());
		System.out.println("parent > " + file.getParent());
		System.out.println("absolute path > " + file.getAbsolutePath());
		System.out.println("exists > " + file.exists());
		System.out.println("can read > " + file.canRead());
		System.out.println("can write > " + file.canWrite());
		System.out.println("is file > " + file.isFile());
		System.out.println("is directory > " + file.isDirectory());
		System.out.println("length > " + file.length());
		System.out.println("last modified > " + file.lastModified()); // Tempo in secondi passato dal 1 gennaio 1970
																		// fino all'ultima modifica del file

		Date data = new Date(file.lastModified());
		System.out.println(data);
		System.out.println();
		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("E' un file e si chiama > " + file.getName());
			} else {
				System.out.println("E' una cartella > " + file.getName() + "\nContenuto: ");
				String[] lista = file.list();

				for (String tmp : lista) {
					// File f = new File("files/"+tmp); //Devo specificare il percorso [
					// File("files/"+tmp)], altrimenti...
					File f = new File(file, tmp);
					System.out.println("is file > " + f.isFile());
					System.out.println("is directory > " + f.isDirectory());
					if (f.isFile())
						System.out.println("file: " + f.getAbsolutePath());
					else
						System.out.println("dir: " + f.getAbsolutePath());
				}
			}
		} else {
			System.out.println("File o directory non esistente.");
		}

		System.out.println();

		try {
			fr = new FileReader("files" + sep + "prova.txt");

			BufferedReader br = new BufferedReader(fr);
			File out = new File("files/test/out.txt");
			FileWriter fw = new FileWriter(out, true);

			while ((c = fr.read()) != -1) {
				fw.write(c); // Ogni volta sovvrascrive il contenuto di prova in out, salvo che si mettese un
								// "append=true" File(out,true)
				System.out.print((char) c);
			}
			fw.flush();
			fw.close();

			// Con questi due metodi non verrà mai stampato questo nuovo while
			// perché lo stream è arrivato a fine file
			// per far stampare questo nuovo while dovremmo far ritornare lo stream
			// all'inizio
			/*
			 * while ((s = br.readLine()) != null) {
			 * 
			 * System.out.println(s); }
			 */

		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {

			fr.close();

		}

	}

}
