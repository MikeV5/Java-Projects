
public class Prodotto{

	// questi li eredito ma nelle sottoclassi non ci posso accedere direttamente
	private String nome;
	private double prezzo;
	private double sconto;

	public Prodotto(String descrizione, double prezzo, double sconto) {
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setSconto(sconto);
	}

	public String getNome() {
		return nome;
	}

	public void setDescrizione(String descrizione) {
		this.nome = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getSconto() {
		return sconto;
	}

	public void setSconto(double sconto) {
		this.sconto = sconto;
	}

	@Override
	public String toString() {
		return "descrizione=" + nome + ", prezzo=" + prezzo + ", sconto=" + sconto + ", prezzo scontato: "
				+ calcolaCosto();
	}

	public double calcolaCosto() {
		return prezzo - (prezzo / 100 * sconto);
	}

}
