package esercizio1;

import java.util.ArrayList;
import java.util.HashMap;

public class ContenitoreImpl implements Contenitore{
    private HashMap<Integer, String> contenitore;
    private int maxElementi;
    private int numElementi;

    public ContenitoreImpl(int maxElementi) {
        contenitore = new HashMap<Integer, String>();
        this.maxElementi = maxElementi;
        numElementi = 0;
    }

    @Override
    public synchronized int inserisci(String s) throws Pieno {
       if(numElementi >= maxElementi) throw new Pieno();
       contenitore.put(numElementi,s); //Lo metto in quella posizione
       return numElementi++;
    }

    @Override
    public synchronized String recupera(int n) throws Inesistente {
        if(!contenitore.containsKey(n)) throw new Inesistente();
        return contenitore.get(n);
    }

    @Override
    public synchronized void cancella(int n) throws Inesistente {
        if(!contenitore.containsKey(n)) throw new Inesistente();
        contenitore.remove(n);
    }
}
