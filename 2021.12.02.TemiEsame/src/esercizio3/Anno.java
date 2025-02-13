package esercizio3;

public class Anno {

	int anno;

	public Anno(int anno) {
		this.anno = anno;
	}

	public TipoAnno isBisestile() {
		boolean div4 = (this.anno % 4) == 0 ? true : false;
		boolean div100 = anno % 100 == 0;
		boolean div400 = anno % 400 == 0;
		
		if((div4 && !div100) || (div400))
			return TipoAnno.BISESTILE;
		else
			return TipoAnno.NONBISESTILE;
			
		
		
	}

}
