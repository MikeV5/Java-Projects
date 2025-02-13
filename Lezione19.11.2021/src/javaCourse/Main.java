package javaCourse;

public class Main {

	public static void main(String[] args) {
		//ADOMBRAMENTO: i parametri formali adombrano le variabile di una classe all'interno di un costruttore
		//se non si specifica this.variabile
		//Di default la visibilita' è protected, non public
		//public Rettangolo(double base){base=base;}-> caso di adombramento
		
		/******************************************************/
		Rettangolo r = new Rettangolo(2,3);
		Quadrato q = new Quadrato(5);
		//Si verifica un'errore logico in quanto il quadrato ha lati diversi
		//Soluzione: overriding del metodo rettangolo nella sottoclasse quadrato
		r.setBase(5.0);	
		q.setAltezza(3.0);
		/**************************************************/
		//eccezione stackOverFlow: Superare lo spazio disponibile all'interno dello stack
		//
		
	/******************************************************/	
	//Visibilita' protected: nelle sottoclassi e in tutte le classi  che appartengono allo stesso package
	//Se due classi sono in packge diversi, sarebbe visibile solo se la sottoclasse estende la superclasse e tramite super.
		//private: Visibile solo nella stessa classe
	//public: Visibile fuori dalla classe
	/****************************************************************************/
	//Specificare il percorso se c'è ambiguità
		//es. 
		import Rettangolo;
		import jprog.utili.Rettangolo
		Rettangolo r; //in questo caso java non saprebbe a chi chiamare
		//soluzione-> specififare tutto il percorso
		figure.Rettangolo r1;
		prog.utili.Rettangolo r2
		/***************************************************************************/
		//FINAL
		//Il modificatore final, non può essere  redifinito e si scrive in maiuscolo
		//E' una variabile "costante", non può essere modificata
		
		//Non si può comodificare il riferimento all'oggetto, ma si l'oggetto
		//es. final Rettangolo RETTANGOLO = new Rettangolo(4,5)
		//si può modificare con un metodo della classe -> RETTANGOLO.setBase(5);
	/*************************************** FINAL *************************************/
	//FINAL COME PARAMETRO FORMALE
		//Impedisce modificare il valore del paramatro formale
		public void f(final int X) {
			X=4; //errore!
		}
	// final nelle classi -> public final Rettangolo non può essere estesa
		//Domande esame
	//Cosa succede con il final per le classi, metodi, variabili locali, formali
	//Descrivere i modificatore di visibilta'
	/******************************** STATIC ***************************************/	
		//STATIC MODIFICATORE
		//Obbliga a inizializzare la variabile -
		//-> static final int PROVA= 5 -> senza static si può non inizialzzare in fase di inizial.
		//Il campo static di una classe -> sarà sempre la stessa ogni volta si venga creato un oggetto
		/******************************  *******************************************/
	//extends Exception-> gestisce le eccezioni controllate
		//se un metodo in overriding di una superclasse gestisce un'eccezione il medessimo metodo della sottoclasse
		//deve gestire quell'eccezione (throws esempioException)
		
		//******************************************************************************/
		//ESERCIZI ESAME
		//Guardare il file su e-learning
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
