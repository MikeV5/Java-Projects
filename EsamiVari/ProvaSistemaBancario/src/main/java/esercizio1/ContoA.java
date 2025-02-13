package esercizio1;

import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.DisponibilitaInsufficiente;
import esercizio1.eccezioni.SommaNegativa;

public class ContoA extends Thread{
    private IBAN ibanA;
    private SistemaBancaInterface sistBanc;

    public ContoA(String codiceIban, SistemaBancaInterface sistBanc) throws SommaNegativa {
        ibanA = new IBAN(codiceIban,100);
        this.sistBanc = sistBanc;
    }

    public void run(){
        String id = "Conto: "+ibanA.getId();
        int randomM = 100;
        try {
            System.out.println(id + " - Provo a richiedere saldo corrente...");
            int saldo = sistBanc.saldo(ibanA);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(1000);

            System.out.println(id + " - Provo a fare un versamento...");
            sistBanc.versamento(ibanA, 100);
            System.out.println(id + " - Versamento di "+randomM+" riuscito.");
            Thread.sleep(1000);

            System.out.println(id + " - Provo a richiedere saldo corrente...");
            saldo = sistBanc.saldo(ibanA);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(1000);

            System.out.println(id + " - Provo a trasferire 50 a B...");
            sistBanc.trasferimento(ibanA,
                    SistemaBanca.contiCorrenti.get(1),50);
            System.out.println(id + " - Trasferimento di 50 a B riuscito.");
            Thread.sleep(1000);

            System.out.println(id + " - Provo a richiedere saldo corrente...");
            saldo = sistBanc.saldo(ibanA);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(1000);

        } catch (InterruptedException | DisponibilitaInsufficiente
                | ContoInesistente | SommaNegativa e) {
            if(e instanceof DisponibilitaInsufficiente)
                System.err.println(id + " - Saldo insufficiente.");
            else if (e instanceof ContoInesistente) {
                System.err.println(id + " - Conto Inesistente.");
            } else if (e instanceof SommaNegativa) {
                System.err.println(id + " - Somma negativo.");
            }
        }
    }
}
      //  System.out.println(id + " - Conto Inesistente.");
        //System.out.println(id + " - Versamento non riuscito.");
        //System.out.println(id + " - Trasferimento riuscito.");
       // System.out.println(id + " - Trasferimento non riuscito.");