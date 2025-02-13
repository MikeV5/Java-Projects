package javacourse;

import java.util.LinkedList;
import java.util.Scanner;

public class JavaCourse {

	public static void main(String[] args) {

		// Esame: LinkedList<E> e metodi

		Scanner sc = new Scanner(System.in);
		String tmp;
		LinkedList<String> list = new LinkedList<String>(); // Chiama il costruttore
		System.out.println("Dim lista > " + list.size()); // Dimensione della lista

		while(!tmp.equals("")) {
			list.add(tmp);
			System.out.println("Inserire stringa (vuota per uscire) >");
			tmp = sc.nextLine();

		}
		
		/*
		do {
			System.out.println("Inserire stringa (vuota per uscire) >");
			tmp = sc.nextLine();
			list.add(tmp);
		} while (!tmp.equals(""));
		list.removeLast();

		System.out.println("Dim lista > " + list.size()); // Dimensione della lista
		sc.close();
		*/
		
		
		for(String s:list) {
			int i=0;
			System.out.println(s+""); 
			System.out.println(list.get(i)+" ");
			i++;
		}
			
			for(int i=0;i< list.size();i++) 
				System.out.println(list.get(i)+" ");
			
			System.out.println("Lista al contrario");

			for(int i=list.size()-1;i>=0;i--) 
				System.out.println(list.get(i)+" ");	
				
				System.out.println("\nLista free");
				System.out.println(list);

				//vuota
				System.out.println("\nLista vuota");
				System.out.println(list.isEmpty());
				
//				String[] a = (String[])list.toArray() ;NO, non è la soluzione
				Object[] a = list.toArray();
				System.out.println("Array>");
				
				for(Object s:a) {
					String t =(String) s;
					System.out.println(t.toUpperCase()+"");
				}		
					sc.close();
		
		
		
		
		
		
	}

}
