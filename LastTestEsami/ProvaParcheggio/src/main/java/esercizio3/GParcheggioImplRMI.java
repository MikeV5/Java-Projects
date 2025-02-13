package esercizio3;
import esercizio1.NoStalliLiberi;
import esercizio1.PianoInesistente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GParcheggioImplRMI extends UnicastRemoteObject implements GestioneParcheggioRMI {
    static final long serialVersionUID = 1L;
    private Piano[] parcheggio;
    private int numPiani;
    private int postiLiberi;
    private int maxPosti;

    public GParcheggioImplRMI(int numPiani, int numStalli) throws RemoteException {
        this.numPiani = numPiani;
        parcheggio = new Piano[numPiani];
        for (int i = 0; i < numPiani; i++) {
            parcheggio[i] = new Piano(numStalli);
        }
        int dim = numStalli * numPiani;
        postiLiberi = dim;
        maxPosti = dim;
    }

    public static void main(String[] args) throws RemoteException {
        GParcheggioImplRMI obj = new GParcheggioImplRMI(3,5);
        Registry r = LocateRegistry.createRegistry(ServerSettings.PORT);
        r.rebind("GParcheggio",obj);
        System.out.println("Server pronto...");

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
