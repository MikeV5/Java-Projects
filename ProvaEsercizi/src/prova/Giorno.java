package prova;

public enum Giorno {
	LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA;


	public String toString() {
		switch(this) {
		case LUNEDI:
			return "Lunedi";
		case MARTEDI:
			return "Martedi";
		
		case MERCOLEDI:
			return "Mercoledi";
		default:
			return "";
		
		}
		
		
		
	}
	
}
