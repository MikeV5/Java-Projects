package esercizio4;

public class Treno {
	public static void main(String[] args) {

		// Testa del treno(vagone di prima classe)

		Vagone testa = new Vagone();
		testa.classe = 1; // Prima classe

		/************************************************************
		 * Create un nuovo vagone di prima classe e aggiungetelo in coda
		 */
		Vagone v1 = new Vagone();
		v1.classe = 1;
		testa.next = v1;

		/************************************************************
		 * Aggiungete 2 nuovi vagoni di seconda classe in coda, senza salvarli nel main
		 * (ovvero senza fare Vagone ... )
		 */
		v1.next = new Vagone();
		v1.next.classe = 2; // Vagone di seconda classe

		v1.next.next = new Vagone();
		v1.next.next.classe = 2; // Vagone di seconda classe

		/************************************************************
		 * Scorrete il treno e stampate la classe di ciascuna vagone
		 */
		
		Vagone tmp = testa;
		int cont=1;
		while(tmp != null) {			
			System.out.println("Vagone " +cont+ " : "+tmp.classe+" ");		
			tmp=tmp.next;
			cont++;
		}
		
		/************************************************************
		 * Aggiungete un vagone di seconda classe in testa al treno
		 */
		
		Vagone vagSec= new Vagone();
		vagSec.classe=2;
		
		vagSec.next=testa; //Il vagone di seconda classe punta al vagone di 1 classe che prima era la testa
		testa=vagSec; // Il primo vagone diventa quello di seconda classe e il secondo è quello di prima(testa)
		
		
		tmp = testa;
		cont=1;
		while(tmp != null) {			
			System.out.println("Vagone " +cont+ " : "+tmp.classe+" ");		
			tmp=tmp.next;
			cont++;
		}
		
		
		
		
		
		

	}

}
