package esercizio2;

import esercizio1.Inesistente;
import java.util.Random;

public class UtenteContenitore extends Thread{

    private int id;
    private Contenitore c;
    public UtenteContenitore(int id, Contenitore c) {
        this.id = id;
        this.c = c;
    }
//IMPLEMENTAZIONE CON PROBABILITA'
    public void run(){

        Random r = new Random();
        double prob;
        String val;
        int posR;
        try {
            for (int i = 0; i < 15; i++) {
                prob = Math.random();
                val = "String" + i;
                posR = r.nextInt(Prova.dim);
                if(prob < 0.7){ //70% - tra 0 e 0.7
                    int nInsert = c.inserisci(val);
                    System.out.println("Utente: "+id+" - Stringa inserita: "+ val + " - Num inserimento: "+ nInsert);
                    Thread.sleep(2000);
                } else if (prob < 0.9) { //20% - tra 0.7 e 0.9
                    String s = c.recupera(posR);
                    System.out.println("Utente: "+id+" - Stringa recuperata: "+ s);
                    Thread.sleep(2000);
                }else{ // 10% tra 0.9 e 1
                    c.cancella(posR);
                    System.out.println("Utente: "+id+" - Stringa in pos: "+ i +" cancellata.");
                    Thread.sleep(2000);
                }
            }

        } catch (InterruptedException | Inesistente e) {
            System.out.println("Stringa  inesistente.");
        }
    }




/* IMPLEMTAZIONE CON LO SWITCH
    public void run(){

        Random r = new Random();
        int scelta;
        String val;
        int pos = r.nextInt(9);
        try {
            for (int i = 0; i < 15; i++) {
                scelta = r.nextInt(3);
                val = "String" + i;
                switch (scelta) {
                    case 0:
                        int nInsert = c.inserisci(val);
                        System.out.println("Utente: "+id+" - Stringa inserita: "+ val + " - Num inserimento: "+ nInsert);
                        break;
                    case 1:
                        String s = c.recupera(pos);
                        System.out.println("Utente: "+id+" - Stringa recuperata: "+ s);
                        break;
                    case 2:
                        c.cancella(pos);
                        System.out.println("Utente: "+id+" - Stringa in pos: "+ i +" cancellata.");
                        break;
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException | Inesistente e) {
            System.out.println("Stringa in pos: "+pos+" inesistente.");
        }
    }

 */
}
