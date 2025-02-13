package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DopoLogin {
	
	
	
	
	@FXML
	private Button logout;
	@FXML
	private Button bPlaylist;

	@FXML
	 Label wUser;
	
	
	
	public void displayName(String userD) {
	
		wUser.setText(userD);
		
	}
	
	public void userLogout(ActionEvent event) throws IOException {
		Main m = new Main();	//Ritorna al menu principale
		m.scenaMenuPrincipale("mainS.fxml");
	}
	
	public void registraPlaylist(ActionEvent event) throws IOException {
		//Main m = new Main();	//Ritorna al menu principale
		//m.scenaNomePlaylist("namePlaylist.fxml");
		
	}
	
	
}
