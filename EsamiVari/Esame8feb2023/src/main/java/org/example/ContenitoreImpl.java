package org.example;

public class ContenitoreImpl implements Contenitore{
    private int[] contenitore;
    private int dim;
    private int numElementi;
    private boolean cancellabile=false;

    public ContenitoreImpl(int max){
        contenitore = new int[max];
        dim = max;
        numElementi=0;
        cancellabile=false;
    }
    @Override
    public synchronized void inserisci(int num) throws InterruptedException {
        while(numElementi >= dim )wait();
        contenitore[numElementi++]=num;
        cancellabile=false;
        notifyAll(); //Una volta inserito un dato, vanno risvegliati i thread sospesi perché
        //il contenitore non è più vuoto
    }

    @Override
    public synchronized int somma() throws InterruptedException {
        int tot=0;
        while(numElementi==0) wait();
        for (int i = 0; i < numElementi; i++) {
            tot+=contenitore[i];
        }
        cancellabile=true;
        return tot;
    }

    @Override
    public synchronized void cancella() throws SommaNonCalcolata {
        if(!cancellabile) throw new SommaNonCalcolata("Somma non calcolata");
        numElementi=0;
        cancellabile=false;
        notifyAll();
    }
}
