package collection;

public class Main {

	public static void main(String[] args) {

		Libreria l = new Libreria();
		Libro l1 = new Libro("libro1", "autore1", 2000);
		Libro l2 = new Libro("libro1", "autore1", 2000);
		Libro l3 = new Libro("aaaa", "autore1", 2000);

		System.out.println(l.addInList(l1));
		System.out.println(l.addInList(l2));
		System.out.println(l.addInList(l3));
		System.out.println(l.lista.toString());

		System.out.println();
		System.out.println(l.addInTreeSet(l1));
		System.out.println(l.addInTreeSet(l2));
		System.out.println(l.addInTreeSet(l3));
		System.out.println(l.treeS.toString());

		System.out.println();
		System.out.println(l.addInHashSet(l1));
		System.out.println(l.addInHashSet(l2));
		System.out.println(l.addInHashSet(l3));
		System.out.println(l.hashS.toString());

		for (Libro libro : l.hashS)
			System.out.println(libro.getAutore());
		System.out.println();
		l.addInHashMap(l1);
		l.addInHashMap(l1);
		l.addInHashMap(l1);
		System.out.println(l.mappa.get(l1));

	}

}
