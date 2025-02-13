
public abstract class Figura {

	// CAMPI
	// non serovno dal momento che non c'� il costruttore

	// METODI
	// 2 metodi senza fornire implementazione
	public abstract double getPerimetro();

	public abstract double getArea();
/*******************  METODI CHE NON DIPENDONO DAL TIPO DI FIGURA*****************************************/
	// Ma sipu� comunque creare un metodo concreto(implementazione - codice)
	public boolean haAreaMaggiore(Figura f) {
		return this.getArea() > f.getArea();  //getArea verr� chiamata da un'istanza in concreto	
	}

	public boolean haPerimetroMaggiore(Figura f) {
		return this.getPerimetro() > f.getPerimetro();	
	}
	
	
}
