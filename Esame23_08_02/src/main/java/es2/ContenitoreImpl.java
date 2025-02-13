package es2;

import es1.Contenitore;
import es1.SommaNonCalcolata;

public class ContenitoreImpl implements Contenitore { //E' il gestore

    private int[] mem;
    private int max, numEl;
    private boolean cancellabile;

    public ContenitoreImpl(int dim) {
        mem = new int[dim];
        max = dim;
        numEl = 0;
        cancellabile = false;
    }

    @Override
    public synchronized void inserisci(int d) throws InterruptedException {
        while(numEl == max) wait();
        mem[numEl++] = d;
        cancellabile = false;
        notifyAll();
    }

    @Override
    public synchronized int somma() throws InterruptedException {
        int ris = 0;
        while(numEl == 0) wait();
        for(int i=0; i<numEl; i++)
            ris = ris + mem[i];
        cancellabile = true;
        return ris;
    }

    @Override
    public synchronized void cancella() throws SommaNonCalcolata {
        if (!cancellabile) throw new SommaNonCalcolata();
        numEl = 0;
        cancellabile = false;
        notifyAll();
    }
}