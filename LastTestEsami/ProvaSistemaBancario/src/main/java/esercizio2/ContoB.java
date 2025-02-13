package esercizio2;

import esercizio1.ContoInesistente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ContoB extends Thread{
    private IBAN_RMI ibanRMIB;
    private SistemaBancaInterfaceRMI stub;

    public ContoB(String idccB) throws RemoteException, NotBoundException {
        ibanRMIB = new IBAN_RMI(idccB);
        Registry r = LocateRegistry.getRegistry();
        stub = (SistemaBancaInterfaceRMI) r.lookup("SistBanc");
    }

    public void run(){
        int saldoC = 0;
        int versam = 100;
        int prel = 100;
        boolean trasferito = false;
        try {
            System.out.println("Conto: "+ ibanRMIB.getId()+ " provo a verificare il saldo...");
            saldoC = stub.saldo(ibanRMIB);
            System.out.println("Conto: "+ ibanRMIB.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIB.getId()+ " provo ad aspettare se c'è un trasferimento...");
            trasferito = stub.attendiTrasferimento(ibanRMIB);
            if (trasferito)
                System.out.println("Conto: "+ ibanRMIB.getId()+ " - avvenuto trasferimento.");
            else
                System.out.println("Conto: "+ ibanRMIB.getId()+ " non c'è stato nessun trasferimento.");

        } catch (ContoInesistente | InterruptedException | RemoteException e) {
            if (e instanceof  ContoInesistente)
                System.err.println("Conto inesistente.");
        }
    }
}
