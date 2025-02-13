package JavaCourse;

import java.util.Scanner;

import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Figure {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// leggere una sequenza di rettangoli/quadrati
		System.out.print("Base> ");
		int base = sc.nextInt();
		System.out.print("Altezza> ");
		int altezza = sc.nextInt();

		Rettangolo areaMaggiore = null;
		Rettangolo perimetroMaggiore = null;
		Rettangolo tmp = null;

		while (base > 0 && altezza > 0) {

			if (base == altezza)
				tmp = new Quadrato(base);// quadrato
			else
				tmp = new Rettangolo(base, altezza); // rettangolo
			if (areaMaggiore == null || tmp.haAreaMaggiore(areaMaggiore))
				areaMaggiore = tmp;

			if (perimetroMaggiore == null || tmp.haPerimetroMaggiore(perimetroMaggiore))
				perimetroMaggiore = tmp;

			// leggere una sequenza di rettangoli/quadrati
			System.out.print("Base> ");
			base = sc.nextInt();
			System.out.print("Altezza> ");
			altezza = sc.nextInt();
		}
		sc.close();
		System.out.println("Figura area maggiore> " + areaMaggiore.toString());
		System.out.println("Figura perimetro maggiore" + perimetroMaggiore.toString());
		/*********************************/
		// Instanceof (04/11/2021)
		if (areaMaggiore instanceof Quadrato) {
			System.out.println("Figura area maggiore è un qudrato> " + areaMaggiore.toString());
			System.out.println("Figura perimetro maggiore è un qudrato" + perimetroMaggiore.toString());
		}else {
			System.out.println("Figura area maggiore è un rettangolo> "+areaMaggiore.toString());
			System.out.println("Figura perimetro maggiore è un rettangolo"+perimetroMaggiore.toString());
		}

		/***********************************/

		// determinare quello con area e perimetro maggiore

	}

}
