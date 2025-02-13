package esercizio2;

import java.io.Serializable;

public class IBAN_RMI implements Serializable {
    static final long serialVersionUID = 1L;
    private String id;
    private int saldo;

    public IBAN_RMI(String id, int saldo) {
        this.id = id;
        this.saldo = saldo;
    }
    public IBAN_RMI(String id) {
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
