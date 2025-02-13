package prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import prog.utili.Figura;
import prog.utili.Rettangolo;

public class Main2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		/*
		 * Prova2 p1 = new Prova2(); System.out.println(Prova2.k); p1.setK(6);
		 * System.out.println(Prova2.k); System.out.println(p1.k);
		 * 
		 * Prova2 p2= new Prova2(); System.out.println(Prova2.k);
		 * System.out.println(p2.k);
		 * 
		 * 
		 * Giorno g = Giorno.MARTEDI; System.out.println(g.name());
		 * System.out.println(g.ordinal()); System.out.println(g.toString());
		 * 
		 * 
		 * ArrayList<String> al = new ArrayList<String>(); al.add("primoelemento");
		 * al.add("secondoelemento"); System.out.println(al.add("primoelemento"));
		 * 
		 * 
		 * for(String tmp:al) System.out.println(tmp);
		 * 
		 * /
		 *****************************************************************/
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Inserisci un numero: "); String tmp = sc.nextLine();
		 * double d= Double.parseDouble(tmp); System.out.println(d); /
		 *****************************************************************/
		/*
		 * InputStreamReader in = new InputStreamReader(System.in); BufferedReader br =
		 * new BufferedReader(in); System.out.println("Inserisci un numero: "); double d
		 * = Double.parseDouble(br.readLine()); System.out.println(d); /
		 *****************************************************************/
		/*
		 * ArrayList<Integer> ar = new ArrayList<Integer>(); ar.add(1); ar.add(2);
		 * ar.add(3); ar.add(4); System.out.println(ar.get(0)); for(Integer tmp:ar)
		 * System.out.println(tmp);
		 * 
		 * String s1 = "guida"; // length: 5 caratteri - g: pos 0 - a: pos 4 String s2 =
		 * s1.substring(3); // Dalla pos 1 alla 2(3-1) output: ui
		 * System.out.println(s2);
		 */

		/*****************************************************************/
		/*
		 * int x=2; int y=1; int z= x++ * --x; System.out.println("x: "+x+" y: "+z);
		 * boolean b='a'>'o'; System.out.println(b);
		 */
		/*****************************************************************/
		/*
		 * String s= "ciao"; int i=4,y=9; System.out.println(i+y+" la somma");
		 */
		/*****************************************************************/
		/*
		 * double[] x= {1.2,1.3,1.4}; boolean b = x[0]>3.0; System.out.println(b);
		 */
		/*****************************************************************/
		/*
		 * int z = 5; double[] x = {1.6,2.6,3.8}; x[0] = 3.0 * z;
		 * System.out.println(x[0]);
		 * 
		 * char c='d'; char d=c++; System.out.println(d);
		 * 
		 */

		/*****************************************************************/
		/*
		 * double[] x= {1.2,1.3,1.4}; boolean b = x[0]==1; System.out.println(b);
		 */
		/*
		Figura[] a= {new Rettangolo(2,3)}; 
		int x = 1;
		double y = 0.0;
		try {
			for (int i = 0; i < a.length; i++)
				if (a[i] instanceof Rettangolo) {
					x++;
					Rettangolo t = (Rettangolo) a[i];
					y = y + t.getBase();
				}
			x = x / (x - 1);
			y = y + a[1].getPerimetro();
			
		} catch (ArrayIndexOutOfBoundsException e) {
			x = x + 2;
		} catch (ArithmeticException e) {
			x = x + 3;
		} catch (NullPointerException e) {
			x = x + 4;
		}
		System.out.println("x: "+x+" y: "+y);
		
			int k = -3;
		for ( int i = 0; i <= 1; i++ ) {
			if (! (i % 2 == 1) ) {
					for ( int j = 0; j <= i; j++, k = k + j ) {
							k =k- i;
					}
			}else {
				k += i;
			}
		}
		
		/*****************************************************************/
		/*
		int k = -3;
		int i = 2;
		int j;
		for (  j = 0; j <= i; k = k + j,j++ ) {
				
				k =k- i;
				System.out.println(j);
				System.out.println(k);
				
		}
		
		
		
		System.out.println();
		System.out.println(j);
		System.out.println(k);
		*/
		
		int k = -3;
		int j,i;
		for (  i = 0; i <= 5; i++ ) {
			if (! (i % 2 == 1) ) {
					for (  j = 0; j <= i; j++, k = k + j ) {
							k =k- i;
							System.out.println(j);
							System.out.println(k);
					}
			}else {
				k += i;
				System.out.println("else: " +k);
				
			}
		}
		
		System.out.println(/********/);
		System.out.println(i);
		System.out.println(k);
		
		double z=4.0;
		double x =(int)z;
		
		
		System.out.println("guido".substring(2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*****************************************************************/

	}

}
