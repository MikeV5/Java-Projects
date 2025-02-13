package esercizio1;

public class Prova {
    static final int numCons = 5;

    public static void main(String[] args) {
        GestoreM g = new GestoreM();
        Produttore p = new Produttore(g);
        for (int i = 0; i < numCons; i++) {
            Consumatore c = new Consumatore(i+1,g);
            c.start();
        }
        p.start(); //Se lo metto prima non si fermerebbe la prod di messaggi
        // in quanto i consumatori non si sono registrati
    }
}
