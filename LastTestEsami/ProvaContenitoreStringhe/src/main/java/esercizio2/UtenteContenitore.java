package esercizio2;

import esercizio1.Contenitore;
import esercizio1.Inesistente;
import esercizio1.Pieno;

import java.util.Random;

public class UtenteContenitore extends Thread{
    private int id;
    private Contenitore ctn;

    public UtenteContenitore(int id, Contenitore ctn) {
        this.id = id;
        this.ctn = ctn;
    }

    public void run(){
        String str;
        Random r = new Random();
        int rand = 0;
        try {


            if(id ==1) {
                for (int i = 0; i < 6; i++) {
                    rand = r.nextInt(30) + 10;
                    str = "Testo" + rand;
                    System.out.println("Utente: " + id + " provo ad inserire...");
                    ctn.inserisci(str);
                    System.out.println("Utente: " + id + " stringa inserita: " + str);
                    Thread.sleep(500);
                }
            }
            if(id ==2) {
                System.out.println("Utente: " + id + " provo a cancellare...");
                ctn.cancella(0);
                System.out.println("Utente: " + id + " stringa cancellata: " + 0);
            }
           // System.out.println("Utente: "+id+" provo ad recuperare stringa con id: "+rand);
           // String strRecup = ctn.recupera(rand);
            //System.out.println("Utente: "+id+" stringa recuperata: "+strRecup);
            //Thread.sleep(1000);

        } catch (Pieno | InterruptedException | Inesistente e) {
            if (e instanceof Pieno)
                 System.err.println("Contenitore pieno.");
            else if (e instanceof Inesistente) {
                System.err.println("Identificatore inesistente.");
            }
        }
    }
}
