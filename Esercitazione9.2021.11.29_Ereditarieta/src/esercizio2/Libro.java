package esercizio2;

public class Libro {
	
	// campi
	private String titolo;
	private int pagine;
	private boolean narrativa;

	// costruttori
	public Libro(String titolo, int pagine, boolean narrativa){
		setTitolo(titolo);
		setPagine(pagine);
		setNarrativa(narrativa);
	}
	
	// metodi
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}
	
	public void setPagine(int pagine){
		if(pagine > 0) this.pagine = pagine;
		else this.pagine=1;
	}
	
	public void setNarrativa(boolean narrativa){
		this.narrativa=narrativa;
	}
	
	public int getNumeroPagine(){
		return pagine;
	}
	
	public boolean isNarrativa(){
		return narrativa;
	}

	public String toString(){
		String s;
		s = "Titolo del volume: " + this.titolo;
		s += ", numero di pagine: " + this.pagine+"\n";
		return s;
	}
}
