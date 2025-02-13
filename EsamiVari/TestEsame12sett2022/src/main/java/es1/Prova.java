package es1;
public class Prova {
    public static final int maxCons = 5; //numero massimo di consumatori
    public static void main(String[] args) {
        GestoreM g = new GestoreM();
        Produttore p = new Produttore(g);
        // Avvia un ciclo for per creare e avviare i consumatori
        for (int i=0; i<maxCons; i++) {
            Consumatore c = new Consumatore(i,g);
            c.start();
        }
        p.start(); // Avvia il thread del produttore
    }
}

