package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;

public class Login {
	@FXML
	private Button buttonAccedi;
	@FXML
	private Button buttonRegistrati;	
	@FXML
	private Button buttonConsulta;	
	@FXML
	private Label wrongLogin;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	private String percorsoFile = "src/registrazione/UtentiRegistrati.txt";

	
	public String userN;
	
	public String getUserN() {
		return userN;
	}

	public void setUserN(String userN) {
		this.userN = userN;
	}

	@FXML
	public void userLogin(ActionEvent event) throws IOException {
		//userN=username.getText().toString();
		login();
	}
	public void userRegistrazione(ActionEvent event) throws IOException {
		
	}
	public void userConsulta(ActionEvent event) throws IOException {
		
	}
	
	
	public void login() throws IOException {

		Main m = new Main();
		String nomeUser = "";

		nomeUser = username.getText().toString() + ";" + password.getText().toString();
		boolean check = checkLogin(nomeUser);

		if (check == true) {
			wrongLogin.setText("Success!");
			m.scenaDopoLogin("dopoLogin.fxml",username.getText().toString());

		} else {
			wrongLogin.setText("Accesso non riuscito. Riprova l'accesso.");
		}
	}

	public boolean checkLogin(String nomeUser) throws IOException {
		FileReader fr = null;
		String s;
		boolean check = false;
		try {
			fr = new FileReader(percorsoFile);
			BufferedReader br2 = new BufferedReader(fr);

			while ((s = br2.readLine()) != null) {
				if (nomeUser.equals(s)) {
					check = true;
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("File non trovato.");
		} finally {
			fr.close();
		}
		return check;
	}

}
