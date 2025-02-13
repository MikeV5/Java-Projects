package esercizio1;

public class ContoA extends Thread{
    private IBAN ibanA;
    private SistemaBancaInterface banca;

    public ContoA(String idccA, SistemaBancaInterface banca) {
        ibanA = new IBAN(idccA);
        this.banca = banca;
    }

    public void run(){
        int saldoC = 0;
        int versam = 100;
        int prel = 100;
        int trasf = 100;
        try {
            System.out.println("Conto: "+ibanA.getId()+ " provo a verificare il saldo...");
            saldoC = banca.saldo(ibanA);
            System.out.println("Conto: "+ibanA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanA.getId()+ " provo a versare: "+versam);
            banca.versamento(ibanA,versam);
            System.out.println("Conto: "+ibanA.getId()+ " - versato: "+versam);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanA.getId()+ " provo a verificare il saldo...");
            saldoC = banca.saldo(ibanA);
            System.out.println("Conto: "+ibanA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanA.getId()+ " provo a prelevare...");
            banca.prelievo(ibanA,prel);
            System.out.println("Conto: "+ibanA.getId()+ " - prelevato: "+prel);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanA.getId()+ " provo a verificare il saldo...");
            saldoC = banca.saldo(ibanA);
            System.out.println("Conto: "+ibanA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanA.getId()+ " provo a trasferire a B...");
            IBAN ibanB = new IBAN("B");
            banca.trasferimento(ibanA,ibanB,trasf);
            System.out.println("Conto: "+ibanA.getId()+ " trasferito a B: "+trasf);

            System.out.println("Conto: "+ibanA.getId()+ " provo a verificare il saldo...");
            saldoC = banca.saldo(ibanA);
            System.out.println("Conto: "+ibanA.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

        } catch (ContoInesistente | SommaNegativa | InterruptedException | DisponibilitaInsufficiente e) {
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
