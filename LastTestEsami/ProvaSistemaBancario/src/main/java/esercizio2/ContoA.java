package esercizio2;

import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.SommaNegativa;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ContoA extends Thread{
    private IBAN_RMI ibanRMIA;
    private SistemaBancaInterfaceRMI stub;

    public ContoA(String idccA) throws RemoteException, NotBoundException {
        ibanRMIA = new IBAN_RMI(idccA);
        Registry r = LocateRegistry.getRegistry();
        stub = (SistemaBancaInterfaceRMI) r.lookup("SistBanc");
    }


    public void run(){
        int saldoC = 0;
        int versam = 100;
        int prel = 100;
        int trasf = 100;
        try {
            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a verificare il saldo...");
            saldoC = stub.saldo(ibanRMIA);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a versare: "+versam);
            stub.versamento(ibanRMIA,versam);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - versato: "+versam);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a verificare il saldo...");
            saldoC = stub.saldo(ibanRMIA);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a prelevare...");
            stub.prelievo(ibanRMIA,prel);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - prelevato: "+prel);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a verificare il saldo...");
            saldoC = stub.saldo(ibanRMIA);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a trasferire a B...");
            IBAN_RMI ibanRMIB = new IBAN_RMI("B");
            stub.trasferimento(ibanRMIA, ibanRMIB,trasf);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " trasferito a B: "+trasf);

            System.out.println("Conto: "+ ibanRMIA.getId()+ " provo a verificare il saldo...");
            saldoC = stub.saldo(ibanRMIA);
            System.out.println("Conto: "+ ibanRMIA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

        } catch (ContoInesistente | SommaNegativa | InterruptedException | DisponibilitaInsufficiente | RemoteException e) {
            if (e instanceof  ContoInesistente)
                System.err.println("Conto inesistente.");
            else if (e instanceof SommaNegativa) {
                System.err.println("Somma negativa.");
            }else if (e instanceof DisponibilitaInsufficiente) {
                System.err.println("Disponibilità insufficiente.");
            }
        }

    }
}
