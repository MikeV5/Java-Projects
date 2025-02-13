package esercizio2;

import esercizio1.GParcheggioImpl;
import esercizio1.GestioneParcheggio;

public class ProvaParcheggio {
    static final int numThreads = 20;
    public static void main(String[] args) throws InterruptedException {
        //piani(3) esistenti --> 0 1 e 2
        GestioneParcheggio gp = new GParcheggioImpl(3,3);
        for (int i = 0; i < numThreads; i++) {
            Automobilista u = new Automobilista(i+1,gp);
            u.start();
            Thread.sleep(1000);
        }

    }
}
