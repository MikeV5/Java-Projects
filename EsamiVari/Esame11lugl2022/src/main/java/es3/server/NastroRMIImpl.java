package es3.server;
import es1.noRead;
import es1.noWrite;
import es3.common.Nastro;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class NastroRMIImpl extends UnicastRemoteObject implements Nastro {
    private static final long serialVersionUID = 1L;
    private LinkedList<String> nastroContenitore;
    public static int posizioneCorrente;
    public NastroRMIImpl() throws RemoteException {
        nastroContenitore = new LinkedList<>();
        posizioneCorrente=0;
    }

    public static void main(String[] args) throws RemoteException {
        NastroRMIImpl obj = new NastroRMIImpl();
        Registry r = LocateRegistry.createRegistry(1099);
        r.rebind("NastroRMI",obj);
        System.out.println("Server ready...");

    }
    @Override
    // Inserisce una stringa nel nastro nella posizione corrente
    public synchronized void write(String s) throws noWrite {
        //Se pos = 0 e nastroContenitore.size() = 0 non dà errore
        if(nastroContenitore.size() > posizioneCorrente)
            throw new noWrite("Stringa già presente in posizione corrente");
        nastroContenitore.addLast(s);
        posizioneCorrente++;
    }
    @Override
    //Restituisce la stringa in posizione corrente
    public synchronized String read() throws noRead {
        //Quando pos = 0 e nastrocontenitore.size() = 0 darà errore
        //Perché non c'è niente da leggere
        //Il nastro può essere letto solo dopo il rewind()
        if( nastroContenitore.size() == posizioneCorrente)
            throw new noRead("Nessuna stringa presente in posizione corrente");
        return nastroContenitore.get(posizioneCorrente++);
    }
    @Override
    //Riporta la posizione corrente alla prima stringa del nastro
    //Per poter iniziare a leggere il nastro altrimenti non si può
    public synchronized void rewind() {
        posizioneCorrente=0;
    }
    @Override
    //Restituisce true se il nastro non contiene stringhe (vuoto)
    public synchronized boolean empty() {
        return nastroContenitore.isEmpty();
    }
    @Override
    public int getCurrentPosition() {
        return posizioneCorrente;
    }
}