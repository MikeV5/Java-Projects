package es3;
import es1.PianoInesistente;
import es1.StalliNonLiberi;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface GestioneParcheggioRMI extends Remote {
    void ingresso() throws RemoteException;
    void uscita() throws RemoteException;
    void parcheggia(int piano) throws StalliNonLiberi, PianoInesistente, RemoteException;
    void partenza(int piano) throws PianoInesistente ,RemoteException;
     int postiLiberi() throws RemoteException;
    int stalliLiberi(int piano) throws PianoInesistente ,RemoteException;
}
