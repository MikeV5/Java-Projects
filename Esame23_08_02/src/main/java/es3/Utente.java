package es3;

import es1.Contenitore;
import es1.SommaNonCalcolata;

public class Utente extends Thread {
    private int id;
    private Contenitore c;

    public Utente(int n, Contenitore c) {
        id = n;
        this.c = c;

    }

    public void run() {
        try {
             for (int i = 1; i<10;i++) {
                double op = Math.random();
                if (op < 0.5) {
                    int val = id*10+ i;
                    c.inserisci(val);
                    System.out.println("Utente "+id+" - Inserito = "+val);
                }
                else if (op < 0.8) {
                    int val = c.somma();
                    System.out.println("Utente "+id+" - Somma = "+val);
                }
                else {
                    c.cancella();
                    System.err.println("Utente "+id+" - Cancello");
                }
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        } catch (SommaNonCalcolata e) {
            e.printStackTrace();
        }

    }

}
