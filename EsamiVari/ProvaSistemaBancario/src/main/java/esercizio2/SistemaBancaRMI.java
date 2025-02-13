package esercizio2;

import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.DisponibilitaInsufficiente;
import esercizio1.eccezioni.SommaNegativa;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class SistemaBancaRMI extends UnicastRemoteObject implements SistemaBancaInterfaceRMI {
    static final long serialVersionUID = 1L;

     static ArrayList<IBAN> contiCorrenti;

    public SistemaBancaRMI() throws SommaNegativa, RemoteException {
        contiCorrenti = new ArrayList<>();
        IBAN ibanA = new IBAN("A",100);
        IBAN ibanB = new IBAN("B",100);
        contiCorrenti.add(ibanA);
        contiCorrenti.add(ibanB);
    }
    public static void main(String[] args) throws RemoteException, SommaNegativa {
        Registry r = LocateRegistry.createRegistry(ServerSettings.PORT);
        SistemaBancaRMI stub = new SistemaBancaRMI();
        r.rebind("SistBanc",stub);
        System.out.println("Server pronto...");
    }
    @Override
    public synchronized int saldo(IBAN idcc) throws ContoInesistente {
        boolean contoPresente = false;
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idcc.getId())) {
                return iban.getSaldo();
            }
        }
        if(!contoPresente) throw new ContoInesistente();
        return 0;
    }

    @Override
    public synchronized void versamento(IBAN idcc, int s) throws ContoInesistente, SommaNegativa {
        boolean contoPresente = false;
        int saldo = 0;
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idcc.getId())) {
                contoPresente = true;
                saldo = iban.getSaldo();
                if(s < 0) throw new SommaNegativa();
                iban.setSaldo(saldo + s);
                break;
            }
        }
        if(!contoPresente) throw new ContoInesistente();
    }

    @Override
    public synchronized void prelievo(IBAN idcc, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        boolean contoPresente = false;
        int saldo = 0;
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idcc.getId())) {
                contoPresente = true;
                saldo = iban.getSaldo();
                if(s < 0) throw new SommaNegativa();
                if(s > saldo) throw new DisponibilitaInsufficiente();
                iban.setSaldo(saldo - s);
                break;
            }
        }
        if(!contoPresente) throw new ContoInesistente();
    }

    @Override
    public synchronized void trasferimento(IBAN idccFrom, IBAN idccTo, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        //Non posso fare questo perché se per esempio idccFrom esiste
        //e poi idccTo no, intanto ho già eseguito prelievo
        //prelievo(idccFrom,s);
        //versamento(idccTo,s);
        int checkConti = 0, posA=0, posB=0;
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idccFrom.getId())) {
                checkConti++;
                break;
            }
            posA++;
        }
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idccTo.getId())) {
                checkConti++;
                break;
            }
            posB++;
        }
        if(checkConti==2) {
            if (s < 0) throw new SommaNegativa();
            int saldoA = contiCorrenti.get(posA).getSaldo();
            if (s > saldoA) throw new DisponibilitaInsufficiente();
            int saldoB = contiCorrenti.get(posB).getSaldo();
            contiCorrenti.get(posA).setSaldo(saldoA - s);
            contiCorrenti.get(posB).setSaldo(saldoB + s);
        } else throw new ContoInesistente();
    }

    @Override
    public synchronized boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente{
        boolean contoPresente = false;
        int saldoBefore = 0;
        int pos=0;
        for (IBAN iban : contiCorrenti) {
            if (iban.getId().equals(idcc.getId())) {
                contoPresente = true;
                saldoBefore = iban.getSaldo();
                break;
            }
            pos++;
        }
        if(!contoPresente) throw new ContoInesistente();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int saldoAfter = contiCorrenti.get(pos).getSaldo();
        return saldoBefore != saldoAfter;
    }
}
