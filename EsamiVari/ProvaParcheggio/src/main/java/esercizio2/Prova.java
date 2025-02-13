package esercizio2;

import esercizio1.GestParcImpl;
import esercizio1.GestioneParcheggio;

public class Prova {
    final static int nPiani = 3;
    final static int mStalli = 5;
    final static int numThread = 40;
    public static void main(String[] args) throws InterruptedException {
        GestioneParcheggio gp = new GestParcImpl(nPiani, mStalli);
        for (int i = 0; i < numThread; i++) {
            Automobilista a = new Automobilista(i+1,gp);
            a.start();
            Thread.sleep(500);
        }
    }
}
