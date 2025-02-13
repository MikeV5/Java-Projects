package esercizio1;

public class Azienda {

	private final static int MAXDIPDEF = 5;
	private String nome;
	Dipendente[] dipendenti;

	public Azienda(String nome) {
		this(nome, MAXDIPDEF);
	}

	public Azienda(String nome, int maxDip) {
		this.nome = nome;
		//assumo che maxDip> 0
		dipendenti = new Dipendente[maxDip];
	}

	public int numDipendenti() {
		return dipendenti.length;
	}
	
	public boolean assumi(Dipendente nuovoDip) {
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
