package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("scenaTable.fxml"));
			BorderPane root = new BorderPane();
			
			
			TableView<Persona> tableView2 = new TableView<Persona>();
			TableColumn<Persona, String> colNombre = new TableColumn<Persona,String>("Nombre");
			TableColumn<Persona, String> colApellido = new TableColumn<Persona,String>("Apellido");
			
			tableView2.getColumns().addAll(colNombre, colApellido);
			colNombre.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
			colApellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));

			Persona p1 = new Persona("Juan", "Perez");
			Persona p2 = new Persona("Maria", "Loza");
			Persona p3 = new Persona("Adriana", "Mendez");

			tableView2.getItems().addAll(p1, p2, p3);
			root.setCenter(tableView2);
			Scene scene = new Scene(root);		
			//Button button = new Button("Aggiungi");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
