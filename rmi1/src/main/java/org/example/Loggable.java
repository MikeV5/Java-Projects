package org.example;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Loggable extends Remote {
    boolean login(String nick) throws RemoteException;
    void logout(String nick) throws RemoteException;
}
