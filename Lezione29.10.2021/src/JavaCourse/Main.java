package JavaCourse;

import prog.utili.Rettangolo;

public class Main {

	public static void main(String[] args) {

		Object o = new Object();
		Object p = new Object();
		// Object p = o;

		System.out.println(o.toString());
		System.out.println(p.toString());

		System.out.println(o.equals(p));
		/***********************************/
		Rettangolo r = new Rettangolo(2, 5);
		System.out.println("Area > " + r.getArea());
		System.out.println("Perimetro > " + r.getPerimetro());
		System.out.println("Base > " + r.getBase());
		System.out.println("Altezza > " + r.getAltezza());
		System.out.println(r.toString());
		/*
		 * ESAME: -OVERLOADING: metodi uguali(superclasse e sottoclasse) ma con
		 * parametri diversi -OVERWRITING -> metodi uguali - la sottoclasse riscrive il
		 * metodo della superclasse la classe prende il metodo più vicino che trova - Il
		 * metodo è stato redifinito all'interno della classe(sottoclasse)
		 * Ma in esecuzione quando Rettangolo r = new Quadrato(6) Dipende dall JVM in esecuzione quindi prende il metodo
		 * di quello più a destra ovvero Quadrato 
		 * ESAME: POLIMORFISMO: Quando chiamo un metodo e questa chiamata può assumere più forme a seconda dell'oggetto
		 * 
		 */

		
		
		
		
		
		
	}

}
