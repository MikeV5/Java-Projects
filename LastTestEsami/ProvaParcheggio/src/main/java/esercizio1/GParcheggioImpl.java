package esercizio1;

public class GParcheggioImpl implements GestioneParcheggio{
    private Piano[] parcheggio;
    private int numPiani;
    private int postiLiberi;
    private int maxPosti;

    public GParcheggioImpl(int numPiani, int numStalli) {
        this.numPiani = numPiani;
        parcheggio = new Piano[numPiani];
        for (int i = 0; i < numPiani; i++) {
            parcheggio[i] = new Piano(numStalli);
        }
        int dim = numStalli * numPiani;
        postiLiberi = dim;
        maxPosti = dim;
    }

    @Override
    public synchronized void ingresso() {
        while(postiLiberi == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //notifyAll();
        postiLiberi--;
    }

    @Override
    public synchronized void uscita() {
        postiLiberi++;
        notifyAll();
    }

    @Override
    public synchronized void parcheggia(int piano) throws PianoInesistente, NoStalliLiberi {
        if(piano < 0 || piano >= numPiani) throw new PianoInesistente();
        if (parcheggio[piano].getPostiLiberi() == 0) throw new NoStalliLiberi();
        parcheggio[piano].parcheggia();
    }

    @Override
    public synchronized void partenza(int piano) throws PianoInesistente {
        if(piano < 0 || piano >= numPiani) throw new PianoInesistente();
        parcheggio[piano].partenza();
    }

    @Override
    public synchronized int postiLiberi() {
        return postiLiberi;
    }

    @Override
    public synchronized int stalliLiberi(int piano) throws PianoInesistente {
        if(piano < 0 || piano >= numPiani) throw new PianoInesistente();
        return parcheggio[piano].getPostiLiberi();
    }
}
