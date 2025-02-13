package compito4_esercizio1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import prog.utili.Cerchio;
import prog.utili.Figura;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class EsercizioFigure {

	public static void occorrenzeFigureSuFile(Figura[] figs, String filename) throws IOException, ArrayFigureNonValido {

		if (figs == null)
			throw new ArrayFigureNonValido(); // Eccezione non controllata

		int contCerchio = 0, contRettangolo = 0, contQuadrato = 0;

		for (Figura f : figs) {
			if (f instanceof Cerchio) // Verifica se la figura è istanza di cerchio
				contCerchio++;
			else {
				if (f instanceof Rettangolo && !(f instanceof Quadrato))
					contRettangolo++;
				else if (f instanceof Quadrato)
					contQuadrato++;
			}
		}

		File file = new File(filename);
		FileWriter fw = new FileWriter(file); // Apertura del file

		fw.write("numero cerchi: " + contCerchio);
		fw.write("numero rettangoli: " + contRettangolo);
		fw.write("numero quadrato: " + contQuadrato);
		
		fw.flush(); //forza la scrittura, quando avviene un'eccezione
		fw.close(); //chiusura de file
		

	}

}
