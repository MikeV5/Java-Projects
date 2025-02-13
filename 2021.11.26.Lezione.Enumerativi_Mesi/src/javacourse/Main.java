package javacourse;

public class Main {

	public static void main(String[] args) {

		
		MeseDellAnno[] a = MeseDellAnno.values();
		MeseDellAnno mda = MeseDellAnno.DICEMBRE;	
		MeseDellAnno mds = MeseDellAnno.GENNAIO;
		
		for(MeseDellAnno m: a) // Dichiarare nel for(tipo che voglio: gli passo l'array che voglio scorrere)
			System.out.println(m.ordinal()+1+" "+m.name()); //ordinal(). posizione nell'array
		
		System.out.println("*****************");
		System.out.println(mda.successivo());
		System.out.println(mda.precedente());
		System.out.println("*****************");
		System.out.println(mds.successivo());
		System.out.println(mds.precedente());
		/*********************************************************************************/
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
