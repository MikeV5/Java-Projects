package registrazione;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.naming.StringRefAddr;


public class MainTestFile {
/*
	  private static final String PLAIN_ASCII =
		      "AaEeIiOoUu"    // grave
		    + "AaEeIiOoUuYy"  // acute
		    + "AaEeIiOoUuYy"  // circumflex
		    + "AaOoNn"        // tilde
		    + "AaEeIiOoUuYy"  // umlaut
		    + "Aa"            // ring
		    + "Cc"            // cedilla
		    + "OoUu"          // double acute
		    ;

		  private static final String UNICODE =
		     "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
		    + "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
		    + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
		    + "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
		    + "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF"
		    + "\u00C5\u00E5"
		    + "\u00C7\u00E7"
		    + "\u0150\u0151\u0170\u0171"
		    ;
	*/
	
	public static void main(String[] args) throws IOException {

		
		
		
		String user = "admin2";
		String nomePlaylist = "playlist1";
		String nomeCanzone = "21 Guns£Green Day£15/05/2009";
		String nomeCanzone2 = "canzone1";
		String datiCanzone = "datiCanzone-datiiiiii";
		
			    
		
		 //aggiungiPlaylist(user, nomePlaylist);
		//scriviCanzone(user,nomePlaylist,nomeCanzone2);
		scriviEmozione3(user, nomePlaylist, nomeCanzone, datiCanzone);
		// scriviEmozione(user,nomePlaylist);
		
		// stampaEmozione2(user, nomePlaylist, nomeCanzone, datiCanzone);
		//stampaCanzoni2(user, nomePlaylist, nomeCanzone, datiCanzone);
		


		// catalogoCanzoni();
		// stampaCanzoni(user, nomePlaylist);
		// stampaPlaylist(user);
		
		
	}
	
	/*
	 public static String convertNonAscii(String s) {
		    if (s == null) return null;
		      StringBuilder sb = new StringBuilder();
		      int n = s.length();
		      for (int i = 0; i < n; i++) {
		        char c = s.charAt(i);
		        int pos = UNICODE.indexOf(c);
		        if (pos > -1){
		          sb.append(PLAIN_ASCII.charAt(pos));
		        }
		        else {
		          sb.append(c);
		        }
		     }
		     return sb.toString();
		  }
	*/
	public static ArrayList<String> convertEmozioniArray() throws IOException {
		ArrayList<String> listEmotion = new ArrayList<>();
		String percorsoFile = "src/registrazione/Emozioni.txt";
		FileReader fr = null;
		String s;
		int i = 0;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				listEmotion.add(s);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		return listEmotion;
	}

	
	public static void scriviEmozione3(String user, String nomePlaylist, String nomeCanzone, String datiCanzone) {
		int numCanzoni;
		String nuovaRiga = user + ";";
		String percorsoFile ="src/registrazione/test.txt";
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;

		try {
			// apro il file
			fstream = new FileInputStream(percorsoFile);

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			while ((strLine = br.readLine()) != null) {
				String[] divideUser = strLine.split(";");
				if (user.equals(divideUser[0])) {

					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							
							//	System.out.println(i);
							numCanzoni = 3*Integer.valueOf(divideUser[i + 1]); //i=2 numSpostamenti = 4
							//numSpostamenti = Integer.valueOf(divideUser[i + 1]);
							
							for (int j = i + 2; j < i + numCanzoni ; j++) { 
								
								System.out.println(j+" : "+divideUser[j]);
							//	System.out.println(divideUser[j]);
								if (divideUser[j].equals(nomeCanzone)) {
		
									for (int k = 1; k < j; k++) {
									nuovaRiga += divideUser[k] + ";";
									}								
									nuovaRiga += divideUser[j] + ";"; // canzone input
								//	System.out.println(j);
									
									if(Integer.valueOf(divideUser[j+1])==0) {
										
										
										//System.out.println(j);
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone+";"; //info emozioni della canzone input
										
										for (int m = j+3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}						
									//String[] divideEmotion=divideUser[j+1].split("-");
									}else if(Integer.valueOf(divideUser[j+1])==1) {
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone+";"; //info emozioni della canzone input
										for (int m = j + 3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}
										//System.out.println("c'è già");		
									}
								
								}
							}	
						}
					}
					System.out.println("\n"+nuovaRiga);
					fileContent.append(nuovaRiga + System.getProperty("line.separator"));
				} else {
					// ... altrimenti la trascrivo così com'è
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
				}
			}

			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter(percorsoFile);
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void scriviEmozione(String user, String nomeP) {

		String percorsoFile = "src/registrazione/test.txt";
		String dataTotale = "";
		try {
			File file = new File(percorsoFile);
			FileWriter fw = new FileWriter(file);
			// persone.add(new Persona(user, password));

			ArrayList<String> lista = convertEmozioniArray();
			for (int i = 0; i < lista.size(); i++) {
				String[] divUser = lista.get(i).split(";");

				// if((user).equals(divUser[0])) {
				dataTotale += lista.get(i) + "\n";
				System.out.println(user + nomeP);
				if (!divUser[1].isEmpty()) {
					System.out.println(divUser[0] + divUser[1]);
				}

				// System.out.println(lista.get(i));
				// }

				// System.out.println(lista.get(i));
			}
			fw.write(dataTotale + "\n");

			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("Errore nella registrazione.");
			e.printStackTrace();
		}
	}

	
	
	public static void scriviEmozione2(String user, String nomePlaylist, String nomeCanzone, String datiCanzone) {
		int numCanzoni;
		int numSpostamenti;
		int cont;
		String nuovaRiga = user + ";";
		String percorsoFile ="src/registrazione/test.txt";
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;
		try {
			// apro il file
			fstream = new FileInputStream(percorsoFile);

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			while ((strLine = br.readLine()) != null) {
			//	System.out.println(strLine); // stampo sulla console la riga corrispondente

				String[] divideUser = strLine.split(";");
				if (user.equals(divideUser[0])) {
				
					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
						//	System.out.println(i);
							numCanzoni = 3*Integer.valueOf(divideUser[i + 1]); //i=2 numSpostamenti = 4
							//numSpostamenti = Integer.valueOf(divideUser[i + 1]);
							
							for (int j = i + 2; j < i + numCanzoni ; j++) { 
								
								System.out.println(j+" : "+divideUser[j]);
							//	System.out.println(divideUser[j]);
								if (divideUser[j].equals(nomeCanzone)) {
		
									for (int k = 1; k < j; k++) {
									nuovaRiga += divideUser[k] + ";";
									}								
									nuovaRiga += divideUser[j] + ";"; // canzone input
								//	System.out.println(j);
									
									if(Integer.valueOf(divideUser[j+1])==0) {
										
										
										//System.out.println(j);
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone+";"; //info emozioni della canzone input
										
										for (int m = j+3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}						
									//String[] divideEmotion=divideUser[j+1].split("-");
									}else if(Integer.valueOf(divideUser[j+1])==1) {
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone+";"; //info emozioni della canzone input
										for (int m = j + 3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}
										//System.out.println("c'è già");		
									}
								
								}
							}
						}
					}
					System.out.println("\n"+nuovaRiga);
					fileContent.append(nuovaRiga + System.getProperty("line.separator"));
				} else {
					// ... altrimenti la trascrivo così com'è
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
				}
			}

			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter(percorsoFile);
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void stampaCanzoni2(String user, String nomePlaylist, String nomeCanzone, String datiCanzone)
			throws IOException {
		String percorsoFile = "src/registrazione/Playlist.txt";
		FileReader fr = null;
		String s;
		String nuovaRiga = user + ";";
		String nuovaRiga2 = user + ";";
		int numCanzoni;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divideUser = s.split(";");
				if (user.equals(divideUser[0])) {
					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							numCanzoni = Integer.valueOf(divideUser[i + 1]);
							for (int j = i + 2; j < i + numCanzoni + 2; j++) {
								if (divideUser[j].equals(nomeCanzone)) {
									for (int k = 1; k < j; k++) {
										nuovaRiga2 += divideUser[k] + ";";
									}
									nuovaRiga2 += divideUser[j] + ";"; // canzone input
									
									if(divideUser[j].equals(datiCanzone)) {
										System.out.println("c'è già");
									}else {
										nuovaRiga2 += datiCanzone; //info emozioni della canzone input
									}								
									for (int m = j + 1; m < divideUser.length; m++) {
										nuovaRiga2 += divideUser[m] + ";";
									}
								}
							}
						}
					}
				}
			}
			System.out.println(nuovaRiga2);

		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
	}

	public static void stampaEmozione2(String user, String nomePlaylist, String nomeCanzone, String datiCanzone)
			throws IOException {

		int numCanzoni;
		int cont;
		String nuovaRiga = user + ";";

		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;

		try {
			// apro il file
			fstream = new FileInputStream("src/registrazione/Playlist.txt");

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			while ((strLine = br.readLine()) != null) {
				// System.out.println(strLine); // stampo sulla console la riga corrispondente

				String[] divideUser = strLine.split(";");
				if (user.equals(divideUser[0])) {

					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							// i=2

							numCanzoni = Integer.valueOf(divideUser[i + 1]); // dobbiamo aggiornare questo numero prima
																				// di inserire la nuova canzone

//							System.out.println(divideUser[i+1]);

							for (int j = i + 2; j < i + numCanzoni + 2; j++) {
								System.out.println(divideUser[j]);
							}

							cont = i + 1 + numCanzoni + 1;

							System.out.println(cont);
							// Riscriviamo tutta la riga
							for (int j = 1; j < i; j++) {
								nuovaRiga += divideUser[j] + ";";
							}
							nuovaRiga += nomePlaylist + ";";
							nuovaRiga += String.valueOf(numCanzoni + 1) + ";"; // aggiorniamo il numero di canzoni della
																				// playlist

							for (int j = i + 2; j < cont; j++) {
								nuovaRiga += divideUser[j] + ";";
							}

							nuovaRiga += nomeCanzone + ";"; // inseriamo la nuova playlist

							for (int k = cont; k < divideUser.length; k++) {
								nuovaRiga += divideUser[k] + ";";
							}
						}

					}
					fileContent.append(nuovaRiga + System.getProperty("line.separator"));
				} else {
					// ... altrimenti la trascrivo così com'è
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
				}
			}

			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter("src/registrazione/Playlist.txt");
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static String stringaACapo(String text) {
		String dati = "";
		int conta = 0;
		for (int i = 0; i < text.length(); i++) {

			if (conta == 10) {
				dati += "\n";
				conta = 0;
			}
			conta++;
			dati += text.charAt(i);
		}
		return dati;
	}

	public static void catalogoCanzoni() throws IOException {
		String percorsoFile = "src/registrazione/Canzoni.txt";
		FileReader fr = null;
		String s;
		int i = 0;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divInfoCanzone = s.split(";");
				// System.out.println(i++);
				System.out.println(divInfoCanzone[0] + ";" + divInfoCanzone[1]);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
	}

	public static void scriviCanzone(String user, String nomePlaylist, String nomeCanzone) {
		int numCanzoni;
		int cont;
		String nuovaRiga = user + ";";
		String percorsoFile="src/registrazione/test.txt";
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;
		int spostamentiCanzoni;
		try {
			// apro il file
			fstream = new FileInputStream(percorsoFile);

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			while ((strLine = br.readLine()) != null) {
				//System.out.println(strLine); // stampo sulla console la riga corrispondente

				String[] divideUser = strLine.split(";");
				
				if (user.equals(divideUser[0])) {
					
					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							// i=2
							numCanzoni = Integer.valueOf(divideUser[i + 1]); // dobbiamo aggiornare questo numero prima
																				// di inserire la nuova canzone
							
							spostamentiCanzoni=3*Integer.valueOf(divideUser[i + 1]);
							cont = i + 1 + spostamentiCanzoni + 1;
								
							//System.out.println(cont);
							// Riscriviamo tutta la riga
							for (int j = 1; j < i; j++) {
								nuovaRiga += divideUser[j] + ";";
							}
							nuovaRiga += nomePlaylist + ";";
							nuovaRiga += String.valueOf(numCanzoni + 1) + ";"; // aggiorniamo il numero di canzoni della
																				// playlist
							
							
							for (int j = i + 2; j < cont; j++) {
								nuovaRiga += divideUser[j] + ";";
								System.out.println(j+" : "+divideUser[j]);
							}
							
							//System.out.println(strLine);
							
							//System.out.println(strLine);
							//nuovaRiga += ";";
							
							nuovaRiga += nomeCanzone + ";0;datiCanzone;"; // inseriamo la nuova canzone

							for (int k = cont; k < divideUser.length; k++) {
								nuovaRiga += divideUser[k] + ";";
							}
							
							
						}

					}
					fileContent.append(nuovaRiga + System.getProperty("line.separator"));
				} else {
					// ... altrimenti la trascrivo così com'è
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
				}
			}

			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter(percorsoFile);
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void aggiungiPlaylist(String user, String nomePlaylist) throws IOException {

		String percorsoFile="src/registrazione/test.txt";
		boolean check = false;
		String nuovaRiga = user + ";";

		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;

		try {
			// apro il file
			fstream = new FileInputStream(percorsoFile);

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine); // stampo sulla console la riga corrispondente

				String[] divideUser = strLine.split(";");
				if (user.equals(divideUser[0])) {

					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							check = true;
						}
					}
					if (check == false) {

						divideUser[1] = String.valueOf(Integer.valueOf(divideUser[1]) + 1);
						nuovaRiga += divideUser[1] + ";";
						for (int j = 2; j < divideUser.length; j++) {
							nuovaRiga += divideUser[j] + ";"; // Riscriviamo tutta la riga e aggiungiamo alla fine la
																// nuova playlist
						}
						nuovaRiga += nomePlaylist + ";" + "0";
					} else if (check == false && Integer.valueOf(divideUser[1]) == 0) { // Se l'user non ha playlist(si
																						// è appena registrato)
						divideUser[1] = String.valueOf(Integer.valueOf(divideUser[1]) + 1); // aggiorno il numero di
																							// playlist (+1)
						nuovaRiga += divideUser[1] + ";";
						for (int j = 2; j < divideUser.length; j++) {
							nuovaRiga += divideUser[j] + ";"; // Riscriviamo tutta la riga e aggiungiamo alla fine la
																// nuova playlist
						}
						nuovaRiga += nomePlaylist + ";" + "0";

					}

					fileContent.append(nuovaRiga + System.getProperty("line.separator"));
				} else {
					// ... altrimenti la trascrivo così com'è
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
				}
			}

			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter(percorsoFile);
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void stampaPlaylist(String user) throws IOException {
		String percorsoFile = "src/registrazione/Playlist.txt";
		String stringMyPlaylists = "";
		int numPlaylist;
		int k;
		int temp;
		int c;
		FileReader fr = null;
		String s;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divideUser = s.split(";");
				if (user.equals(divideUser[0])) {
					numPlaylist = Integer.valueOf(divideUser[1]);
					if (numPlaylist > 0) {
						temp = 3;
						// System.out.println(divideUser[temp - 1]);
						stringMyPlaylists += divideUser[temp - 1] + ";";
						for (int cont = 0; cont < numPlaylist - 1; cont++) {
							c = 2;
							k = Integer.valueOf(divideUser[temp]);
							temp = temp + k + c; // posizione del numero di canzoni che ha una playlist
							// System.out.println(divideUser[temp - 1]); //pos della playlist
							stringMyPlaylists += divideUser[temp - 1] + ";";
						}
					} else {
						System.out.println("Non hai playlist. Creane una!");
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		System.out.println(stringMyPlaylists);
	}

	public static void stampaCanzoni(String user, String nomePlaylist) throws IOException {
		String percorsoFile = "src/registrazione/Playlist.txt";
		FileReader fr = null;
		String s;
		int numCanzoni;
		int conta = 0;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divideUser = s.split(";");
				if (user.equals(divideUser[0])) {

					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) { // se trovo la playlist
							numCanzoni = Integer.valueOf(divideUser[i + 1]);
							if (numCanzoni != 0) {
								System.out.println(numCanzoni);
								for (int j = 0; j < numCanzoni; j++) {
									String[] datiCanzone = divideUser[i + j + 2].split("£");
									// System.out.println(datiCanzone[0]);
									for (int k = 0; k < datiCanzone.length; k++) {

										System.out.println(datiCanzone[k] + ";");
										// System.out.println(conta++);
									}

									// System.out.println(divideUser[i + j + 2]); //posizione della canzone
								}
							} else {
								System.out.println("La playlist: " + nomePlaylist + " non ha canzoni. Aggiungine una!");
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
	}

}
