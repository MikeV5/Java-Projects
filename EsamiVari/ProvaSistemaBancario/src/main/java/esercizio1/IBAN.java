package esercizio1;

import esercizio1.eccezioni.SommaNegativa;

public class IBAN {
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
