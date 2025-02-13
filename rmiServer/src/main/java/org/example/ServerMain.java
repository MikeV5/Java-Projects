package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain implements Loggable {
    static int PORT = 1234;

    public static void main( String[] args )
    {
        System.out.println( "Hello from Server!" );
        Loggable stub = null;

        ServerMain obj = new ServerMain();
        try {
            stub = (Loggable) UnicastRemoteObject.exportObject(
                        obj, PORT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // Bind the remote object's stub in the registry
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(PORT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            registry.bind("Loggable", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.err.println("Server ready");

    }

    @Override
    public boolean login(String nick) throws RemoteException {
        boolean result = nick.equals("ingconti");
        return result;
    }

    @Override
    public void logout(String nick) throws RemoteException {

    }
}
