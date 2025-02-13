package es2.consumatore;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Prova {
    public static void main(String[] args) throws NotBoundException, RemoteException {
      Consumatore c = new Consumatore(Integer.parseInt(args[0]));
        c.start();
    }
}

