package javacourse;
//import prog.utili.Data;
import prog.utili.MeseDellAnno;
import prog.utili.*;

public class JavaCourse {

	public static void main(String[] args) {
		
		//definire la data di oggi
		Data oggi= new Data ();	
		
		//calcolare i giorni mancanti alla fine del mese
		//MeseDellAnno mese = MeseDellAnno.getMese(oggi);
		//oppure
		MeseDellAnno mese= oggi.getMeseDellAnno();
		int giorniMese = mese.numeroGiorni(oggi.getAnno()); //giorni del mese corrente
		int giorniMancantiMese = giorniMese - oggi.getGiorno();
		
		//calcolare i giorni mancanti alla fine dell'anno
		//boolean bisetileAnno=oggi.isInAnnoBisestile();
		//int giorniMancantiAnno = giorniMancantiMese  ;
		
		/*Primo metodo, usando il metodo quantoManca() 
		Data fineanno = new Data (31,12,oggi.getAnno());
		int giorniMancantiAnno = oggi.quantoManca(fineanno);*/
	
		/*Secondo metodo */
		int giorniMancantiAnno = giorniMancantiMese  ;
		
		if(mese!= MeseDellAnno.DICEMBRE)
		switch(mese.successivo()) { //Prendo come selettore il mese successivo
			case GENNAIO: giorniMancantiAnno+=31; //TMACH: To make compiler happy - con questo case per forza si mette l'IF
			case FEBBRAIO:
				giorniMancantiAnno+=oggi.isInAnnoBisestile()? 29 : 28; //operatore ternario-> () ? x1: x2 -> x1= true e x2= false
			case MARZO: giorniMancantiAnno+=31;
			case APRILE: giorniMancantiAnno+=30;
			case MAGGIO: giorniMancantiAnno+=31;
			case GIUGNO: giorniMancantiAnno+=30;
			case LUGLIO: giorniMancantiAnno+=31;
			case AGOSTO: giorniMancantiAnno+=31;
			case SETTEMBRE: giorniMancantiAnno+=31;
			case OTTOBRE: giorniMancantiAnno+=31;
			case NOVEMBRE: giorniMancantiAnno+=30;
			case DICEMBRE: giorniMancantiAnno+=31;			
			
		}
		
		
		
		
		
		
		
		
		System.out.println("Giorni mancanti alla fine del mese: " +giorniMancantiMese);
		System.out.println("Giorni mancanti alla fine dell'anno :"+ giorniMancantiAnno );
		
		
		
		
		
		
	}

}
