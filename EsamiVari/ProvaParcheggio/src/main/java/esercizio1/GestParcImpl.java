package esercizio1;

import java.util.ArrayList;

public class GestParcImpl implements GestioneParcheggio{
    private Piano[] gparcheggio;
    private int nPiani;
    private int maxPosti;
    private int postiOccupati;

    public GestParcImpl(int nPiani, int mStalli) {
        int totale = nPiani * mStalli;
        gparcheggio = new Piano[nPiani];
        for (int i = 0; i < nPiani; i++) {
            gparcheggio[i] = new Piano(mStalli);
        }
        this.nPiani = nPiani;
        postiOccupati = 0;
        maxPosti = totale;
    }

    @Override
    public synchronized void ingresso() {
        while(postiOccupati >= maxPosti) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        postiOccupati++;
    }

    @Override
    public synchronized void uscita() {
        postiOccupati--;
        notifyAll();
    }

    @Override
    public synchronized void parcheggia(int piano) throws PianoInesistente, NoStalliLiberi {
       if(piano < 0 || piano > nPiani ) throw new PianoInesistente();
       if(stalliLiberi(piano)==0) throw new NoStalliLiberi();
       gparcheggio[piano].parcheggia();
    }

    @Override
    public synchronized void partenza(int piano) throws PianoInesistente {
        if(piano < 0 || piano > nPiani ) throw new PianoInesistente();
        gparcheggio[piano].partenza();
    }

    @Override
    public synchronized int postiLiberi() {
       return maxPosti - postiOccupati;
    }

    @Override
    public synchronized int stalliLiberi(int piano) throws PianoInesistente {
        if(piano < 0 || piano > nPiani ) throw new PianoInesistente();
       return gparcheggio[piano].getPostiLiberi();
    }
}
