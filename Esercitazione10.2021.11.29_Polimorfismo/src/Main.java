
public class Main {

	public static void main(String[] args) {

		Prodotto p1 = new Prodotto("Vino Rosso", 10, 1.2);
		Prodotto p2 = new Prodotto("Vino ROSSO", 10, 1.2);
		Prodotto p3 = new Prodotto("Vino Rosso", 20, 1.2);
		Prodotto p4 = new Confezione("Macine", 10, 1.2, 30); // tipo dinamico Confezione
		Confezione p5 = new Confezione("Girelle", 5, 1.2, 10);
		Prodotto p6 = new Confezione("Girelle", 5, 1.2, 10);

		System.out.println(p1.equals(p2)); // true - anche se puntano diversi spazi di memoria sono uguali di contenuto
											// (diverso da p1==p2)
		System.out.println(p1.equals(p3)); // false
		System.out.println(p1.equals(null)); // false
		System.out.println(p4.equals(p5)); // false
		System.out.println(p5.equals(p6)); // true
		System.out.println(p5.equals(p1)); // false
		System.out.println(p4.equals(p1)); // false
		System.out.println("\n\n");
		/**************************************************/
		Regalo r = new Regalo(p1);
		System.out.println(r.scarta());
		System.out.println(r.stampaPrezzo());

		r = new Regalo(p4);
		System.out.println(r.scarta());
		System.out.println(r.stampaPrezzo());

		// r = new Regalo(new Object()); //Stampa la toString di Object
		// System.out.println(r.scarta());
		// System.out.println(r.stampaPrezzo());

		Regalo r2 = new Regalo(r);
		System.out.println(r2.scarta());
		System.out.println(r.stampaPrezzo());
		/**************************************************/
		Prodotto p7 = new Prodotto("Vino Rosso", 10, 1.2);
		Prodotto c = new Confezione("Girelle", 10, 1.2, 10);
		Prodotto p8 = p7.dividi();
		System.out.println(p8 instanceof Prodotto); // true
		System.out.println(p8.getCosto_base()); // 10/2 = 5
		p8 = p1.dividi(4);
		System.out.println(p8 instanceof Prodotto); // true
		System.out.println(p8.getCosto_base()); // 10/4 = 2.5

		p8 = c.dividi(); // c dinamicamente è una confezione
		System.out.println(p8 instanceof Confezione); // true
		System.out.println(p8.getCosto_base()); // 10 
		System.out.println(((Confezione) p8).getPezzi()); //1
		
		p8 = c.dividi(2);
		System.out.println(p8 instanceof Confezione); // true
		System.out.println(p8.getCosto_base()); // 10
		System.out.println(((Confezione) p8).getPezzi()); // 5

	}

}
