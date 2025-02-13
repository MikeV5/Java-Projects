package esercizio1;

import java.util.ArrayList;
import java.util.Hashtable;

public class ContenitoreImpl implements Contenitore{
    private String[] contenitore;
    private int numElementi;
    private int maxElementi;
    private int numInserimento;

    public ContenitoreImpl(String[] contenitore, int maxElementi) {
        contenitore = new String[maxElementi];
        this.maxElementi = maxElementi;
        numInserimento = 0;
        numElementi = 0;
    }

    @Override
    public synchronized int inserisci(String s) throws Pieno {
        if(numElementi >= maxElementi) throw new Pieno();
        contenitore[numInserimento] = s;
        return numInserimento++;
    }

    @Override
    public synchronized String recupera(int n) throws Inesistente {

        for (int i = 0; i < contenitore.length; i++) {
            if (contenitore[n].isEmpty()) throw new Inesistente();
        }
        return contenitore[n];
    }

    @Override
    public synchronized void cancella(int n) throws Inesistente {
        for (int i = 0; i < contenitore.length; i++) {
            if (contenitore[n].isEmpty()) throw new Inesistente();
        }
        contenitore[n] = null;
    }
}
