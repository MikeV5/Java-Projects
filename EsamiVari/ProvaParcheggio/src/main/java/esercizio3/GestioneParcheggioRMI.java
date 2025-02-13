package esercizio3;

import esercizio1.NoStalliLiberi;
import esercizio1.PianoInesistente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestioneParcheggioRMI extends Remote {
    void ingresso() throws RemoteException;
    void uscita() throws RemoteException;
    void parcheggia(int piano) throws PianoInesistente,
            NoStalliLiberi, RemoteException;
    void partenza(int piano) throws PianoInesistente, RemoteException;
    int postiLiberi() throws RemoteException;
    int stalliLiberi(int piano) throws PianoInesistente, RemoteException;
}
