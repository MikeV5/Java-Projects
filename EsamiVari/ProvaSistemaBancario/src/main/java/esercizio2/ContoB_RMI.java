package esercizio2;

import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.DisponibilitaInsufficiente;
import esercizio1.eccezioni.SommaNegativa;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ContoB_RMI extends Thread{
    private IBAN ibanB;
    private SistemaBancaInterfaceRMI sistBanc;
    public ContoB_RMI(String codiceIban, SistemaBancaInterfaceRMI sistBanc) throws SommaNegativa {
        ibanB = new IBAN(codiceIban);
        this.sistBanc = sistBanc;
    }
    public static void main(String[] args) throws RemoteException, NotBoundException, SommaNegativa {
        Registry r = LocateRegistry.getRegistry();
        SistemaBancaInterfaceRMI stub =
                (SistemaBancaInterfaceRMI) r.lookup("SistBanc");
        ContoB_RMI contoB= new ContoB_RMI("B", stub);
        contoB.start();
    }

    public void run() {
        String id = "Conto: "+ibanB.getId();
        int randomM = 100;
        try {
            System.out.println(id + " - Provo a richiedere saldo corrente...");
            int saldo = sistBanc.saldo(ibanB);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(5000);

            boolean checkTrasferimento;
            System.out.println(id + " - Provo ad aspettare trasferimento da A...");
            checkTrasferimento =    sistBanc.attendiTrasferimento(ibanB);
            if(checkTrasferimento)
                System.out.println(id + " - Trasferimento da A a B riuscito.");
            else  System.err.println(id + " - Trasferimento da A a B non riuscito.");
            Thread.sleep(1000);

            System.out.println(id + " - Provo a fare un prelievo...");
            sistBanc.prelievo(ibanB, 100);
            System.out.println(id + " - Prelievo di "+100+" riuscito.");
            Thread.sleep(1000);

            System.out.println(id + " - Provo a richiedere saldo corrente...");
            saldo = sistBanc.saldo(ibanB);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(1000);

        } catch (InterruptedException | ContoInesistente
                | DisponibilitaInsufficiente | SommaNegativa
                | RemoteException e) {
            if (e instanceof ContoInesistente) {
                System.err.println(id + " - Conto Inesistente.");
            } else if (e instanceof SommaNegativa) {
                System.err.println(id + " - Somma negativo.");
            }else if (e instanceof DisponibilitaInsufficiente) {
                System.err.println(id + " - Saldo insufficiente.");
            }
        }
    }
}

