package esercizio2;

import esercizio1.Nastro;
import esercizio1.NastroImpl;

public class Prova {
    static final int maxThreads = 5;

    public static void main(String[] args) throws InterruptedException {
        Nastro n = new NastroImpl();
        for (int i = 0; i < 20; i++) {
            UtenteNastro u = new UtenteNastro(i+1,n);
            u.start();
            Thread.sleep(500);
        }
    }
}
