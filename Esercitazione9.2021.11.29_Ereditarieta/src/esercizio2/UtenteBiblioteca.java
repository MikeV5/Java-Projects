package esercizio2;

import java.util.Arrays;

public class UtenteBiblioteca {
	
	// campi
	private String nome;
	protected int maxPagine;
	protected Libro[] libriInPrestito;
	
	// costruttori
	public UtenteBiblioteca(String nome, int maxPagine) {
		setNome(nome);
		setMaxPagine(maxPagine);
		libriInPrestito = new Libro[10];
	}
	
	// metodi
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setMaxPagine(int mp){
		this.maxPagine=mp;
	}
	
	public int contaPagineInPrestito(){
		int conteggio = 0;
		for(int i = 0; i< libriInPrestito.length; i++){
			if(libriInPrestito[i] != null) 
				conteggio += libriInPrestito[i].getNumeroPagine();
		}
		return conteggio;
	}
	
	protected boolean aggiungiLibroInPrestito(Libro libro){
		if(libro == null) return false;
		for(int i = 0; i< libriInPrestito.length; i++){
			if(libriInPrestito[i] == null){ //se vuoto(se c'è spazio), si aggiunge il libro
				libriInPrestito[i] = libro;
				return true;
			}
		}
		return false;
	}
	
	public boolean prendiInPrestito(Libro libro){
		if(libro == null) return false;
		if(contaPagineInPrestito() + libro.getNumeroPagine() <= maxPagine){
			return aggiungiLibroInPrestito(libro);
		}
		return false;
	}

	@Override
	public String toString() {
		return "UtenteBiblioteca [nome=" + nome + ", maxPagine=" + maxPagine + ", libriInPrestito="
				+ Arrays.toString(libriInPrestito) + "]";
	}

}
