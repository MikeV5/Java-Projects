package classiAstratte;

public abstract class Dipendente {
	
	String nomeCognome;
	double stipendioMensile;
	int matricola;
	
	
	public Dipendente(String nomeCognome, int matricola,double stipendioMensile ) {
		super();
		this.stipendioMensile = stipendioMensile;
		this.matricola = matricola;
		this.nomeCognome = nomeCognome;
	}
	
	public abstract double calcolaRal();

	@Override
	public String toString() {
		return "Dipendente [nomeCognome=" + nomeCognome + ", stipendioMensile=" + stipendioMensile + ", matricola="
				+ matricola + ", calcolaRal()=" + calcolaRal() + "]";
	}


	
	
	
	
	
	

}
