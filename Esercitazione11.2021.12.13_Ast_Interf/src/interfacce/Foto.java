package interfacce;

public class Foto {
	
	public String contenutoFoto;

	public Foto(String contenutoFoto) {
		this.contenutoFoto = contenutoFoto;
	}

	@Override
	public String toString() {
		return "Foto: " + contenutoFoto;
	}
	
	

}
