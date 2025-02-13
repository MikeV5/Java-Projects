package application;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

	 StringProperty nombre = new SimpleStringProperty();
	 StringProperty apellido = new SimpleStringProperty();

	 
	 public Persona(String nombre, String apellido) {
			
			this.nombre = new SimpleStringProperty(nombre);
			this.apellido =  new SimpleStringProperty(apellido);
		}
	 
	 
	public StringProperty nombreProperty() {
		return nombre;
	}

	public StringProperty apellidoProperty() {
		return apellido;
	}
	
	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String value) {
		apellido.set(value);
	}
	
	public String getApellido() {
		return apellido.get();
	}
	
	public void setApellido(String value) {
		apellido.set(value);
	}
	
	
	



	

}