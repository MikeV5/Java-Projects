package esercizio3;

import esercizio1.noRead;
import esercizio1.noWrite;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class NastroImplRMI extends UnicastRemoteObject implements NastroRMI {
    static final long serialVersionUID = 1L;
    private LinkedList<String> nastro;
    private int posCorrente;

    public NastroImplRMI() throws RemoteException {
        nastro = new LinkedList<>();
        posCorrente = 0;
    }

    public static void main(String[] args) throws RemoteException {
        NastroImplRMI obj = new NastroImplRMI();
        Registry r = LocateRegistry.createRegistry(ServerSettings.PORT);
        r.rebind("Nastro",obj);
        System.out.println("Server pronto...");
    }

    @Override
    public synchronized void write(String s) throws noWrite {
        if(nastro.size() > posCorrente) throw new noWrite();
        nastro.addLast(s);
        posCorrente++;
    }

    @Override
    public synchronized String read() throws noRead {
        if(nastro.size() == posCorrente) throw new noRead();
        return nastro.get(posCorrente++);
    }

    @Override
    public synchronized void rewind() {
        if(nastro.size()!=0)
            posCorrente = 0;
    }

    @Override
    public synchronized boolean empty() {
        return nastro.isEmpty();
    }
}
