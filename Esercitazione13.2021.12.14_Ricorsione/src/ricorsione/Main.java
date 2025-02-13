package ricorsione;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Appartamento app1 = new Appartamento(1000,20);
		UnitaAbitativa app2 = new Appartamento(1000,20);
		ArrayList<UnitaAbitativa> lista1 = new ArrayList<UnitaAbitativa>();
		lista1.add(app1);
		lista1.add(app2);
		Condominio c1 = new Condominio(0,0,lista1);
		System.out.println(c1.toString());
		
		ArrayList<UnitaAbitativa> lista2 = new ArrayList<UnitaAbitativa>();
		lista2.add(c1);
		lista2.add(new Appartamento(2000,40));
		Condominio superC = new Condominio(0,0,lista2);
		
		System.out.println(superC.toString());
		
	}

}
