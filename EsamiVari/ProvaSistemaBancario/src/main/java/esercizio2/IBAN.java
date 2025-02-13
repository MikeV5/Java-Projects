package esercizio2;

import esercizio1.eccezioni.SommaNegativa;

import java.io.Serializable;

public class IBAN implements Serializable {
    static final long serialVersionUID = 1L;
    private String id;
    private int saldo;

    public IBAN(String id, int saldo) throws SommaNegativa {
        this.id = id;
        if(saldo<0) throw new SommaNegativa();
        this.saldo = saldo;
    }
    public IBAN(String id) throws SommaNegativa {
        this(id,0);
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
