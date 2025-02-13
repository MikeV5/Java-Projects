package javacourse;
import prog.utili.*;
import java.util.Scanner;

public class JavaCourse3 {

	public static void main(String[] args) { //
/*		
		//inserire un certo numero di frazioni in un array
		System.out.println("Quante frazioni vuoi inserire? ");
		
		Scanner sc = new Scanner(System.in);
		
		final int NUM_FRAZIONI = sc.nextInt(); //final -> non fa modificare il valore della variabile
*/
		//Passare l'argomento può creare degli errori -> non passare l'argomento o che sia una stringa
		Scanner sc = new Scanner(System.in);
		final int NUM_FRAZIONI = Integer.parseInt(args[0]); //main.java -> run as -> run configuration - >arguments
		if(args.length==0) {//controllo se non si passa un argomento
			System.err.println("Info mancante"); 
			sc.close();
			return;		
		}
		
		//Controllo sull'input
		if(NUM_FRAZIONI <=0) {
			System.err.println("Dimensione array non valida!"); //
			sc.close();
			return; //Porta fuori dal main
		}
		
		//Inizzializare la frazione
		Frazione[] frazioni = new Frazione[NUM_FRAZIONI];
		int num,den;
		
		for(int i=0; i<NUM_FRAZIONI;i++) {
			
			System.out.println("Numeratore frazione "+ (i+1) +">");
			num=sc.nextInt();
			System.out.println("Denominatore frazione "+ (i+1)+">");
			den = sc.nextInt();
			/*metodo 1
			Frazione tmp = new Frazione(num,den); 	//frazione temporanea
			frazioni[i]= tmp;*/
			frazioni[i]= new Frazione(num,den);
		
		}
		//per scorrere l'array usare il for each
		for(Frazione tmp: frazioni)
			System.out.println(tmp+" ");
		sc.close();
	}
}




