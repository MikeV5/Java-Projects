package es1;

public class Utente extends Thread{
    private SistemaBancarioInterface sistemaBanca;
    private IBAN idcc;

    public Utente(SistemaBancarioInterface sistemaBanca, IBAN idcc) {
        this.sistemaBanca = sistemaBanca;
        this.idcc = idcc;
    }

    @Override
    public void run() {
        try {
            int saldo = sistemaBanca.saldo(idcc);
            System.out.println("Saldo del conto " + idcc.getCod() + ": " + saldo);

            sistemaBanca.versamento(idcc, 100);
            System.out.println("Versamento di 100 sul conto " + idcc.getCod());

            saldo = sistemaBanca.saldo(idcc);
            System.out.println("Saldo del conto " + idcc.getCod() + ": " + saldo);

            IBAN idccDestinatario = new IBAN("B");
            sistemaBanca.trasferimento(idcc, idccDestinatario, 50);
            System.out.println("Trasferimento di 50 dal conto " +
                    idcc.getCod() + " al conto " + idccDestinatario.getCod());

            saldo = sistemaBanca.saldo(idcc);
            System.out.println("Saldo del conto " + idcc.getCod() + ": " + saldo);

        } catch (ContoInesistente
                 | DisponibilitaInsufficiente | SommaNegativa e) {
            System.out.println("Errore");
        }
    }


    public static void main(String[] args) throws InterruptedException {

        IBAN idccA = new IBAN("A");
        IBAN idccB = new IBAN("B");
        SistemaBancarioInterface sistemaBancario = new SistBancImpl();
        sistemaBancario.aggiungiConto(idccA);
        sistemaBancario.aggiungiConto(idccB);
        // Creazione delle istanze degli utenti
        Utente utenteA = new Utente(sistemaBancario, idccA);
        Utente utenteB = new Utente(sistemaBancario, idccB);

        // Avvio dei thread degli utenti
        utenteA.start();

    }
}
