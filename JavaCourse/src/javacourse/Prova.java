package javacourse;

public class Prova {

	public static void main(String[] args) {
		/*ESEMPIO 1
		for(int i='a'; i <='z';i+=2) { //i=i+2
			System.out.println((char)i); //per stampare il carattere bisongna fare il cast (char) i
										
		}	
		*/
		/*ESEMPIO 2
		int n=3, m=2;
		int cont=1;
		
		//eseguita (n+1)*(m+1) volte
		for(int i=0; i <=n;i++) {
			System.out.println("i= "+i);
			for(int j=0; j <=m;j++) {
				System.out.println("cont=" +cont++ +", j="+j); 
			}
		
		}
		*/
		/*ESEMPIO 3
		int cont=1;
		//eseguita 26*26 volte
		for(char c='A'; c <='Z';c++) {
			for(char j='z'; j>='a';j--) { 
			System.out.println(c+" "+j+" cont="+cont++); 
			}							
		}	
		*/
		/*ESEMPIO 4
		int n=5;
		int cont=1;
		//eseguito (1+2+...+n) volte
		for(int i=1; i <=n;i++) {
			System.out.println("i="+i);
			for(int j=1; j<=i;j++) { 
			System.out.println("cont="+cont++ +" j= "+j); 
			}							
		}	
		*/
		char c='A';
		switch(c) {
			case 'A':		
			case 'C':	
				System.out.println("AAA");
			case 'D':
			case 'W':
				System.out.println("EEE");
			default:
				System.out.println("ddd");
			case 'H':
				break;  //La stampa va in cascata fino al break
		
		}
		
		
		
		
		
		

	}

}



















