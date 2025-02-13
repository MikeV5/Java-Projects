package javaCourse;

public class ProvaOrario {

	public static void main(String[] args) {
		
		OrarioCustom o1 = new OrarioCustom(11,50);//costruttore 1
		OrarioCustom o2 = new OrarioCustom();//costruttore 2
		OrarioCustom o3 = new OrarioCustom("12:04");//costruttore 3
		
		//OrarioCustom.setSeparatore('-');
		OrarioCustom.setFormato24(false);
		System.out.println(o1.toString());
		System.out.println(o2.toString());
		System.out.println(o3.toString());
/*
		System.out.println("Ore attuali: "+ o2.getOre());
		System.out.println("Minuti attuali: "+ o2.getMinuti());
		
		System.out.println(o1.equals(o2));
		System.out.println(o1.isMinore(o3));
		System.out.println(o1.isMaggiore(o3));
		
		System.out.println(o1.quantoManca(o3));
		System.out.println(o3.quantoManca(o1));
*/
	
	
	
	}

}
