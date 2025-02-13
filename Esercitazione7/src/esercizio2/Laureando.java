package esercizio2;

import java.util.Objects;

public class Laureando {

	String nome;
	int matricola;
	Tesi tesi;
	Docente relatore;
	Docente correlatore;
	
	@Override
	public int hashCode() {
		return Objects.hash(correlatore, matricola, nome, relatore, tesi);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laureando other = (Laureando) obj;
		return Objects.equals(correlatore, other.correlatore) && matricola == other.matricola
				&& Objects.equals(nome, other.nome) && Objects.equals(relatore, other.relatore)
				&& Objects.equals(tesi, other.tesi);
	}	
	
	
}
