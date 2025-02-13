package JavaCourse;

import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Main {

	public static void main(String[] args) {

		Rettangolo r = new Rettangolo(2, 3);
		Quadrato q = new Quadrato(4);
		// operatore instanceof
		System.out.println(r instanceof Rettangolo);// True se r è una istanza della classe quadrato
		System.out.println(r instanceof Quadrato);// false
		System.out.println(q instanceof Rettangolo);// Quadrato e' anche un rettangolo
		System.out.println(q instanceof Quadrato);// true
		/**********************************/
		r=q;
		System.out.println(r instanceof Rettangolo);//true
		System.out.println(q instanceof Quadrato);//true
		/***********************************/
		Rettangolo r = new Quadrato(2); // In fase di esecuzione l'instanceof guarda come viene istanziato l'oggetto(new ...)
		System.out.println(r instanceof Rettangolo);//true
		System.out.println(q instanceof Quadrato);//true
		
		
		
		
		
		/********************************/
		String s = new String("ciao");
		//Instanceof restituisce true se e' la classe stessa o una sottoclasse
		System.out.println(s instanceof String);//true
		System.out.println(s instanceof Object);// String è un sottotipo di object - Fare un instanceof Object sara' sempre vero
		System.out.println(r instanceof Object);//true
		System.out.println(q instanceof Object);//true
		/***********************************/
		Rettangolo r = null;
		//In fase di esecuzione va a guardare se e' inizializzata 
		System.out.println(r instanceof Rettangolo);//false - Non e stato istanziata - Compila ma non esegue 
		System.out.println(r instanceof Quadrato);//false
		
		r= new Quadrato(2);
		System.out.println(r instanceof Rettangolo);//True
		System.out.println(r instanceof Quadrato);//True
		
		r= new Rettangolo(2,3); //Quadrato diventa un rettangolo
		System.out.println(r instanceof Rettangolo);//True
		System.out.println(r instanceof Quadrato);//False 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
