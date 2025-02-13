package javaCourse;

public class Main {

	public static void main(String[] args) {
		String s ="ciao";
		int i=0;

		try {	//blocco try			
			char c = s.charAt(i);
			//System.out.println("Carattere in posizione "+i+": "+c);
			System.out.println("Divisione: "+s.length()/i);
		} catch (StringIndexOutOfBoundsException e) {
			//System.err.println("Errore 1: posizione " + i + " non valida per la stringa " + s);

			System.err.println(e.getMessage());	//"e" è l'oggetto che rappresenta l'eccezioni
			//e.printStackTrace();
			System.err.println(e.toString());
				
		}catch(ArithmeticException e) {
			System.err.println("Errore 2: divisione per zero");
			
		}finally {
				System.out.println(":(");
			
		}
		System.out.println(":("); //Se non si verifica l'eccezione non verrà eseguito comunque ma si quello del blocco finally
		//blocco finally: qualsiasi cosa accada, sia che ci sia un'eccezione o no, verranno egeuite le istruzione del blocco
		
		//Eccezioni: Si garantisce la continuità del codice 
		//Segnala l'errore e continua l'esecuzione
		//Pila.> LIFO
		//Coda-> FIFO
		
		
	}

}
