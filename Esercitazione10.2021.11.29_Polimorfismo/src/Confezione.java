
public class Confezione extends Prodotto {

	// campi
	private int pezzi = 1;

	// costruttori
	public Confezione(String descrizione, double costo_base, double iva, int pezzi) {
		super(descrizione, costo_base, iva);
		this.pezzi = pezzi;

	}

	// metodi
	public int getPezzi() {
		return pezzi;
	}
	
	@Override // E' un override perché ritorna una sottoclasse di Prodotto
	public Confezione dividi() {
		return dividi(pezzi);
	}
	
	@Override
	public Confezione dividi(int n) {
		return new Confezione(getDescrizione(),getCosto_base(),getIva(),pezzi/n);
	}
	
	@Override
	public double getPrezzo() {
		// return getIva()*getCosto_base()*pezzi;
		return super.getPrezzo() * pezzi;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && pezzi == ((Confezione) obj).pezzi;
	}

	@Override
	public String toString() {
		return super.toString() + ", pezzi: " + pezzi;
	}

}
