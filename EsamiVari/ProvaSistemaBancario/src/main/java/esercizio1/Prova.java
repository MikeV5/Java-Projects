package esercizio1;

import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.SommaNegativa;

public class Prova {
    public static void main(String[] args) throws SommaNegativa, InterruptedException {
        SistemaBancaInterface sistB = new SistemaBanca();
        ContoA contoA = new ContoA("A",sistB);
        ContoB contoB = new ContoB("B",sistB);
        contoA.start();
        contoB.start();
        Thread.sleep(1000);
    }
}
