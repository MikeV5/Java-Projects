package strutturedinamiche;

public class ProvaStruttureDinamiche {

	public static void main(String[] args) {

		
		Pila<String> pila = new Pila<String>();	
		Coda<String> coda = new Coda<String>();
		
		pila.push("aaa");
		pila.push("bbb");
		pila.push("ccc");
		
		coda.aggiungi("ddd");
		coda.aggiungi("eee");
		coda.aggiungi("fff");
		
		System.out.println ("PILA > "+pila.toString());
		System.out.println ("CODA > "+coda.toString());	
		
		
		pila.pop();
		coda.preleva();
		System.out.println ();
		System.out.println ("PILA > "+pila.toString());
		System.out.println ("CODA > "+coda.toString());	
			
	}

}
