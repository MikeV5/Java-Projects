package esercizio1;
import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.DisponibilitaInsufficiente;
import esercizio1.eccezioni.SommaNegativa;

public class ContoB extends Thread{
    private IBAN ibanB;
    private SistemaBancaInterface sistBanc;
    public ContoB(String codiceIban, SistemaBancaInterface sistBanc) throws SommaNegativa {
        ibanB = new IBAN(codiceIban,200);
        this.sistBanc = sistBanc;
    }

    public void run() {
        String id = "Conto: "+ibanB.getId();
        int randomM = 100;
        try {
            System.out.println(id + " - Provo a richiedere saldo corrente...");
            int saldo = sistBanc.saldo(ibanB);
            System.out.println(id + " - Saldo corrente: " + saldo);
            Thread.sleep(3000);

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
                | DisponibilitaInsufficiente | SommaNegativa e) {
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

