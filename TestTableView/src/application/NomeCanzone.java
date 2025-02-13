package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NomeCanzone implements Initializable {

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
	
	private String percorsoFile = "src/registrazione/Playlist.txt";
	@FXML
	private TextField textFieldNomeCanzone;
	@FXML
	private Label labelUser;
	@FXML
	private Label labelPlaylist;
	@FXML
	private Label labelErrore;
	@FXML
	private TableView<Canzone> songTable;
	@FXML
	private TableColumn<Canzone, String> titoloCol;
	@FXML
	private TableColumn<Canzone, String> autoreCol;
	@FXML
	private TableColumn<Canzone, String> annoCol;

	ObservableList<Canzone> dataList = FXCollections.observableArrayList();

	public void displayName(String user, String nomePlaylist, ArrayList<Canzone> catalagoSongs) {

		// , ArrayList<Canzone> catalagoSongs
		labelUser.setText(user);
		labelPlaylist.setText(nomePlaylist);

		/*
		 * ObservableList<Canzone> list =
		 * FXCollections.observableArrayList(catalagoSongs);
		 * titoloCol.setCellValueFactory(new PropertyValueFactory<Canzone,
		 * String>("nomeCanzone")); autoreCol.setCellValueFactory(new
		 * PropertyValueFactory<Canzone, String>("nomeAutore"));
		 * annoCol.setCellValueFactory(new PropertyValueFactory<Canzone,
		 * String>("dataCanzone")); // playlistTable.getItems().addAll(arrayP);
		 * songTable.setItems(list);
		 */

	}

	public void initialize(URL url, ResourceBundle rb) {

		titoloCol.setCellValueFactory(new PropertyValueFactory<Canzone, String>("nomeCanzone"));
		autoreCol.setCellValueFactory(new PropertyValueFactory<Canzone, String>("nomeAutore"));
		annoCol.setCellValueFactory(new PropertyValueFactory<Canzone, String>("dataCanzone"));
	
		try {
			dataList = FXCollections.observableArrayList(caricaCatalogoSongs());
	
			// Wrap the ObservableList in a FilteredList (initially display all data).
			FilteredList<Canzone> filteredData = new FilteredList<>(dataList, b -> true);

			// 2. Set the filter Predicate whenever the filter changes.
			textFieldNomeCanzone.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(canzone -> {
					// If filter text is empty, display all persons.

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare first name and last name of every person with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
			
					if (convertNonAscii(canzone.getNomeCanzone().toLowerCase()).indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					} else if (convertNonAscii(canzone.getNomeAutore().toLowerCase()).indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches last name.
					} else if (canzone.getDataCanzone().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true;
					}else if (convertNonAscii((canzone.getNomeAutore()+" "+canzone.getDataCanzone())).toLowerCase().indexOf(lowerCaseFilter) != -1)
						return true;
					else
						return false; // Does not match.
				});
			});

			// 3. Wrap the FilteredList in a SortedList.
			SortedList<Canzone> sortedData = new SortedList<>(filteredData);

			// 4. Bind the SortedList comparator to the TableView comparator.
			// Otherwise, sorting the TableView would have no effect.
			sortedData.comparatorProperty().bind(songTable.comparatorProperty());

			// 5. Add sorted (and filtered) data to the table.
			songTable.setItems(sortedData);
			//			songTable.setItems(dataList);
			// songTable.setItems(list);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String convertNonAscii(String s) {
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
	public void annullaNomeCanzone(ActionEvent event) throws IOException {
	}

	public void salvaNomeCanzone(ActionEvent event) throws IOException {

		String nomePlaylist = labelPlaylist.getText().toString();
		String user = labelUser.getText().toString();

		ObservableList<Canzone> catalT;
		catalT = songTable.getSelectionModel().getSelectedItems();
		if (catalT.isEmpty())
			labelErrore.setText("Devi selezzionare una canzone!");
		else {
			System.out.println(catalT.get(0).getNomeCanzone());
			Main2 m = new Main2();
			String nomeCanzone = catalT.get(0).getNomeCanzone(); // Canzone selezionata dalla tabella
			String nomeAutore = catalT.get(0).getNomeAutore();
			String dataCanzone = catalT.get(0).getDataCanzone();
			String infoCanzoni = nomeCanzone + "£" + nomeAutore + "£" + dataCanzone;
			labelErrore.setText(infoCanzoni);
			
			//addSong(user, nomePlaylist, infoCanzoni);// aggiungiamo la nuova canzone nel file Paylist.txt
			//addSongEmotion(user, nomePlaylist, infoCanzoni); // aggiungiamo la nuova canzone nel file Emotions.txt
			// questo cambia tutto-------->playlistT.get(0).getNomePlaylist();
			// (caricaSong(user, nomePlayString)
			// m.scenaListaCanzoni("listaCanzoni.fxml", user, nomePlaylist,
			// listCanzoni(user, nomePlaylist));
		}
	}

	public ArrayList<Canzone> caricaCatalogoSongs() throws IOException {
		ArrayList<Canzone> catalogoSongs = new ArrayList<>();
		String percorsoFile = "src/registrazione/Canzoni.txt";
		
		Properties properties = new Properties();
		
	//	InputStream inputStream = new FileInputStream(percorsoFile);
		//Reader reader = new InputStreamReader(inputStream, "UTF-8");
		FileReader fr = null;
		String s;
		int conta=0;

		try {
			
			fr = new FileReader(percorsoFile,StandardCharsets.UTF_8); //Codifica UTF_8 (per i caratteri )
			BufferedReader br = new BufferedReader(fr);
			while ((s = br.readLine()) != null) {
				String[] divInfoCanzone = s.split(";");
				if(conta!=0) {
				
				catalogoSongs.add(new Canzone(divInfoCanzone[0], divInfoCanzone[1], divInfoCanzone[2])); // titolo,
				}																						// autore e
				conta++;																							// anno
				// System.out.println(divInfoCanzone[0]+";"+divInfoCanzone[1]);
			}
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}

		return catalogoSongs;
	}

	public ArrayList<Canzone> listCanzoni(String user, String nomePlaylist) throws NumberFormatException, IOException {
		String percorsoFile = "src/registrazione/Playlist.txt";
		ArrayList<Canzone> arrayCanzoni = new ArrayList<>();
		FileReader fr = null;
		String s;
		int numCanzoni;
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
								for (int j = 0; j < numCanzoni; j++) {
									String[] datiCanzone = divideUser[i + j + 2].split("£"); // la canzone è composta di
																								// titolo, autore e anno
																								// divisi con il
																								// carattere "£"

									arrayCanzoni.add(new Canzone(datiCanzone[0], datiCanzone[1], datiCanzone[2]));
									System.out.println(datiCanzone[0] + ";" + datiCanzone[1] + ";" + datiCanzone[2]);
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
		return arrayCanzoni;
	}

	public void addSong(String user, String nomePlaylist, String nomeCanzone) throws IOException {

		int numCanzoni;
		int cont;
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
							numCanzoni = Integer.valueOf(divideUser[i + 1]); // dobbiamo aggiornare questo numero
																				// prima
							cont = i + 1 + numCanzoni + 1;
							System.out.println(cont);
							for (int j = 1; j < i; j++) {
								nuovaRiga += divideUser[j] + ";";
							}
							nuovaRiga += nomePlaylist + ";";
							nuovaRiga += String.valueOf(numCanzoni + 1) + ";";

							for (int j = i + 2; j < cont; j++) {
								nuovaRiga += divideUser[j] + ";";
							}

							nuovaRiga += nomeCanzone + ";";

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

	public void addSongEmotion(String user, String nomePlaylist, String nomeCanzone) throws IOException {
		int numCanzoni;
		int cont;
		String nuovaRiga = user + ";";
		String percorsoFile = "src/registrazione/Emozioni.txt";
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

}
