package javaCourse;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrarioCustom {

	// CAMPI
	private int ore, min;
	// CAMPI STATICI
	private static char sep = ':';
	private static boolean formato24 = true;

	// COSTRUTTORI
	public OrarioCustom(int hh, int mm) {
		this.ore = hh;
		this.min = mm;
	}

	public OrarioCustom() {
		GregorianCalendar adesso = new GregorianCalendar();
		ore = adesso.get(Calendar.HOUR_OF_DAY);
		min = adesso.get(Calendar.MINUTE);
	}

	public OrarioCustom(String s) { // formato hh:mm
		ore = Integer.parseInt(s.substring(0, 2));
		min = Integer.parseInt(s.substring(3, 5));

	}

	// METODI
	public int getOre() {
		return this.ore;

	}

	public int getMinuti() {
		return this.min;
	}

	public int quantoManca(OrarioCustom altro) {

		// int minTraLeOre = (altro.ore - this.ore) * 60;
		// int minTraGliOrario = altro.min - this.min;
		// int ris = minTraLeOre + minTraGliOrario;
		// return ris;
		return (altro.ore - this.ore) * 60 + (altro.min - this.min);

	}

	public boolean isMinore(OrarioCustom altro) {
		/*
		 * if (this.ore < altro.ore || (this.ore == altro.ore && this.min < altro.min))
		 * return true; else return false;
		 */
		return (this.ore < altro.ore || (this.ore == altro.ore && this.min < altro.min));
	}

	public boolean isMaggiore(OrarioCustom altro) {
		return (this.ore > altro.ore || (this.ore == altro.ore && this.min > altro.min));
	}

	public boolean equals(OrarioCustom altro) {
		return this.ore == altro.ore && this.min == altro.min;
		// return this.getOre()==altro.getOre();
	}

	@Override
	public String toString() {
		String tmp = (min < 10) ? "0" : "";
		if (formato24)
			return String.valueOf(ore) + sep + tmp + min;
		else {
			int oraRisultato;
			String suff;
			if (ore == 0) {
				oraRisultato = 12;
				suff = "am";
			} else if (ore > 0 && ore < 12) {
				oraRisultato = ore;
				suff = "am";
			} else if (ore == 12) {
				oraRisultato = 12;
				suff = "pm";
			}else {
				oraRisultato=ore-12;
				suff="pm";

			}
			return String.valueOf(oraRisultato) + sep + tmp + min+" "+suff;

		}

	}
	// METODI STATICI

	public static void setSeparatore(char ch) {
		sep = ch;
	}

	public static void setFormato24(boolean b) {
		formato24 = b;
	}

	public static boolean isFormato24Attivo() {
		return formato24;
	}

}
