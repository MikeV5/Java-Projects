package JavaCourse;
import prog.utili.*;

public class Main2 {

	public static void main(String[] args) {

		Object o;
		Rettangolo r;
		Quadrato q;
		Frazione f;
		//Ogni oggetto ne dispone di un metodo toString
		o.toString(); //ok compile ok exe
		r.toString(); //ok compile ok exe
		q.toString(); //ok compile ok exe
		f.toString(); //ok compile ok exe
		
		o=o;//ok ma non serve a niente
		o = r; //perché r è una sottoclasse
		o=q;//ok
		o=f;//ok
		r=o;//no
		r=q; //perche quadrato e' sottotipo di rettangolo
		r=f; //no
		o= (Rettangolo) r; //ok, cast inutile
		r= (Rettangolo) r; //ok, cast inutile
		q= (Rettangolo) r; //no compile , cast inutile e in più non si può assegnare a una sottoclasse
		f= (Rettangolo) r; //no compile
		o= (Quadrato)r; //ok compile, ? exe -> ok exe se non si inizializza r con new Rettango()
		r= (Quadrato)r;	//ok compile - ? exe (il cast va in errore)-> se r non e' una istanza di quadrato
		q= (Quadrato)r;	//ok compile - ? exe
		f=(Quadrato)r; //no compile
		r=(Rettangolo)o; //ok compile, no exe dipende se e' stato istanziato come new rettangolo (nei 90% dei casi con object non esegue)
		r=(Rettangolo)q; //ok compile,ok exe, cast inutile - e' come scrivere -> r=q
		f=(Frazione) o;//ok complie, no exe
		o=(Frazione)f; //ok compile, ok exe, cast inutile
		/****************************************/
		//A sinistra sempre il supertipo(superclasse) e a destra il sottotipo(sottoclasse)

		Object o = new Quadrato(4);
		String s = o.toString(); // compile object, exe quadrato
		/***************************************/
		Rettangolo r = new Quadrato(3,4); // r viene istanziato come quadrato
		String s = r.toString();	//compile rettangolo, exe quadrato
		/****************************************/
		Rettangolo r = new Rettangolo(2,2); //anche se la base e altezza sono uguali è un rettangolo 
		String s = r.toString();	//compile rettangolo, exe rettangolo
		/****************************************/
		Rettangolo r = new Quadrato(3); 
		Quadrato q =(Quadrato) r; // si può fare il cast perche' r viene istanziata come quadrato
		String s = q.toString();	//compile quadrato, exe quadrato
		/****************************************/
		Rettangolo r = new Rettangolo(3,2); 
		Quadrato q =(Quadrato) r;	//errore cast -> non si può fare il cast a una superclasse
		String s = q.toString();	//compile quadrato, exe errore		
		
		/****************************************/
		Object o = new Frazione(31,2); 
		Quadrato q =(Quadrato) o;
		String s = q.toString();	//compile quadrato, exe errore		
		/*******************************************************************************/
		
		
		
		
		
	}

}
