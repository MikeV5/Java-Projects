package es2;

import es1.Contenitore;
import es1.Inesistente;
import es1.Pieno;

import java.util.HashMap;

public class ContenitoreImpl implements Contenitore {
    private HashMap<Integer, String> mem;
    private int max;
    private int last; //numero di inserimento

    public ContenitoreImpl(int dim) {
        mem = new HashMap<Integer, String>();
        max = dim;
        last = 0;
    }
    public synchronized int inserisci(String s) throws Pieno {
        while(mem.size() == max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            last++;
            mem.put(last, s);
            notifyAll();
            return last;

    }
    public synchronized String recupera(int n) throws Inesistente {
        if (mem.containsKey(n))
            return mem.get(n); //Non c'è bisogno di segnalare altri thread (notifyAll())in quanto il contenitore non subisce alcuna modifica.
        else  throw new Inesistente(); //Se l'elemento non è presente, viene lanciata l'eccezione Inesistente
    }
    public synchronized void cancella(int n) throws Inesistente {
        if (mem.containsKey(n)) {
            mem.remove(n);
            notifyAll();
        }
        else
            throw new Inesistente();

    }
}
