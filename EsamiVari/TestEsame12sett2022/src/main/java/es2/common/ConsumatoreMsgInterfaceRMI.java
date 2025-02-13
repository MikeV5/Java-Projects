package es2.common;
import es1.ConsumatoreSconosciuto;
import es1.GiaRegistrato;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConsumatoreMsgInterfaceRMI extends Remote {
    void signUp(int id) throws GiaRegistrato, RemoteException;
    Msg receive(int id) throws InterruptedException,
            ConsumatoreSconosciuto, RemoteException;
}
