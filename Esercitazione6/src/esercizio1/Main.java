package esercizio1;

public class Main {

	public static void main(String[] args) {

		Dipendente dp1 = new Dipendente("Mario", 1547, 200);
		System.out.println(dp1.toString());
		System.out.println(dp1.calcoloRal());
		
		Dipendente dp2 = new Dipendente();
		System.out.println(dp2.toString());
		
		Dipendente dp3 = new Dipendente("Fede",15);
		System.out.println(dp3.toString());
		
		Dipendente dp4 = new Dipendente("Mario",15);
		System.out.println(dp3.toString());
		
		
		System.out.println(dp3.equals(dp4));
		
		Libreria mobile=new Libreria("PrimoLibro");
		System.out.println(mobile.toString());
		
	}

}
