package javacourse;

public enum MeseDellAnno {
	// CAMPI
	// COSTANTI ENUMERATIVE
	GENNAIO, FEBBRAIO, MARZO, APRILE, MAGGIO, GIUGNO, LUGLIO, AGOSTO, SETTEMBRE, OTTOBRE, NOVEMBRE, DICEMBRE;

	public MeseDellAnno successivo() {

		return MeseDellAnno.values()[(this.ordinal() + 1) % 12]; // Con %12 quando ordinal89 sarà dicembre(12+1) ->
																	// 13%12 = 1 quindi ritorna a gennaio (1)
		/*
		 * MeseDellAnno[] a = MeseDellAnno.values(); return a[(this.ordinal() + 1) %
		 * 12];
		 */

	}

	public MeseDellAnno precedente() {
		int index = this.ordinal() - 1 < 0 ? 11 : this.ordinal() - 1;
		return MeseDellAnno.values()[index];
	}

	@Override
	public String toString() {
		switch (this) {
		case GENNAIO:
			return "Gennaio";
		case FEBBRAIO:
			return "Febbraio";
		case MARZO:
			return "Marzo";
		case APRILE:
			return "Aprile";
		case MAGGIO:
			return "Maggio";
		case GIUGNO:
			return "Giugno";
		case LUGLIO:
			return "Luglio";
		case AGOSTO:
			return "Agosto";
		case SETTEMBRE:
			return "Settembre";
		case OTTOBRE:
			return "Ottobre";
		case NOVEMBRE:
			return "Novembre";
		case DICEMBRE:
			return "Dicembre";
		default: return "";

		}

	}

}
