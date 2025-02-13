package esercizio1;

public class A {
	public int x; 
	public int y=1; //Y con valore di default
	
	public A(int x, int y) throws InputException{
		if(x<=0)		//Si lancia un'eccezione(una generica (Exception) o crearne una specifica(in questo caso è una non controllata))
			//Un'eccezione all'interno di un metodo si aggiunge una clausula "throws" al metodo
			//Se mettiamo un'eccezione throw dobbiamo o aggiungere "throws" al metodo o gestirla con un "try catch" (in questo esempio usiamo throws)
			throw new InputException("x sbagliato"); //Caso di eccezione specifica(l'ho creata io)		
		else this.x=x;
		
		if(y>0)	//se minore di 0 "y" prende il valore che gli passiamo, altrimenti rimane con il suo valore di default
			this.y=y;
		
	}
	/**********************************************************************
	– Lancia l’eccezione creata prima se l’input è null
	– Gestisce internamente il fatto che input.x > 10 ponendolo a 10
	– Lancia una generica eccezione se input.y>10
	************************************************************************/
	
	public void m1(A input) throws InputException, Exception{ //Bastava fare throws Exception dato che InputException è una sua sottoclasse
		if(input == null) throw new InputException("input null");
		//Non ha tanto senso cattura l'eccezione(con throw) e poi gestira subito (con catch)
		try {
			if(input.x>10)   throw new Exception();
			
		}catch(Exception e) {
			input.x=10;
		}
		if(input.y>10) throw new Exception(); //o la gestiamo con try catch o si aggiunge al chiamante m1() throws Exception
		
		
	//Non c'entra con l'esercizio - esempio di caso in cui non si cattura l'eccezione direttamente	
		try {
			input.m2(); // senza catturare l'eccezione
			
		}catch(Exception e) {
			input.x=10;
			
		}
		
		
		
		
	}
	
/***************************************************
 * throws: vuol dire che quel metodo può lanciare un'eccezione 	
 * @throws Exception
 */
	public void m2() throws Exception{
		 throw new Exception();
	}
	

	
	
	
	
	
	
	
	
	
	
}
