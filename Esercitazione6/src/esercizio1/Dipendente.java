package esercizio1;

import java.util.Objects;

public class Dipendente {

	// CAMPI
	private String nome;
	private int matricola;
	private double costo;
	private static final double DEFCOSTO=1000;

	// COSTRUTTORI
	
	//Costruttori in overload
	public Dipendente(String nome, int matricola, double costo) {
		super(); //Chiama il costruttore della super classe
		this.nome = nome;
		this.matricola = matricola;
		this.setCosto(costo);
	}
	
	public Dipendente(String nome, int matricola) {
		/*
		this.nome = nome;
		this.matricola = matricola;
		this.costo = 1000; // ma anche costo = 1000 senza il this perché non c'è ambiguità
		*/
		this(nome,matricola,DEFCOSTO);
	}
	
	public Dipendente() {
		this("prova",1,DEFCOSTO);
	}
	// METODI

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public double getCosto() {
		return costo;
	}

	private void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " matricola: " + matricola + " costo: " + costo;
	}

	/*
	 * @Overload public double calcolaRal() {
	 * 
	 * 
	 * 
	 * }
	 */
	
//OVERLOAD
	public double calcoloRal() {
		return this.calcoloRal(12);
	}
	
	public double calcoloRal(int mesi) {
		return this.costo * mesi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //se la classe corrente non è uguale  a una sottoclasse di object(es frazione), esce
			return false;
		Dipendente other = (Dipendente) obj; //fa  il cast e assegna il valore a other e lo confronta con this.matricola
		return matricola == other.matricola;
	}
	
	
/*
	public boolean equals(Dipendente d) {	
		return (matricola==d.matricola);
	}
*/	
	
	
	
	
	
	
	
	
	
	
	
}
