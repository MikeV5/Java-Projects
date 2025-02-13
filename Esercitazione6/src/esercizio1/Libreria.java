package esercizio1;

import java.util.Arrays;
import java.util.List;

public class Libreria {
	List<String> libri;
	String nome;
	
	
	public Libreria(String nome) {
		
		libri.add(nome);
		
	}


	@Override
	public String toString() {
		return "Libreria [libri=" + libri + "]";
	}
	

	
	
	
	
	
	
	
}
