package javaCourse;

import prog.utili.Frazione;

public class Main {

	public static void main(String[] args) {
		//blocco finally:Il codice del blocco verrà eseguito comunque, si verifichi o no l'eccezione
		//Domanda di esame:eccezione controllate e non controllate
		//Controllate: Estendono la classe(Non sono istanze del RuntimeException) estendono Exception
		//NonControllate:Sono istanze del RuntimeException - Estendono RunTimeException
		//controllate: Il compilatore verifica  che l'eccezione sia gestita
		//throws, parola chiave iscritta nell'intestazione del main o metodo chiamante (throws Exception-> controllate ma si dovrà
		//aggiungere anche in tutti i metodi in relazione) - (throws ArithmeticException -non controllata)
		//non controllata: il compilatore non interviene
		
		/**********************************************************/
		//es1.
		//Esempio esercizio domanda di esame 2020
		Frazione f1= new Frazione(3,4);
		Frazione f2 = f1;
		Frazione f3 = new Frazione(3,4);
		
		//Qual è il valore dell'espressione f1==f2? //true alla frazione f2 è stata assegnata il riferimento di f1
		//Qual è il valore dell'espressione f2==f3?  //false - Sono le stesse frazioni ma non puntano lo stesso oggetto
		//Qual è il valore dell'espressione f1.equals(f3)?// true - l'equals confronta gli oggetti
		/*************************************************************/
		//es2.
		
		int x=-;//x=-10 - es. di x e y che non termina(x=-2 y =2)
		int y=+;//y=0
		do {
			x=x+2; //x=-8, x= -6 //x=0 , x=4
			y=y+3; //y=3 , y=6  //y=5
			if(x==-y)
				x=y;		//se sono uguali il ciclo termina
		}while(x !=y);
		System.out.println("x= "+x+" y="+y);
		/*****************************************************************/
		//es3.
		int k= -3;
		int i,j=0
		for(int i=0; i <=5; i++) {//i=0, 1 ,2 ,3 ,4 ,5 -> esce al 6 (stampato alla fine i=6)
			if(!(i%2==1)) { //vero se i è pari
				for(j=0; j <=i; j++, k =k+j)
					k-=i;
				System.out.println("Step2:k="+k+"i="+i+"j="+j)
			}else {
				k+=i;
				System.out.println("Step3:k="+k+"i="+i+"j="+j)
			}
			System.out.println("Step4:k="+k+"i="+i+"j="+j)
		}
		System.out.println("k="+k+"i="+i+"j="+j)
		/********************************************************************/
		//es4.
		String s1= new String("java");
		String s2= new String("java");
		String s3= s1;
		
		//!(s1==s3)   //!(true)-> false
		//s2==s1 - false - Non puntano lo stesso oggetto(false di base nell'esame) ma nelle nuove versioni è true) 
		//s2.equals(s1) true
		//(s3.equals(s1) || s2==s1) -> (true || )
		/*************************************************************************/
		//es5.
		int x= 1;
		int y =x++; //y=1, x=2
		
		boolean b = ((--x -y) <= (x=++y*x) && (y++ <= ++x);
				      //(1-1) <= (x=2*1) = 0 <= 2 true x=2, y=2
					//&& 2 <= 3 true x=3, y=3
		boolean b = (y % 2 > --x) | !(++x >= y++); //
					//(1>1)			| !(2>=1) //false | false
					//x=1 -> x=2, y=2
		/**************************************************************************/
		//es6.
		int x=2;
		int y=3;
		
		int[] A = {x++, y}; //int A[2]-> dimesione 2 x=3, y=3
		y= (A[x-y]) > 0 ? ++y : y++);	//A[0]=2 -> (2> 0) true -> ++y-> x=3, y=4
		y= (A[x-y]) < 0 ? ++y : y++); //false quindi y++ -> y=3 e il ++ non viene considerato
		
		//Operazione condizionale in java = operatore ternario
		/*****************************************************************************/
		//es7.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
