package esercitazione3;

import java.util.*;

public class gioco {

public static void main(String[] args) {
		
		Mosse m1, m2;
		Random mr=new Random();
		//Genero random mossa g1
		m1=Mosse.values()[mr.nextInt(5)];
		System.out.println("Mossa giocatore 1 "+m1);
		
		
		//Genero random mossa g2
		m2=Mosse.values()[mr.nextInt(5)];
		System.out.println("Mossa giocatore 2 "+m2);
		
		//confronto le mosse e decido chi vince
		switch(m1) {
		
		//CARTA
			case CARTA:
				
			switch(m2) {
					case CARTA:
						System.out.println("parita");
						break;
					case FORBICI:
					case LIZARD:
						System.out.println("vince g2");
						break;
					case SASSO:
					case SPOCK:
						System.out.println("vince g1");
						break;
				}
				
				break;
		//FORBICI		
			case FORBICI:
				switch(m2) {
							
				case FORBICI:
					System.out.println("parita");
					break;
				case CARTA:
				case LIZARD:
					System.out.println("vince g1");
					break;
				case SASSO:
				case SPOCK:
					System.out.println("vince g2");
					break;
					
			}
				break;
		//LIZARD		
			case LIZARD:
				
				switch(m2) {
				case CARTA:
					System.out.println("vince g2");
					break;
				case FORBICI:
					System.out.println("vince g2");
					break;
				case LIZARD:
					System.out.println("vince g2");
					break;
				case SASSO:
				case SPOCK:
					System.out.println("vince g1");
					break;
			}
				
				break;
		//SASSO		
			case SASSO:
				
				switch(m2) {
				case CARTA:
					System.out.println("parita");
					break;
				case FORBICI:
				case LIZARD:
					System.out.println("vince g2");
					break;
				case SASSO:
				case SPOCK:
					System.out.println("vince g1");
					break;
			}
				
				break;
		//SPOCK		
			case SPOCK:
				
				switch(m2) {
				case CARTA:
					System.out.println("parita");
					break;
				case FORBICI:
				case LIZARD:
					System.out.println("vince g2");
					break;
				case SASSO:
				case SPOCK:
					System.out.println("vince g1");
					break;
			}
				
				break;
			default:
				break;
				
			
				
				
			
		
			
		
		}
		
		
		
		
		
		
	}
	
	
}
