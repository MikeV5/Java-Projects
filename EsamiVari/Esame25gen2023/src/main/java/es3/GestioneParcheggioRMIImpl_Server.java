package es3;
import es1.Piano;
import es1.PianoInesistente;
import es1.StalliNonLiberi;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GestioneParcheggioRMIImpl_Server extends UnicastRemoteObject implements GestioneParcheggioRMI {

    private Piano[] parcheggio;
    private int numPianiN;
    private int numPostiLiberi;
    private int maxPosti;
    private static final long serialVersionUID = 1L;

    protected GestioneParcheggioRMIImpl_Server(int n, int m) throws RemoteException {
        parcheggio = new Piano[n];
        for (int i = 0; i < n ; i++) {
            parcheggio[i] = new Piano(m);
        }
        this.numPianiN=n;
        maxPosti=n*m;
        numPostiLiberi=maxPosti;
    }
    public static void main(String[] args) throws RemoteException {
        //Creazione di un'istanza di GPRMIImpl con 3 piani e 5 stalli per il parcheggio
        GestioneParcheggioRMI gp = new GestioneParcheggioRMIImpl_Server(3,5);
        //Registry è un registro RMI che tiene traccia degli oggetti remoti disponibili

        // Impostazione delle proprietà di sistema per consentire la comunicazione tra il server e il client
       // System.setProperty("java.rmi.server.hostname", "localhost");
        //System.setProperty("java.rmi.server.useLocalHostname", "true");

        // Creazione e avvio del registro RMI sulla porta specificata
        Registry r = LocateRegistry.createRegistry(1099);

        // Ottenimento del riferimento al registro RMI locale
       // Registry r = LocateRegistry.getRegistry();

        //Registrazione dell'istanza gp nel registro RMI con il nome "GestoreParcheggio"
        //rebind(String name, Remote obj)
        //L'oggetto remoto diventa quindi disponibile per i client che cercano l'oggetto utilizzando il nome specificato.
        r.rebind("GestoreParcheggio",gp);
        System.out.println("Server ready...");
    }
    @Override
    public synchronized void ingresso() throws RemoteException {
        while(numPostiLiberi==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); ;
            }
        }
        numPostiLiberi--;
    }
    @Override
    public synchronized void uscita() throws RemoteException {
        numPostiLiberi++;
        notifyAll();
    }
    @Override
    public synchronized void parcheggia(int numPiano) throws StalliNonLiberi, PianoInesistente, RemoteException {
        if (numPiano < 0 || numPiano >= numPianiN) {
            throw new PianoInesistente("Errore! Piano inesistente");
        } else if (parcheggio[numPiano].stalliLiberi() == 0) {
            throw new StalliNonLiberi("Errore! Non ci sono stalli liberi nel piano");
        } else {
            parcheggio[numPiano].parcheggia();
        }
    }
    @Override
    public synchronized void partenza(int numPiano) throws PianoInesistente, RemoteException {
        if(numPiano<0 || numPiano>numPianiN) throw new PianoInesistente("Errore! Piano inesistente");
        parcheggio[numPiano].partenza();
    }
    @Override
    public synchronized int postiLiberi() throws RemoteException {
        return numPostiLiberi;
    }
    @Override
    public synchronized int stalliLiberi(int numPiano) throws PianoInesistente, RemoteException {
        if(numPiano<0 || numPiano>numPianiN) throw new PianoInesistente("Errore! Piano inesistente");
        return parcheggio[numPiano].stalliLiberi();
    }
}
