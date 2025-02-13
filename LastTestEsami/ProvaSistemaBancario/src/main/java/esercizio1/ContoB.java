package esercizio1;

public class ContoB extends Thread{
    private IBAN ibanB;
    private SistemaBancaInterface banca;

    public ContoB(String idccB, SistemaBancaInterface banca) {
        ibanB = new IBAN(idccB);
        this.banca = banca;
    }

    public void run(){
        int saldoC = 0;
        int versam = 100;
        int prel = 100;
        boolean trasferito = false;
        try {
            System.out.println("Conto: "+ibanB.getId()+ " provo a verificare il saldo...");
            saldoC = banca.saldo(ibanB);
            System.out.println("Conto: "+ibanB.getId()+ " - saldo: "+saldoC);
            Thread.sleep(1000);

            System.out.println("Conto: "+ibanB.getId()+ " provo ad aspettare se c'è un trasferimento...");
            trasferito = banca.attendiTrasferimento(ibanB);
            if (trasferito)
                System.out.println("Conto: "+ibanB.getId()+ " - avvenuto trasferimento.");
            else
                System.out.println("Conto: "+ibanB.getId()+ " non c'è stato nessun trasferimento.");

        } catch (ContoInesistente | InterruptedException e) {
            if (e instanceof  ContoInesistente)
                System.err.println("Conto inesistente.");
        }
    }
}
