package esercizio2;

import esercizio1.DestinatarioPieno;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProduttoreMsgInterface extends Remote {
    void send(Msg m) throws DestinatarioPieno, RemoteException;
}
