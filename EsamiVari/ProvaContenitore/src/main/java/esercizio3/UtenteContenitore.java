package esercizio3;

import esercizio1.Contenitore;

import java.util.Random;

public class UtenteContenitore extends Thread{

    private int id;
    private Contenitore contenitore;

    public UtenteContenitore(int id, Contenitore contenitore) {
        this.id = id;
        this.contenitore = contenitore;
    }

    public void run(){
        Random r = new Random();
        int val;
        //double prob;
        int scelta;
        try {
            for (int i = 0; i < 10; i++) {
                //prob = r.nextDouble(1); //tra 0 fino a 0.999
                scelta = r.nextInt(3);

                switch (scelta){
                    case 0:
                        val = r.nextInt(10)+1; //Tra 0 e 9.999(è un 9 (int)) --> 1 e 10
                        contenitore.inserisci(val);
                        System.out.println("Utente: "+id+" - Numero inserito: "+ val);
                        break;
                    case 1:
                        int somma = contenitore.somma();
                        System.out.println("Utente: "+id+" - Somma: "+ somma);
                        break;
                    case 2:
                        contenitore.cancella();
                        System.out.println("Utente: "+id+" - Svuota il contenitore");
                        break;
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
