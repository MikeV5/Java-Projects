package esercizio2;

import esercizio2.Dipendente;
import esercizio2.InputException;

public class Azienda {

	private Dipendente[] dipendenti;
	private String nome;

	public Azienda() throws InputException{ //La clausula "throws" vuol dire che può lanciare un'eccezione ma non sempre
		//Però in realtà questo metodo non potrà mai lanciare un'eccezione in quanto gli passiamo 1
		//Ma non abbiamo alternantiva
		this("prova", 1); //Potrebbe lanciare un'eccezione perché richiama il costruttore
	}

	public Azienda(String nome, int numDip) throws InputException{
		if(numDip<=0) throw new InputException(); 
		dipendenti = new Dipendente[numDip]; //Funzionerà soltanto se numDip è maggiore di 0
		setNome(nome);
	}

	public String getNome() {

		return nome;
	}

	private void setNome(String nome) {

		this.nome = nome;
	}

	public int numDip() {
		return dipendenti.length;
	}

	public boolean assumi(String nome, double costo) {
		//Invece di mettere throws InputException, ha senso gestirla con un try catch
		Dipendente d;
		try {
			d = new Dipendente(nome, costo); //Se non c'è l'eccezione esegue il metodo assumi 
			return assumi(d);
		} catch (Exception e) {
			e.printStackTrace();
			return false; //Se cattura l'errore esce
		}
		
	}

	public boolean assumi(String nome) {
		Dipendente d;
		try {
			d = new Dipendente(nome);
			return assumi(d);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean assumi(Dipendente nuovoDip) throws Exception{
		if(nuovoDip==null) throw new Exception("Dipendente null"); //Se mettiamo un throw dobbiamo dire al metodo che può lanciare l'eccezione
		if(contains(nuovoDip)) throw new Exception("Dipendente esiste già");
		//if (nuovoDip != null) {
			if (dipendenti != null) {
				for (int i = 0; i < dipendenti.length; i++) {
					if (dipendenti[i] == null) {
						dipendenti[i] = nuovoDip;
						return true;
					}
				}
			}
			return false; //Vuoldire che non c'è spazio
		//} else
			//return false;
	}

	public Dipendente licenzia(int matricola) {

		Dipendente app = getDipendente(1);
		return licenzia(app);
	}

	public Dipendente licenzia(Dipendente dip) {
		if (dip == null)
			return null;

		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null && dipendenti[i].equals(dip)) {
				Dipendente d = dipendenti[i];
				dipendenti[i] = null;
				return d;
			}
		}
		return null;
	}

	public double calcolaCosto() {
		double costo = 0.0;
		if (dipendenti == null)
			return costo;
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null)
				costo = costo + dipendenti[i].getCosto();
		}
		return costo;
	}

	public boolean contains(Dipendente dip) {
		/*
		 * if(dipendenti == null) return false; if(dip==null) return false;
		 * 
		 * for(int i = 0; i < dipendenti.length; i++) { if(dipendenti[i] != null)
		 * if(dipendenti[i].equals(dip)) return true; } return false;
		 */
		if (getDipendente(dip.getMatricola()) == null)
			return false;
		else
			return true;
	}

	public boolean contains(int matricola) {
		Dipendente d = new Dipendente("appoggio", matricola);
		return contains(d);
	}

	public Dipendente getDipendente(int matricola) {
		if (dipendenti == null)
			return null;
		if (matricola <= 0)
			return null;

		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null)
				if (dipendenti[i].getMatricola() == matricola)
					return dipendenti[i];
		}
		return null;
	}

	public String toString() {
		String s = nome + " con max " + numDip() + " e dipendenti: \n";
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null) {
				s = s + dipendenti[i].toString() + "\n";
			}
		}
		s = s + " e costo = " + calcolaCosto();
		return s;
	}
}
