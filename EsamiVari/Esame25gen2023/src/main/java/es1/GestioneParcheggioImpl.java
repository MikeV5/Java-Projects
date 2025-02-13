package es1;

public class GestioneParcheggioImpl implements GestioneParcheggio{
    private Piano[] parcheggio;
    private int numPianiN;
    private int numPostiLiberi;
    private int maxPosti;
    public GestioneParcheggioImpl(int n, int m){
        parcheggio = new Piano[n];
        for (int i = 0; i < n ; i++) {
            parcheggio[i] = new Piano(m);
        }
        this.numPianiN=n;
        maxPosti=n*m;
        numPostiLiberi=maxPosti;
    }
    public synchronized void ingresso() {
        while(numPostiLiberi==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); ;
            }
        }
        numPostiLiberi--;
    }
    public synchronized void uscita() {
        numPostiLiberi++;
        notifyAll();
    }
    public synchronized void parcheggia(int numPiano) throws StalliNonLiberi, PianoInesistente {
        if (numPiano < 0 || numPiano >= numPianiN) {
            throw new PianoInesistente("Errore! Piano inesistente");
        } else if (parcheggio[numPiano].stalliLiberi() == 0) {
            throw new StalliNonLiberi("Errore! Non ci sono stalli liberi nel piano");
        } else {
            parcheggio[numPiano].parcheggia();
        }
    }
    public synchronized void partenza(int numPiano) throws PianoInesistente {
        if(numPiano<0 || numPiano>numPianiN) throw new PianoInesistente("Errore! Piano inesistente");
        parcheggio[numPiano].partenza();
    }
    public synchronized int postiLiberi() {
        return numPostiLiberi;
    }
    public synchronized int stalliLiberi(int numPiano) throws PianoInesistente{
        if(numPiano<0 || numPiano>numPianiN) throw new PianoInesistente("Errore! Piano inesistente");
        return parcheggio[numPiano].stalliLiberi();
    }
}
