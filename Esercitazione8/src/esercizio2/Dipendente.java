package esercizio2;

public class Dipendente {

	private String nome;
	private double costo;
	private int matricola;

	private static int ultimaMatricola = 0;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) throws InputException{
		if(costo<=0) throw new InputException();
		else this.costo = costo;
	}

	public int getMatricola() {
		return matricola;
	}

	private void setMatricola(int m) {
		this.matricola = m;
	}

	// questo metodo e' lacale alla classe, quindi posso accedere direttamente ai
	// campi private
	// o se preferisco posso usare cmq i getter, ma e' un po' inutile
	@Override
	public String toString() {
		return "Dipendente [nome=" + nome + ", costo=" + getCosto() + ", matricola=" + matricola + "]";
	}

	// notate, e' privato
	private Dipendente(String nome, double costo, int matricola) throws InputException{
		this.nome = nome;
		//if(costo<=0) throw new InputException();
		//else this.costo = costo;
		//Lanciare un'eccezione qui è un problema quando poi vogliamo fare delle modifiche, dovremmo farle in tutti i punti dove lanciamo l'InputException
		//quindi chiamiamo il metodo setCosto che lancia l'eccezione
		setCosto(costo);		
		/*******************************************************************/
		// questo costruttore e' pensato in alternativa a quello che gestisce in
		// autonomia le matricole
		// quindi qui non faccio un controllo che questa matricola non sia gia'
		// presente, pero' ha senso gia' prevederlo,
		// quindi meglio usare il setter, coseì in futuro posso aggiungere il controllo
		// nel setter, e non ripetere il codice
		setMatricola(matricola);
	}

	// questo gestisce in autonomia le matricole, così che siano univoche
	public Dipendente(String nome, double costo) throws InputException{
		this(nome, costo, getNewMatricola());
	}

	public Dipendente(String nome) throws InputException{
		// this("prova",1000, 0);
		this(nome, 1000, getNewMatricola());
	}

	public double calcolaRal() throws Exception{
		return calcolaRal(12);
	}

	public double calcolaRal(int mesi) {
		return costo * mesi;
	}

	private static int getNewMatricola() {
		return ++ultimaMatricola;
	}

	public static int getLastMatricola() {
		return ultimaMatricola;
	}

	// questa e' la struttura standard di un equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// questo lo vedremo meglio quando faremo ereditarieta', per ora lasciamolo
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		if (matricola != other.matricola)
			return false;
		return true;
	}

}
