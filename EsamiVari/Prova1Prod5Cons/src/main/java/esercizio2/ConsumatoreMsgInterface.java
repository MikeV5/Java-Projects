package esercizio2;

import esercizio1.ConsumatoreSconosciuto;
import esercizio1.GiaRegistrato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConsumatoreMsgInterface extends Remote {
    void signUp(int id) throws GiaRegistrato, RemoteException;
    Msg receive(int id) throws InterruptedException,
            ConsumatoreSconosciuto, RemoteException;
}
