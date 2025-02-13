import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	
	public static void main(String[] args) throws IOException {

		togliSongs("src/registrazione/Canzoni3.txt");
		
		
		/*
		List list = new List();
		BST albero = new BST();
		albero.insert(3);
		albero.insert(2);
		albero.insert(4);
		albero.insert(1);
		albero.insert(5);
		//albero.inorder();
		//BST.stampaRangeBST(albero, 3, 8);
		System.out.println(binsearch(1,5,3));
		*/
		//albero.stampaRange(1,5);
		//System.out.println(BST.solve(albero.radice, 6,7));
		//albero.stampaInorder(albero.radice);
		
	//	list.delete(0);
		//list.insertTesta(1);
		
	//	list.insertTesta(4);
		

	//	System.out.println(list.read(1));
		//System.out.println();
		//list.insertTesta(2);
	//	System.out.println(list.stampaLista());
	//	System.out.println();
	//	list.insert(5,3);
		//list.deleteElement(4);
	//	System.out.println(list.stampaLista());
		/*
		list.insert(3,3);
		System.out.println(list.stampaLista());
		System.out.println(list.read(0));
		System.out.println(list.ricerca(8));*/
	}
	
	public static int binsearch(int sx, int dx, int el) {
		
		int[] a = {1,2,3,4,5};
		if (sx > dx) return -1;
		int x = (sx + dx) / 2;
		if (el == a[x]) return x;
		if (el < a[x]) return binsearch(sx, x - 1, el);
		return binsearch(x + 1, dx, el);
		}
	
	public static void togliSongs(String percorsoFile) throws IOException {

		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedWriter out = null;

		try {
			// apro il file
			fstream = new FileInputStream(percorsoFile);

			// prendo l'inputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder fileContent = new StringBuilder();

			// Leggo il file riga per riga
			int i=0;
			while ((strLine = br.readLine()) != null) {
				
				if (i<100001) {
					
					
					fileContent.append(strLine);
					fileContent.append(System.getProperty("line.separator"));
					i++;
				}
			}
			// Sovrascrivo il file con il nuovo contenuto (aggiornato)
			FileWriter fstreamWrite = new FileWriter(percorsoFile);
			out = new BufferedWriter(fstreamWrite);
			out.write(fileContent.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// chiusura dell'output e dell'input
			try {
				fstream.close();
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
