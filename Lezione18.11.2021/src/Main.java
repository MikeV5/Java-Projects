
public class Main {

	public static void main(String[] args) {
		/************** THIS - SUPER *************************/
		//super(): invoca il costruttore della superclasse nella sottoclasse
		//this o super: sempre la prima istruzione del costruttore
		//Nel costruttore se non viene dichiarato super() viene inserito in maniera impiclita(automatico)
		//es. la FrazioneCustom che ha due costruttori chiama il costruttore della superclasse(Object) -> super()
		//Il quel caso non gli passa niente perché il costruttore di object è vuoto
		//Se per es. se si creasse un costruttore della classe quadrato vuoto darebbe errore perché il Rettangolo non ha un costruttore vuoto
		
		/**************** OVERLOADING ************************/
		//Metodo e costruttori con lo stesso nome ma segnatura dviersa
		//Segnatura: nome del metodo e lista dei tipi dei suoi argomenti
		
		/********************           *********************/
		//Compilazione: Come dichiaro la variabile
		//Esecuzione-> JVM -> risale nella gerarchia 
		//A alfa= new C() -> in compilazione da' errore ma non in esecuzione
		//alfa.assegna(3L);
		//In compilazione: segnatura selezzionata-> assegna(long x) della classe A
		//Ma in fase di esecuzione ma a chimare quella della C, non trovando il tipo risale fino ad A 
		//ese. se in fase assegnatura(compilazione) passasse un intero 
		//In fase della compilazione non guarderebbe neanche il new C (istanza dell'oggetto)
		
		
		
		
		/******************** OVERRIDING ***********************************/
		//Riscrivere un metodo con la stessa segnatura (della superclasse nella sottoclasse)
		
		
		/************************************************************************************************/
		Rettangolo r = new Rettangolo(2,3);
		Quadrato q = new Quadrato(5);
		
		System.out.println(r.toString());
		System.out.println(q.toString());
		System.out.println(q.getDescrizione1());
		System.out.println(q.getDescrizione2());
		
		
		/************************ CLASSE ASTRATTA ****************************************************/
		//Basta un metodo e verrà definita come classe astratta
		//No può essere istanziata, ma può essere estesa
		//Si scrive in corsivo(italiaco) oppure un * asterisco affianco
		
		/********************************************************************/
		//Figura f = new Figura(); // una classe astratta non ha il cosrtuttore
		Figura f1= new Rettangolo(2,3); //OK
		Figura f2= new Quadrato(5);
		
		//System.out.println(f1.getDescrizione1());
		//	System.out.println(f2.getDescrizione2());
		//In compilazione controlla se la classe figura ha questi metodi
		//in esecuzione va bene, ma se non compila non esegue
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
