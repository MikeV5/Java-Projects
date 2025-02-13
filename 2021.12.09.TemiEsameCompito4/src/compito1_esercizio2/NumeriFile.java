package compito1_esercizio2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Scrivere un programma che riceva in input da tastiera due numeri in virgola mobile e li stampi su file in ordine crescente.
*/

public class NumeriFile {

	public static void main(String[] args) throws NumberFormatException, IOException {

		System.out.println("Inserire due numeri > ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Buffer che inseriremmo nel file
		//Il bufffer viene caricato con il valore numerico di a anche se fosse int viene castato a double
		double a = Double.parseDouble(br.readLine()); 
		double b = Double.parseDouble(br.readLine());
		FileWriter fw = new FileWriter("interi.txt");
		if (a > b) {
			fw.write(b + "\n");
			fw.write(a + "\n");
		} else {
			fw.write(a + "\n");
			fw.write(b + "\n");
		}
		fw.flush();
		fw.close();

	}

}
