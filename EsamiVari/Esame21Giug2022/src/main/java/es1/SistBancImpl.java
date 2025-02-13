package es1;

import java.util.HashMap;
import java.util.LinkedList;

public class SistBancImpl implements SistemaBancarioInterface {
    private HashMap<IBAN, Integer> contiCorrenti;

    public SistBancImpl() {
        contiCorrenti = new HashMap<>();
    }

    public synchronized int saldo(IBAN idcc) throws ContoInesistente {
        if (!contiCorrenti.containsKey(idcc)) {
            throw new ContoInesistente();
        }
        return contiCorrenti.get(idcc);
    }

    public synchronized void versamento(IBAN idcc, int s) throws ContoInesistente, SommaNegativa {
        if (s < 0) {
            throw new SommaNegativa();
        }

        if (!contiCorrenti.containsKey(idcc)) {
            throw new ContoInesistente();
        }

        int saldoAttuale = contiCorrenti.get(idcc);
        contiCorrenti.put(idcc, saldoAttuale + s);

        // Notifica eventuali thread in attesa di questo conto corrente
        notifyAll();
    }

    public synchronized void prelievo(IBAN idcc, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        if (s < 0) {
            throw new SommaNegativa();
        }

        if (!contiCorrenti.containsKey(idcc)) {
            throw new ContoInesistente();
        }

        int saldoAttuale = contiCorrenti.get(idcc);
        if (saldoAttuale < s) {
            throw new DisponibilitaInsufficiente();
        }

        contiCorrenti.put(idcc, saldoAttuale - s);

        // Notifica eventuali thread in attesa di questo conto corrente
        notifyAll();
    }

    public synchronized void trasferimento(IBAN idccFrom, IBAN idccTo, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        prelievo(idccFrom, s);
        versamento(idccTo, s);
    }

    public synchronized boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente {
        try {
            // Attende per un massimo di 1 secondo o fino a quando non viene notificato
            wait(1000);
        } catch (InterruptedException e) {
            // Gestione dell'eccezione
        }
        return contiCorrenti.containsKey(idcc);
    }

    public synchronized void aggiungiConto(IBAN idcc) {
        contiCorrenti.put(idcc, 0);
    }
}