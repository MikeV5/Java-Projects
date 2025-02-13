package esercizio1;

import java.util.ArrayList;

public class SistemaBancaImpl implements SistemaBancaInterface{
    private ArrayList<IBAN> contiCorrenti;

    public SistemaBancaImpl() {
       contiCorrenti = new ArrayList<IBAN>();
       contiCorrenti.add(new IBAN("A",100));
       contiCorrenti.add(new IBAN("B",200));
    }

    @Override
    public synchronized int saldo(IBAN idcc) throws ContoInesistente {
        int saldoC=0;
        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idcc.getId())) {
                saldoC = iban.getSaldo();
                return saldoC;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void versamento(IBAN idcc, int s) throws ContoInesistente, SommaNegativa {
        int saldoC=0;
        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idcc.getId())) {
                if(s < 0) throw new SommaNegativa();
                saldoC = iban.getSaldo();
                iban.setSaldo(saldoC + s);
                return;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void prelievo(IBAN idcc, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        int saldoC=0;
        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idcc.getId())) {
                if(s < 0) throw new SommaNegativa();
                saldoC = iban.getSaldo();
                if(s > saldoC) throw new DisponibilitaInsufficiente();
                iban.setSaldo(saldoC - s);
                return;
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized void trasferimento(IBAN idccFrom, IBAN idccTo, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente {
        int saldoA = 0;
        int saldoB = 0;
        IBAN tmpA = null;
        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idccFrom.getId())) {
                if(s < 0) throw new SommaNegativa();
                tmpA = iban;
                saldoA = iban.getSaldo();
                if(s > saldoA) throw new DisponibilitaInsufficiente();
                break;
            }
        }

        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idccTo.getId())) {
                saldoB = iban.getSaldo();
                if(tmpA!=null){
                    tmpA.setSaldo(saldoA - s);
                    iban.setSaldo(saldoB + s);
                    return;
                }
            }
        }
        throw new ContoInesistente();
    }

    @Override
    public synchronized boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente {
        int saldoBefore=0;
        int saldoAfter=0;
        IBAN tmp = null;
        boolean trovato = false;
        for (IBAN iban : contiCorrenti){
            if (iban.getId().equals(idcc.getId())) {
                saldoBefore = iban.getSaldo();
                tmp = iban;
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
