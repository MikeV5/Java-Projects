package es2.common;
import es1.DestinatarioPieno;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProduttoreMsgInterfaceRMI extends Remote {
    void send(Msg m) throws DestinatarioPieno, RemoteException;
}
