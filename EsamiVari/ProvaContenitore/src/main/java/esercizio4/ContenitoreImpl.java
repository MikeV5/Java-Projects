package esercizio4;

public class ContenitoreImpl implements Contenitore {
    private  int[] contenitore;
    private int numElementi;
    private int maxElementi;
    private boolean cancellabile;
    public ContenitoreImpl(int maxElementi) {
       contenitore = new int[maxElementi];
        numElementi = 0;
        this.maxElementi = maxElementi;
        cancellabile = false;
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
        cancellabile = false; //Dopo che è stato inserito un elemento non posso
                              //eseguire cancella()
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
        cancellabile = true;
        return totale;
    }

    @Override
    public synchronized void cancella() throws SommanNonFatta {
        if(!cancellabile) throw new SommanNonFatta(); //Se non cancellabile (false)
        numElementi = 0;
        cancellabile = false;
        notifyAll(); // Risveglia inserisci()
    }
}
