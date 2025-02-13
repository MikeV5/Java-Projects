package esercizio2;

import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.SommaNegativa;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SistemaBancaImplRMI extends UnicastRemoteObject implements SistemaBancaInterfaceRMI {
    static final long serialVersionUID = 1L;
    private ArrayList<IBAN_RMI> contiCorrenti;
    public SistemaBancaImplRMI() throws RemoteException {
        contiCorrenti = new ArrayList<IBAN_RMI>();
       contiCorrenti.add(new IBAN_RMI("A",100));
       contiCorrenti.add(new IBAN_RMI("B",200));
    }
    public static void main(String[] args) throws RemoteException {
        SistemaBancaInterfaceRMI obj = new SistemaBancaImplRMI();
        Registry r = LocateRegistry.createRegistry(1099);
        r.rebind("SistBanc",obj);
        System.out.println("Server pronto...");
    }
    @Override
    public synchronized int saldo(IBAN_RMI idcc) throws ContoInesistente {
        int saldoC=0;
        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idcc.getId())) {
                saldoC = ibanRMI.getSaldo();
                return saldoC;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void versamento(IBAN_RMI idcc, int s) throws ContoInesistente, SommaNegativa {
        int saldoC=0;
        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idcc.getId())) {
                if(s < 0) throw new SommaNegativa();
                saldoC = ibanRMI.getSaldo();
                ibanRMI.setSaldo(saldoC + s);
                return;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void prelievo(IBAN_RMI idcc, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        int saldoC=0;
        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idcc.getId())) {
                if(s < 0) throw new SommaNegativa();
                saldoC = ibanRMI.getSaldo();
                if(s > saldoC) throw new DisponibilitaInsufficiente();
                ibanRMI.setSaldo(saldoC - s);
                return;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void trasferimento(IBAN_RMI idccFrom, IBAN_RMI idccTo, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        int saldoA = 0;
        int saldoB = 0;
        IBAN_RMI tmpA = null;
        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idccFrom.getId())) {
                if(s < 0) throw new SommaNegativa();
                tmpA = ibanRMI;
                saldoA = ibanRMI.getSaldo();
                if(s > saldoA) throw new DisponibilitaInsufficiente();
                break;
            }
        }

        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idccTo.getId())) {
                saldoB = ibanRMI.getSaldo();
                if(tmpA!=null){
                    tmpA.setSaldo(saldoA - s);
                    ibanRMI.setSaldo(saldoB + s);
                    return;
                }
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized boolean attendiTrasferimento(IBAN_RMI idcc) throws ContoInesistente {
        int saldoBefore=0;
        int saldoAfter=0;
        IBAN_RMI tmp = null;
        boolean trovato = false;
        for (IBAN_RMI ibanRMI : contiCorrenti){
            if (ibanRMI.getId().equals(idcc.getId())) {
                saldoBefore = ibanRMI.getSaldo();
                tmp = ibanRMI;
                trovato = true;
                break;
            }
        }
        if (!trovato) throw new ContoInesistente();
        //Aspetto 5 secondi per l'arrivo di un trasferimento
        try {
            wait(5000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        saldoAfter = tmp.getSaldo();
        return saldoBefore != saldoAfter;
    }
}
