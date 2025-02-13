package esercizio2;

public class Main {

	public static void main(String[] args) {
		UtenteBiblioteca ubiblio1 = new UtenteBiblioteca("Federico", 100);
		Libro l1= new Libro("titolo1",40,false);
		Libro l2= new Libro("titolo2",50,true);// Se il numero di pagine è maggiore di 100 non posso prende in prestito un altro libro
		Libro l3= new Libro("titolo3",30,false);  //in questo caso (40+50)=90, al massimo il prossimo libro deve avere 10 pag	
		Libro l4= new Libro("titolo3",61,true);
		Libro l5= new Libro("titolo3",31,false);
		/*
		ubiblio1.prendiInPrestito(l1);
		ubiblio1.prendiInPrestito(l2);
		ubiblio1.prendiInPrestito(l3);
		*/
		//System.out.println(ubiblio1.toString());
		
		UtenteAbbonato uabbon1= new UtenteAbbonato("Federico", 100,8);
		uabbon1.prendiInPrestito(l1);
		uabbon1.prendiInPrestito(l2);
		uabbon1.prendiInPrestito(l3);
		uabbon1.prendiInPrestito(l4);
		uabbon1.prendiInPrestito(l5);
		System.out.println(uabbon1.toString());
		System.out.println(uabbon1.pagNonNarrative());

	}

}
