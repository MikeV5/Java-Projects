package esercizio2;

import esercizio1.Contenitore;
import esercizio1.Inesistente;
import esercizio1.Pieno;

public class ContenitoreImpl implements Contenitore {
    private String[] contenitore;
    private int maxElementi;
    private int numElementi;
    private int numInserimento;

    public ContenitoreImpl(int maxElementi) {
        contenitore = new String[maxElementi];
        this.maxElementi = maxElementi;
        numInserimento = 0;
        numElementi=0;
    }

    @Override
    public synchronized int inserisci(String s) throws InterruptedException {
        while(numElementi > maxElementi) wait();
        contenitore[numInserimento++] = s;
        numElementi++;
        notifyAll();
        return numInserimento;
    }

    @Override
    public synchronized String recupera(int n) throws Inesistente {
        for (int i = 0; i < numInserimento; i++) {
            if (contenitore[n].isEmpty()) throw new Inesistente();
        }
        return contenitore[n];
    }

    @Override
    public synchronized void cancella(int n) throws Inesistente {
        for (int i = 0; i < numInserimento; i++) {
            if (contenitore[n].isEmpty()) throw new Inesistente();
        }
        contenitore[n] = null;
        numElementi--;
        notifyAll();
    }
}
