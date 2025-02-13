package esercizio4;

public class Main {

	public static void main(String[] args) {
/*
		ContoBancario conto1= new ContoBancario();
		conto1.versare(100);
		conto1.versare(500);
		conto1.prelevare(300);
		conto1.prelevare(00);
		conto1.visualizzaSaldo();
	*/	
		int k = 0;
		for (int i = 0; i <= 4; i++)
			if (i % 2 == 1)
				for (int j = 0; j <= i; j++, k = k + j);
			else
		k += i;
		System.out.println(k);

	}

}
