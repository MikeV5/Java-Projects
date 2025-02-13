
public class BST {

	Nodo radice;

	public class Nodo {
		public int item;
		public Nodo sx, dx, padre;

		public Nodo(int x) {
			item = x;
			sx = dx = padre = null;
		}
	}

	public BST() {
		radice = null;
	}

	public void insert(int x) {
		insertP(radice, x);

	}

	public void insertP(Nodo n, int x) {

		if (n == null) {
			radice = new Nodo(x);

		} else {
			if (n.item < x) {
				if (n.dx == null) {
					n.dx = new Nodo(x);
					n.dx.padre = n;
				} else {
					insertP(n.dx, x);
				}
			}

			if (n.item > x) {
				if (n.sx == null) {
					n.sx = new Nodo(x);
					n.sx.padre = n;
				} else {
					insertP(n.sx, x);
				}
			}
		}
	}

	public void inorder() {
		inorderP(radice);
		System.out.println();
	}

	private void inorderP(Nodo n) {
		if (n != null) {
			inorderP(n.sx);
			System.out.print(" " + n.item + " ");
			inorderP(n.dx);
		}
	}

	public void stampaRange(int lo, int hi) {

		stampaRangeP(radice, lo, hi);
	}

	public void stampaRangeP(Nodo n, int lo, int hi) {

		if (n == null) {
			return;
		}

		if (n.item > lo)
			stampaRangeP(n.sx, lo, hi);

		if (lo <= n.item && hi >= n.item)
			System.out.println(n.item + " ");

		stampaRangeP(n.dx, lo, hi);

	}

	public static void stampaRangeBST(BST albero, int lo, int hi) {
		stampaRangeBSTP(albero.radice,lo,hi);
	}
		
	public static void stampaRangeBSTP(Nodo n, int lo, int hi) {
		
		if (n == null) {
			return;
		}

		if (n.item > lo)
			stampaRangeBSTP(n.sx, lo, hi);
		if (lo <= n.item && hi >= n.item)
			System.out.println(n.item + " ");
		stampaRangeBSTP(n.dx, lo, hi);

	}
	


}
