package esercizio2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProvaRMI {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        ContoA cA = new ContoA("A");
        ContoB cB = new ContoB("B");
        cA.start();
        cB.start();
    }
}
