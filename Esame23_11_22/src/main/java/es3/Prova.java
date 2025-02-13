package es3;

import es1.Contenitore;
import es2.ContenitoreImpl;

public class Prova {
    public static final int dim = 8;
    public static final int numThread = 3;


    public static void main(String[] args) throws InterruptedException {
        Contenitore c = new ContenitoreImpl(dim);
        for (int i = 1; i <= numThread; i++) {
            Utente u = new Utente(i, c);
           u.start();
            Thread.sleep(500);
        }
    }
}
