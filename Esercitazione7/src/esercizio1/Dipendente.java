package esercizio1;

public class Dipendente {

	private String nome;
	private double costo;
	private int matricola;
	private static int ultimaMatricola = 0;

	public Dipendente(String nome, double costo, int matricola) {
		this.nome = nome;
		this.costo = costo;
		setMatricola(matricola);
	}

	public Dipendente(String nome, int matricola) {
		this(nome, 1000, matricola);
	}

	public Dipendente() {
		this("prova", 1000, getNewMatricola());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public static int getNewMatricola() {
		return ++ultimaMatricola;
	}
	
	public static int getLastMatricola() {
		return ultimaMatricola;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
