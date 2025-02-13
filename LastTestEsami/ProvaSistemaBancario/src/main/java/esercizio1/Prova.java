package esercizio1;

public class Prova {
    public static void main(String[] args) {
        SistemaBancaInterface s = new SistemaBancaImpl();
        ContoA cA = new ContoA("A",s);
        ContoB cB = new ContoB("B",s);
        cA.start();
        cB.start();
    }
}
