package ricorsione;

public class FunzioniArray {

	int[] array;

	public FunzioniArray(int[] array) {

		super();
		this.array = array;
	}

	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		FunzioniArray fa = new FunzioniArray(a);
		System.out.println(fa.sommaArray());
		System.out.println(fa.esiste(2));
	}

	public int sommaArray() {
		/*
		 * int tot = 0; for (int i = 0; i < array.length; i++) { tot = tot + array[i]; }
		 * return tot;
		 */
		return sommaArray(0);

	}

	public int sommaArray(int posizione) {
		if (array.length == posizione)
			return 0;
		else
			return array[posizione] + sommaArray(posizione + 1);

	}

	public boolean esiste(int elem) {
		return esiste(elem, 0);
	}

	private boolean esiste(int elem, int posizione) {
		if ((array.length - 1) == posizione) {
			if (elem == array[posizione])
				return true;
			else
				return false;

		} else {
			if (array[posizione] == elem)
				return true;
			else
				return esiste(elem, posizione + 1);
		}
	}

}
