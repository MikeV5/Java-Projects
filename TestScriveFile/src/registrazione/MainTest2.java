package registrazione;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainTest2 {

	

	public static void main(String[] args) throws IOException {
	
		
		String user = "admin3";
		String nomePlaylist = "playlist1";
		String nomeCanzone = "21 Guns£Green Day£15/05/2009";
		String nomeCanzone2 = "canzone1";
		String datiCanzone = "datiCanzone-datiiiiii";

		// aggiungiPlaylist(user, nomePlaylist);
		// scriviCanzone(user,nomePlaylist,nomeCanzone2);

		// scriviEmozione3(user, nomePlaylist, nomeCanzone, datiCanzone);

		int[] arrayEmozioni=totEmozioni(nomeCanzone);
		int[] arrayEmozioni2=totaliEmozioni(nomeCanzone);
		double[] mediaEmozioni= {0,0,0,0,0,0,0,0,0};
		System.out.println();
		String[] listaEmozioni = { "Amazement", "Solemnity", "Tenderness", "Nostalgia", "Calmness", "Power", "Joy",
				"Tension", "Sadness" };
		
		for (int i = 0; i < listaEmozioni.length; i++) {
			//System.out.println(listaEmozioni[i]+" : "+arrayEmozioni2[i]);
	
			if(arrayEmozioni2[i]!=0) {
				mediaEmozioni[i]=(double)arrayEmozioni[i]/(double)arrayEmozioni2[i];
				System.out.println(i+" : "+mediaEmozioni[i]);
				
			}
			
		}
		
		// stampaEmozione2(user, nomePlaylist, nomeCanzone, datiCanzone);
		// stampaCanzoni2(user, nomePlaylist, nomeCanzone, datiCanzone);

		// catalogoCanzoni();
		// stampaCanzoni(user, nomePlaylist);
		// stampaPlaylist(user);
	}

	public static boolean controllaEmozione(String emozione) {
		
		return false;
	}
	
	public static int[] totEmozioni(String nomeCanzone) throws IOException {

		String[] listaEmozioni = { "Amazement", "Solemnity", "Tenderness", "Nostalgia", "Calmness", "Power", "Joy",
				"Tension", "Sadness" };
		int[] punteggioEmozioni= {0,0,0,0,0,0,0,0,0};
		String percorsoFile = "src/registrazione/test.txt";
		FileReader fr = null;
		String s;
		boolean checkSong=false;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divideUser = s.split(";");
				

					for (int i = 0; i < divideUser.length; i++) {
						if (divideUser[i].equals(nomeCanzone) && Integer.parseInt(divideUser[i + 1]) != 0 && checkSong==false) { //controlla se c'è la canzone e si ferma nel caso ci fossero di più
							String[] datiEmozioni = divideUser[i + 2].split("-");
							checkSong=true;
							for (int j = 0; j < datiEmozioni.length; j++) {
								
								
								for(int k=0;k<listaEmozioni.length;k++) {
									if(datiEmozioni[j].equals(listaEmozioni[k])) {
										//System.out.println(j + " : " + datiEmozioni[j]);
										punteggioEmozioni[k]=punteggioEmozioni[k]+Integer.parseInt(datiEmozioni[j+1]);
										//System.out.println(punteggioEmozioni[k]);
									}					
								}
							}
						}
					}
					checkSong=false;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		return punteggioEmozioni;
	}

	public static int[] totaliEmozioni(String nomeCanzone) throws IOException {

		String[] listaEmozioni = { "Amazement", "Solemnity", "Tenderness", "Nostalgia", "Calmness", "Power", "Joy",
				"Tension", "Sadness" };
		int[] contEmozioni= {0,0,0,0,0,0,0,0,0};
		String percorsoFile = "src/registrazione/test.txt";
		FileReader fr = null;
		String s;
		int cont=0;
		//int check=0;
		boolean checkSong=false;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divideUser = s.split(";");
				

					for (int i = 0; i < divideUser.length; i++) {
						if (divideUser[i].equals(nomeCanzone) && Integer.parseInt(divideUser[i + 1]) != 0 && checkSong==false) {
							String[] datiEmozioni = divideUser[i + 2].split("-");
							checkSong=true;
							for (int j = 0; j < datiEmozioni.length; j++) {
								
								
								for(int k=0;k<listaEmozioni.length;k++) {
									if(datiEmozioni[j].equals(listaEmozioni[k])) {
										
										//System.out.println(j + " : " + datiEmozioni[j]+" : "+Integer.parseInt(datiEmozioni[j+1]));
										contEmozioni[k]=contEmozioni[k]+1;
										//System.out.println(punteggioEmozioni[k]);
									}		
									
								}
							}
						}
						
					}
					checkSong=false;
				}

			
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		return contEmozioni;
	}
	
	public static void scriviEmozione3(String user, String nomePlaylist, String nomeCanzone, String datiCanzone) {
		int numCanzoni;
		String nuovaRiga = user + ";";
		String percorsoFile = "src/registrazione/test.txt";
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

							System.out.println(i);
							numCanzoni = 3 * Integer.valueOf(divideUser[i + 1]); // i=2 numSpostamenti = 4
							// numSpostamenti = Integer.valueOf(divideUser[i + 1]);

							for (int j = i + 2; j < i + numCanzoni; j++) {

								System.out.println(j + " : " + divideUser[j]);
								// System.out.println(divideUser[j]);
								if (divideUser[j].equals(nomeCanzone)) {

									for (int k = 1; k < j; k++) {
										nuovaRiga += divideUser[k] + ";";
									}
									nuovaRiga += divideUser[j] + ";"; // canzone input
									// System.out.println(j);

									if (Integer.valueOf(divideUser[j + 1]) == 0) {

										// System.out.println(j);
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone + ";"; // info emozioni della canzone input

										for (int m = j + 3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}
										// String[] divideEmotion=divideUser[j+1].split("-");
									} else if (Integer.valueOf(divideUser[j + 1]) == 1) {
										nuovaRiga += 1 + ";";
										nuovaRiga += datiCanzone + ";"; // info emozioni della canzone input
										for (int m = j + 3; m < divideUser.length; m++) {
											nuovaRiga += divideUser[m] + ";";
										}
										// System.out.println("c'è già");
									}

								}
							}
						}
					}
					System.out.println("\n" + nuovaRiga);
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

	public static void scriviCanzone(String user, String nomePlaylist, String nomeCanzone) {
		int numCanzoni;
		int cont;
		String nuovaRiga = user + ";";
		String percorsoFile = "src/registrazione/test.txt";
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
				// System.out.println(strLine); // stampo sulla console la riga corrispondente

				String[] divideUser = strLine.split(";");

				if (user.equals(divideUser[0])) {

					// se la riga è uguale a quella ricercata
					for (int i = 0; i < divideUser.length; i++) { // itero la riga per cercare la playlist
						if (divideUser[i].equals(nomePlaylist)) {
							// i=2
							numCanzoni = Integer.valueOf(divideUser[i + 1]); // dobbiamo aggiornare questo numero prima
																				// di inserire la nuova canzone

							spostamentiCanzoni = 3 * Integer.valueOf(divideUser[i + 1]);
							cont = i + 1 + spostamentiCanzoni + 1;

							// System.out.println(cont);
							// Riscriviamo tutta la riga
							for (int j = 1; j < i; j++) {
								nuovaRiga += divideUser[j] + ";";
							}
							nuovaRiga += nomePlaylist + ";";
							nuovaRiga += String.valueOf(numCanzoni + 1) + ";"; // aggiorniamo il numero di canzoni della
																				// playlist

							for (int j = i + 2; j < cont; j++) {
								nuovaRiga += divideUser[j] + ";";
								System.out.println(j + " : " + divideUser[j]);
							}

							// System.out.println(strLine);

							// System.out.println(strLine);
							// nuovaRiga += ";";

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

		String percorsoFile = "src/registrazione/test.txt";
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
}
