package es2;

import es1.GestioneParcheggio;
import es1.GestioneParcheggioImpl;

public class Prova {
    private static final int piani=3;
    private static final int stalli=5;
    private static final int numThreads = 20;
    public static void main(String[] args) throws InterruptedException {
        GestioneParcheggio gp = new GestioneParcheggioImpl(piani, stalli);
        for (int i = 0; i < numThreads; i++) {
            Automobilista am = new Automobilista(i+1,gp);
            am.start();
            Thread.sleep(500);
        }
    }
}
