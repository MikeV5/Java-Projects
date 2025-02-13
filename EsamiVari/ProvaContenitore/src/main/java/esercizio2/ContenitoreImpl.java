package esercizio2;

import esercizio1.Contenitore;

import java.util.ArrayList;
import java.util.List;
public class ContenitoreImpl implements Contenitore {
    private  int[] contenitore;
    private int numElementi;
    private int maxElementi;
    public ContenitoreImpl(int maxElementi) {
       contenitore = new int[maxElementi];
        numElementi = 0;
        this.maxElementi = maxElementi;
    }

    @Override
    public synchronized void inserisci(int num) {
        while(numElementi >= maxElementi) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contenitore[numElementi++] = num;
        notifyAll(); // Risveglia somma()
    }

    @Override
    public synchronized int somma() {
        while(numElementi == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        int totale=0;
        for (int i = 0; i < numElementi; i++) {
            totale = totale + contenitore[i];
        }
        return totale;
    }

    @Override
    public synchronized void cancella() {
        numElementi = 0;
        notifyAll(); // Risveglia inserisci()
    }
}
