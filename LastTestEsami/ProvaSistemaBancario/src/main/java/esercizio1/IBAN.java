package esercizio1;

public class IBAN {
    private String id;
    private int saldo;

    public IBAN(String id, int saldo) {
        this.id = id;
        this.saldo = saldo;
    }
    public IBAN(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
