package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Libreria {

	public List<Libro> lista = new ArrayList<Libro>();
	public Set<Libro> treeS = new TreeSet<Libro>();
	public Set<Libro> hashS = new HashSet<Libro>();
	public Map<Libro, Integer> mappa = new HashMap<Libro, Integer>();

	public boolean addInList(Libro l) {
		return lista.add(l);
	}

	public boolean addInTreeSet(Libro l) {
		return treeS.add(l);
	}

	public boolean addInHashSet(Libro l) {
		return hashS.add(l);

	}

	public boolean addInHashMap(Libro l) {
		if (!mappa.containsKey(l))
			mappa.put(l, 1);
		else
			mappa.put(l, mappa.get(l) + 1);
		return true;

	}

	public boolean containList(Libro l) {
		return lista.contains(l);
	}

	public boolean containTreeSet(Libro l) {
		return treeS.contains(l);
	}

}
